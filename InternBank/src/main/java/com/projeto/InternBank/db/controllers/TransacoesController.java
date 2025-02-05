package com.projeto.InternBank.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.projeto.InternBank.db.dto.TransacoesDTO;
import com.projeto.InternBank.db.models.Transacoes;
import com.projeto.InternBank.db.repositories.TransacoesRepository;
import com.projeto.InternBank.db.services.TransacoesService;
import com.projeto.InternBank.db.services.UsuarioService;

import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping
    public ResponseEntity<List<Transacoes>> getAllTransacoes() {
        List<Transacoes> transacoes = transacoesService.getAllTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacoes> getTransacaoById(@PathVariable Long id) {
        return transacoesService.getTransacaoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Transacoes> createTransacao(@RequestBody Transacoes transacao) {
        try {
            Transacoes novaTransacao = transacoesService.createTransacao(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacoes> updateTransacao(@PathVariable Long id, @RequestBody Transacoes transacao) {
        try {
            Transacoes transacaoAtualizada = transacoesService.updateTransacao(id, transacao);
            return ResponseEntity.ok(transacaoAtualizada);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransacao(@PathVariable Long id) {
        if (transacoesService.deleteTransacao(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
