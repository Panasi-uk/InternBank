package com.projeto.InternBank.db.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CadastroDTO {

	@NotBlank(message = "Insira o nome completo")
	private String nome;
	
	@NotBlank(message = "Email obrigatório")
	@Email(message = "Insira um email válido")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória")
	@Size(min = 6, message = "A senha deve conter no minimo 6 caracteres")
	private String senha; 
	
	@NotBlank(message = "Insira o CPF")
	@Size(min = 11, max = 11, message = "Insira um CPF válido")
	private String cpf;
	
	@NotBlank(message = "Insira o Telefone")
	@Size(min = 11, max = 11, message = "Insira um telefone válido")
	private String telefone;
	
	@NotBlank(message = "Insira seu Endereço")
	private String endereco;
	
	@NotBlank(message = "Insira o CEP")
	private String cep;
	
	@NotBlank(message = "Insira seu Bairro")
	private String bairro;
	
	@NotBlank(message = "Insira sua Cidade")
	private String cidade;
	
	@NotBlank(message = "Insira seu Numero")
	private String numero;
	
	@NotBlank(message = "Insira o papel do usuário")
    private String role;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
	
}
