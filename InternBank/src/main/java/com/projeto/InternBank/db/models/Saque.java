package com.projeto.InternBank.db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Column;
import java.math.BigDecimal;

@Entity
@Table(name = "Saque")
public class Saque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saqueId;

    @Column(name="Entrada", nullable = true)
    private BigDecimal entrada;

    @Column(name="Saida", nullable = true)
    private BigDecimal saida;

    @ManyToOne
    @JoinColumn(name = "saldo_id", nullable = false, foreignKey = @ForeignKey(name = "FK_saque_saldo"))
    private Saldo saldo;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false, foreignKey = @ForeignKey(name = "FK_saque_conta"))
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_saque_usuario"))
    private Usuario usuario;

    // Getters and Setters
    public Integer getSaqueId() {
        return saqueId;
    }

    public void setSaqueId(Integer saqueId) {
        this.saqueId = saqueId;
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
