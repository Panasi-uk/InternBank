package com.projeto.InternBank.db.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Usuario;


public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
	Usuario findByAgencia(String agencia);
//	Usuario findByNumeroConta(String numeroConta);
	Usuario findByConta_NumeroConta(String numeroConta); // Corrigido para refletir a relação
	Usuario findBySenha(String senha);
	Usuario findByCpf(String cpf);
	Usuario findEmail(String email);
//	Optional<Usuario> findByRole(String role);
	List<Usuario> findByRolesContaining(String role);

	Optional<Usuario> findByEmail(String email); 

}