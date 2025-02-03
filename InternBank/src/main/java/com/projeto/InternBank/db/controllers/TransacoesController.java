package com.projeto.InternBank.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.InternBank.db.dto.TransacoesDTO;
import com.projeto.InternBank.db.repositories.TransacoesRepository;
import com.projeto.InternBank.db.services.UsuarioService;

@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {
	
	@Autowired
	private UsuarioService userService;
	
	@Autowired
	private TransacoesRepository transacoesRepository;
	
	
	/*@GetMapping("/getTransacoes")
	public ResponseEntity<List<TransacoesDTO>> getAllTransacoes(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		

		
	}*/
}
