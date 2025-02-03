package com.projeto.InternBank.db.models;


import jakarta.persistence.*;
import java.math.BigDecimal;
 
@Entity
@Table(name = "Transferencia")
public class Transferencia {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Transferencia_id")
    private Long id;
 
    @Column(name = "Entrada")
    private BigDecimal entrada;
 
    @Column(name = "Saida")
    private BigDecimal saida;
 
    @ManyToOne
    @JoinColumn(name = "Saldo_id", nullable = false)
    private Saldo saldo;
 
    @ManyToOne
    @JoinColumn(name = "Conta_id", nullable = false)
    private Conta conta;
 
    @ManyToOne
    @JoinColumn(name = "Usuario_id", nullable = false)
    private Usuario usuario;
 
    // Getters e Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
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
 
    public Saldo getSaldo() {
        return saldo;
    }
 
    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }
 
    public Conta getConta() {
        return conta;
    }
 
    public void setConta(Conta conta) {
        this.conta = conta;
    }
 
    public Usuario getUsuario() {
        return usuario;
    }
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
