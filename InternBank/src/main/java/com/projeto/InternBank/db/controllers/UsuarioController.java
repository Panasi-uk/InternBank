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
import org.springframework.web.bind.annotation.GetMapping;
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
//analisar possibilidade do CrossOrigin
public class UsuarioController {
		@Autowired 
		private UsuarioService usuarioService;
	
		@Autowired
		private AuthenticationManager authenticationManager;
		
		@PostMapping("/login")
		
		//criar um dto
		public ResponseEntity<?> login(@RequestBody UsuarioLoginDTO 		usuarioLoginDto){	
			try {
				Authentication authentication = authenticationManager
						.authenticate( 
						new UsernamePasswordAuthenticationToken(

										usuarioLoginDto.getEmail(),
										usuarioLoginDto.getSenha()

										)
									);
				
				SecurityContextHolder.getContext()
				.setAuthentication(authentication);
				
				Map<String, String> response = new HashMap<>();
				response.put("message", "Login bem sucedido");
				return ResponseEntity.ok(response);
				
			}catch(Exception e){	
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("error", "Falha ao fazer login: " + 				e.getMessage());
				
		
				return ResponseEntity
						.status(HttpStatus.UNAUTHORIZED)
						.body(errorResponse);
			}
		}
			
		
		@PostMapping("/cadastro")
		public ResponseEntity<?> createNewUsuario(
				@Valid @RequestBody CadastroDTO cadastroDto,
				BindingResult bindingResult, //auxilia na captura de erros de 				validação
				@RequestParam String roleName // receber o nome da role/papel do 				user como param da requeisição
				){ 
			

			//verify se ja existe um user com o msm email q esta sendo cadastrado
			Usuario usuarioExists = 			usuarioService.findUserByEmail(cadastroDto.getEmail());

			
			//verify a existencia do email
			
			if(usuarioExists != null) {
				bindingResult.rejectValue("email", "error.usuario", "Já existe um u				suario cadastrado com esse email");
			}
			//verificar erros em relsçap a validacao dos dados
			
			if(bindingResult.hasErrors()) {
				//criar um mapeamento para armazenar os erros de validação
				Map<String, String> errors = new HashMap<>();
				for(FieldError error: bindingResult.getFieldErrors()) {
					errors.put(error.getField(), error.getDefaultMessage());
				}
				//return do if
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
			
			
			usuarioService.saveUsuario(usuario, roleName);
			
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
		@GetMapping("/current-usuario")
		public String getLoggedInUser () {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
		}
}
