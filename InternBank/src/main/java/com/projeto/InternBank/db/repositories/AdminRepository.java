package com.projeto.InternBank.db.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Admin;
import com.projeto.InternBank.db.services.UsuarioService;

public interface AdminRepository extends JpaRepository <Admin, String>{
	
	Admin findByUsuarios(Admin usuarios);
	//Admin findBySenha(String senha);
	//Usuario findByEmail(String email);
	Admin findByadminId(String string);
}
