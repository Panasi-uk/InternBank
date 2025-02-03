package com.projeto.InternBank.db.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transacoes")
public class Transacoes {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transacoes_id;
 
    @ManyToOne
    @JoinColumn(name = "Pix_id")
    private Pix pix;
 
    @ManyToOne
    @JoinColumn(name = "Pagamento_id")
    private Pagamento pagamento;
 
    @ManyToOne
    @JoinColumn(name = "Deposito_id")
    private Deposito deposito;
 
    @ManyToOne
    @JoinColumn(name = "Extrato_id")
    private Extrato extrato;
 
    @ManyToOne
    @JoinColumn(name = "Saque_id")
    private Saque saque;
 
    @ManyToOne
    @JoinColumn(name = "Conta_id", nullable = false)
    private Conta conta;
    
	public Integer getTransacoes_id() {
		return transacoes_id;
	}

	public void setTransacoes_id(Integer transacoes_id) {
		this.transacoes_id = transacoes_id;
	}

	public Pix getPix() {
		return pix;
	}

	public void setPix(Pix pix) {
		this.pix = pix;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Extrato getExtrato() {
		return extrato;
	}

	public void setExtrato(Extrato extrato) {
		this.extrato = extrato;
	}

	public Saque getSaque() {
		return saque;
	}

	public void setSaque(Saque saque) {
		this.saque = saque;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}


	
    
    //Validações
}