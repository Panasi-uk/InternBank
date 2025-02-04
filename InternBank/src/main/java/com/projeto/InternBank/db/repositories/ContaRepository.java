package com.projeto.InternBank.db.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.InternBank.db.models.Conta;
import com.projeto.InternBank.db.models.Usuario;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Conta findByAgencia(String agencia);
    Conta findByNumeroConta(String numeroConta);
    Optional<Conta> findByEmail(String email);
    Conta findByUsuario(Usuario usuario); // Para encontrar uma conta baseada no usuário
}
