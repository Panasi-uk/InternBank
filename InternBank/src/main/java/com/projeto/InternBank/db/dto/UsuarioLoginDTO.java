package com.projeto.InternBank.db.dto;

public class UsuarioLoginDTO {
	private String agencia;
	private String conta;
	private String senha;

	//verificar se funciona desse modo
	 public String getAgenciaconta() {
	        return agencia + "-" + conta; 
	    }

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
