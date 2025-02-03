package com.projeto.InternBank.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long>{
	Admin findById(String Id);
	Admin findBySenha(String senha);
}
