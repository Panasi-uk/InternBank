package com.projeto.InternBank.db.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.InternBank.db.dto.TransacoesDTO;
import com.projeto.InternBank.db.models.Transacoes;
import com.projeto.InternBank.db.repositories.TransacoesRepository;
import com.projeto.InternBank.db.services.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.projeto.InternBank.db.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping
    public List<Transacoes> getAllTransacoes() {
        return transacoesService.getAllTransacoes();
    }

    @GetMapping("/{id}")
    public Transacoes getTransacaoById(@PathVariable Long id) {
        return transacoesService.getTransacaoById(id);
    }

    @PostMapping
    public Transacoes createTransacao(@RequestBody Transacoes transacoes) {
        return transacoesService.createTransacao(transacoes);
    }

    @PutMapping("/{id}")
    public Transacoes updateTransacao(@PathVariable Long id, @RequestBody Transacoes transacoes) {
        return transacoesService.updateTransacao(id, transacoes);
    }

    @DeleteMapping("/{id}")
    public void deleteTransacao(@PathVariable Long id) {
        transacoesService.deleteTransacao(id);
    }
}
