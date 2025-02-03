package com.projeto.InternBank.db.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pagamento")
public class Pagamento {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pagamentoId;
 
    @Column(name = "Entrada", nullable = true)
    private BigDecimal entrada;
 
    @Column(name = "Saida", nullable = true)
    private BigDecimal saida;
 
    @ManyToOne
    @JoinColumn(name = "saldo_id", nullable = false)
    private Saldo saldo;
 
    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;
 
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

	public Integer getPagamentoId() {
		return pagamentoId;
	}

	public void setPagamentoId(Integer pagamentoId) {
		this.pagamentoId = pagamentoId;
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