package com.projeto.InternBank.db.dto;

import java.util.Date;

public class TransacoesDTO {
	private Long id;
	private Long pix;
	private Long pagamento;
	private Long deposito;
	private Date extrato;
	private Long saque;
	private Long conta;
	
	public TransacoesDTO() {}
	
	public TransacoesDTO(
				Long id, 
				Long pix, 
				Long pagamento, 
				Long deposito,
				Date extrato,
				Long saque,
				Long conta
			){
		
				this.id = id;
				this.pix = pix;
				this.pagamento = pagamento;
				this.deposito = deposito;
				this.extrato = extrato;
				this.saque = saque;
				this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPix() {
		return pix;
	}

	public void setPix(Long pix) {
		this.pix = pix;
	}

	public Long getPagamento() {
		return pagamento;
	}

	public void setPagamento(Long pagamento) {
		this.pagamento = pagamento;
	}

	public Long getDeposito() {
		return deposito;
	}

	public void setDeposito(Long deposito) {
		this.deposito = deposito;
	}

	public Date getExtrato() {
		return extrato;
	}

	public void setExtrato(Date extrato) {
		this.extrato = extrato;
	}

	public Long getSaque() {
		return saque;
	}

	public void setSaque(Long saque) {
		this.saque = saque;
	}

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}
	
	
	
}
