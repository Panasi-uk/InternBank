package com.projeto.InternBank.db.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projeto.InternBank.db.models.Usuario;
import com.projeto.InternBank.db.repositories.AdminRepository;
import com.projeto.InternBank.db.repositories.UsuarioRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

	//inserir dependence injections
	//1° entities
	@Autowired 
	private AdminRepository adminRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//2° classe que possibilita a criação de hash de senha
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//praticar método do service que fará busca de um email
	
	public Usuario findUserByEmail(String email) {
		return usuarioRepository.findEmail(email);
	}
	
	public Usuario findUserById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	//////////////codigo adaptado//////////////
	@Transactional
	public void saveUsuario(Usuario usuario, String roleName) {
	    usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
	    usuario.setEnabled(true);
	    if(roleName == null || (!roleName.equals("ROLE_ADMIN") && !roleName.equals("ROLE_USER"))) {
	        roleName = "ROLE_USER"; // Role padrão se não informado
	    }
	    usuario.setRole(roleName); // Continua tratando role como string
	    usuarioRepository.save(usuario);
	    System.out.println("Usuário cadastrado com sucesso! " + usuario.getEmail());
	}

	//carregar/buscar usuário por email/nome spring security
	@Override
	public UserDetails loadUserByUsername(String email) throws 	UsernameNotFoundException{
		Usuario usuario = usuarioRepository.findEmail(email);
		//verificar o valor de usuario
		if(usuario == null) {
			throw new UsernameNotFoundException("Email do usuário não encontrado: " + email);
		}
	    Set<String> roles = new HashSet<>();
	    roles.add(usuario.getRole()); 
	    
		return new org.springframework.security.core.userdetails.User(
				usuario.getEmail(),
				usuario.getSenha(),
				getUserAuthority(roles)
				
				);
	}
	//definir método getUserAuthority(), para aplicar aos roles um processo 	de conversão de papéis de usuário para um contexto de autoridade do 	spring; assim, as roles serão entendidas como níveis de acesso/restrição 	de uso do sistema por usuários com determinadas classificações 
	private List<GrantedAuthority> getUserAuthority(Set<String> usuarioRoles){
		Set<GrantedAuthority> roles = new HashSet<>();
		usuarioRoles.forEach((role) -> {
			roles.add(new SimpleGrantedAuthority(role));
		});
		
		return new ArrayList<>(roles);
	}
	public List<Usuario> buscarPorRole(String role) {
	    return usuarioRepository.findByRolesContaining(role);
	}

		
}
	


