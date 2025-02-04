package com.projeto.InternBank.db.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Conta")
public class Conta {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contaId;
 
    @Column(name= "Agencia", nullable = false, length = 10)
    private String agencia;
 
    @Column(name="Numero_Conta", nullable = false, length = 20)
    private String numeroConta;
 
    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;
 
    //ESTABELECER RELAÇÃO ENTRE TABELAS
    //um usuario para uma unica conta
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @OneToMany(mappedBy = "conta")
    private Set<Deposito> deposito =  new HashSet<>();
    
    public Set<Deposito> getDeposito(){
 		return deposito;
 	}
 	
 	public void setDeposito(Set<Deposito> deposito) {
        this.deposito = deposito;
    }
    
    //uma conta para varios saldos
    @OneToMany(mappedBy = "conta")
    private Set<Saldo> saldos = new HashSet<>();
    
    public Set<Saldo> getSaldos(){
    	return saldos;
    }
    
    public void setSaldos(Set<Saldo>saldos) {
    	this.saldos = saldos;
    }
    



	public Long getContaId() {
		return contaId;
	}

	public void setContaId(Long contaId) {
		this.contaId = contaId;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
 
    
    
}