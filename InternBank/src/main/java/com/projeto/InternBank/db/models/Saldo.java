package com.projeto.InternBank.db.models;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Saldo")
public class Saldo {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saldoId;
 
    @Column(name="Visualizacao", nullable = false)
    private BigDecimal visualizacao;
 
    //muitos saldos para uma conta
    @ManyToOne
    @JoinColumn(name = "Conta_id", nullable = false)
    private Conta conta;

    @OneToMany(mappedBy = "saldo")
    private Set<Saque> saques = new HashSet<>();

    @OneToMany(mappedBy = "saldo")
    private Set<Pagamento> pagamentos = new HashSet<>();

    @OneToMany(mappedBy = "saldo")
    private Set<Pix> pix = new HashSet<>();

   @OneToMany(mappedBy = "saldo")
   private Set<Deposito> deposito =  new HashSet<>();
   
   @OneToMany(mappedBy = "saldo")
   private Set<Transferencia> transferencias = new HashSet<>();
   
   public Set<Transferencia> getTransferencias() {
	return transferencias;
}

public void setTransferencias(Set<Transferencia> transferencias) {
	this.transferencias = transferencias;
}

public Set<Saque> getSaques() {
	return saques;
}

public void setSaques(Set<Saque> saques) {
	this.saques = saques;
}

public Set<Pagamento> getPagamentos() {
	return pagamentos;
}

public void setPagamentos(Set<Pagamento> pagamentos) {
	this.pagamentos = pagamentos;
}

public Set<Pix> getPix() {
	return pix;
}

public void setPix(Set<Pix> pix) {
	this.pix = pix;
}


public Set<Deposito> getDeposito(){
		return deposito;
	}
	
	public void setDeposito(Set<Deposito> deposito) {
       this.deposito = deposito;
   }

    
	public Integer getSaldoId() {
		return saldoId;
	}

	public void setSaldoId(Integer saldoId) {
		this.saldoId = saldoId;
	}

	public BigDecimal getVisualizacao() {
		return visualizacao;
	}

	public void setVisualizacao(BigDecimal visualizacao) {
		this.visualizacao = visualizacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
 
    
   
}
