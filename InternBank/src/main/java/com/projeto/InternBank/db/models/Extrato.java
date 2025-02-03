package com.projeto.InternBank.db.models;
//Classe de entidade para Extrato

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Extrato")
public class Extrato {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "Extrato_id")
 private Long id;

 @Column(name = "Data", nullable = false)
 private LocalDateTime data;

 @Column(name = "Entrada")
 private BigDecimal entrada;

 @Column(name = "Saida")
 private BigDecimal saida;

 @ManyToOne
 @JoinColumn(name = "Transacoes_id")
 private Transacoes transacao;

 // Getters e Setters
 public Long getId() {
     return id;
 }

 public void setId(Long id) {
     this.id = id;
 }

 public LocalDateTime getData() {
     return data;
 }

 public void setData(LocalDateTime data) {
     this.data = data;
 }

 public BigDecimal getEntrada() {
     return entrada;
 }

 public void setEntrada(BigDecimal entrada) {
     this.entrada = entrada;
 }

 public BigDecimal getSaida() {
     return saida;
 }

 public void setSaida(BigDecimal saida) {
     this.saida = saida;
 }

 public Transacoes getTransacao() {
     return transacao;
 }

 public void setTransacao(Transacoes transacao) {
     this.transacao = transacao;
 }
}