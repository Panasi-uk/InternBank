package com.projeto.InternBank.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.projeto.InternBank.db.models.Transacoes;

public interface TransacoesRepository extends JpaRepository <Transacoes, Long>{
	List<Transacoes> findByUserId(@Param("transacoes_id") Long transacoesId);
	
	Transacoes findById(final Integer id);
}
