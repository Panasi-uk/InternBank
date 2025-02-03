package com.projeto.InternBank.db.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.InternBank.db.dto.UsuarioLoginDTO;
import com.projeto.InternBank.db.services.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.projeto.InternBank.db.dto.CadastroDTO;
import com.projeto.InternBank.db.models.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
		@Autowired 
		private UsuarioService serviceUsuario;
	
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@PostMapping("/login")
		
		//criar um dto
		public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO usuariologinDto){
			
			try {
				
				Authentication authentication = authenticationManager.authenticate( 
						new UsernamePasswordAuthenticationToken(
										usuariologinDto.getAgenciaconta(),
										usuariologinDto.getSenha()
										)
					);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				Map<String, String> response = new HashMap<>();
				response.put("message", "Login bem sucedido");
				return ResponseEntity.ok(response);
				
			}catch(Exception e){
				
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("error", "Falha ao fazer login: " + e.getMessage());
				
		
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
			}
		}
			
		
		@PostMapping("/cadastro")
		public ResponseEntity<?> createNewUsuario(
					@Valid @RequestBody CadastroDTO cadastroDto,
					BindingResult bindingResult, //auxilia na captura de erros de validação
					@RequestParam String roleName // receber o nome da role/papel do usuer como param da requeisição
				){ 
			
			//veerify se ja existe um usuer com o msm email q esta sendo cadastrado
			Usuario usuarioExists = serviceUsuario.findUserByCpf(cadastroDto.getCpf());
			
			//verify a existencia do email
			
			if(usuarioExists != null) {
				bindingResult.rejectValue("cpf", "error.usuario", "Já existe um usuario cadastrado com esse cpf");
			}
			//verificar erros em relsçap a validacao dos dados
			
			if(bindingResult.hasErrors()) {
				//criar um mapeamento para armazenar os erros de validação
				Map<String, String> errors = new HashMap<>();
				for(FieldError error: bindingResult.getFieldErrors()) {
					errors.put(error.getField(), error.getDefaultMessage());
				}
				//def o return do if
				return ResponseEntity.badRequest().body(errors);
			}
			
			//bloco de criação do novo registro de usuario
			Usuario usuario = new Usuario();
			usuario.setNome(cadastroDto.getNome());
			usuario.setCpf(cadastroDto.getCpf());
			usuario.setEmail(cadastroDto.getEmail());
			usuario.setTelefone(cadastroDto.getTelefone());
			usuario.setEndereco(cadastroDto.getEndereco());
			usuario.setCep(cadastroDto.getCep());
			usuario.setBairro(cadastroDto.getBairro());
			usuario.setCidade(cadastroDto.getCidade());
			usuario.setNumero(cadastroDto.getNumero());
			usuario.setSenha(cadastroDto.getSenha());
			
			
			serviceUsuario.saveUsuario(usuario, roleName);
			
			Map<String, String> response = new HashMap<>();
			response.put("message", "Usuario cadastrado com sucesso!");
			
			return ResponseEntity.ok(response);
		}
		
		@PostMapping("/logout")
		public ResponseEntity<Void> logout(
				HttpServletRequest request, HttpServletResponse response
				){
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(authentication != null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
				System.out.println("Sucesso ao deslogar o usuario: " + authentication.getName());
			}else {
				System.out.println("Tentativa de logout sem usuario autenticado");
			}
			
			return ResponseEntity.noContent().build();
		}
}
