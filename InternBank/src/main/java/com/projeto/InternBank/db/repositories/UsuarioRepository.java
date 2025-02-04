package com.projeto.InternBank.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	Usuario findByAgencia(String agencia);
	Usuario findByNumeroConta(String numeroConta);
	//Usuario findBySenha(String senha);
	Usuario findByCpf(String cpf);
	Usuario findByEmail(String email);

}
