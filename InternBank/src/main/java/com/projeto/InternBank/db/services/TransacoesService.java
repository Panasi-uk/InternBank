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

    public Transacoes getTransacaoById(Long id) {
        Optional<Transacoes> transacao = transacoesRepository.findById(id);
        return transacao.orElse(null);
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

    public void deleteTransacao(Long id) {
        transacoesRepository.deleteById(id);
    }
}
