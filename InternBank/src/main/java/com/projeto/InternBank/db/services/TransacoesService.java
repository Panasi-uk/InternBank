package com.projeto.InternBank.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.InternBank.db.models.Conta;
import com.projeto.InternBank.db.models.Transacoes;
import com.projeto.InternBank.db.models.Usuario;
import com.projeto.InternBank.db.repositories.ContaRepository;
import com.projeto.InternBank.db.repositories.TransacoesRepository;
import com.projeto.InternBank.db.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;

    public List<Transacoes> getAllTransacoes() {
        return transacoesRepository.findAll();
    }

    public Optional<Transacoes> getTransacaoById(Long id) {
        return transacoesRepository.findById(id);
    }

    public Transacoes createTransacao(Transacoes transacoes) {
        return transacoesRepository.save(transacoes);
    }

    public Transacoes updateTransacao(Long id, Transacoes transacoes) {
        if (transacoesRepository.existsById(id)) {
         //   transacoes.setId(id);
            return transacoesRepository.save(transacoes);
        }
        return null;
    }

    public boolean deleteTransacao(Long id) {
        if (transacoesRepository.existsById(id)) {
            transacoesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
