package com.projeto.InternBank.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Admin;
import com.projeto.InternBank.db.models.Usuario;

public interface AdminRepository extends JpaRepository <Admin, Long>{
	Admin findById(String Id);
	Admin findByUsuario(Usuario usuario);
	//Admin findBySenha(String senha);
	Usuario findByEmail(String email);
}
