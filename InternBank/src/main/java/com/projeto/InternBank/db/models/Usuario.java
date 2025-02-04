package com.projeto.InternBank.db.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @Column(name = "Telefone", nullable = true, unique = true)
    private String telefone;

    @Column(name = "Endereco", nullable = true, unique = false)
    private String endereco;

    @Column(name = "CEP", nullable = true, unique = false)
    private String cep;

    @Column(name = "Bairro", nullable = true, unique = false)
    private String bairro;

    @Column(name = "Cidade", nullable = true, unique = false)
    private String cidade;

    @Column(name = "Numero", nullable = true, unique = false)
    private String numero;

    @Column(nullable = false)  
    private String senha;
    
    @Column(name = "role", nullable = false)
    private String role = "ROLE_USER"; 
    
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    // RELACIONAMENTOS ENTRE TABELAS

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true) 
    private Admin admin;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Conta conta;
    
    

    @OneToMany(mappedBy = "usuario")
    private Set<Deposito> deposito = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Pix> pix = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Pagamento> pagamento = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Saque> saque = new HashSet<>();
    
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    // GETTERS E SETTERS


    public String getNome() { 
    	return nome; 
    	}
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
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

    public String getSenha() { 
    	return senha; 
    	}
    public void setSenha(String senha) { 
    	this.senha = senha; 
    	}
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Deposito> getDeposito() { 
    	return deposito; 
    	}
    public void setDeposito(Set<Deposito> deposito) { 
    	this.deposito = deposito; 
    	}

    public Set<Pix> getPix() { 
    	return pix; }
    public void setPix(Set<Pix> pix) { 
    	this.pix = pix; 
    	}

    public Set<Pagamento> getPagamento() { 
    	return pagamento; 
    	}
    public void setPagamento(Set<Pagamento> pagamento) { 
    	this.pagamento = pagamento; 
    	}

    public Set<Saque> getSaque() { 
    	return saque; 
    	}
    public void setSaque(Set<Saque> saque) { 
    	this.saque = saque; 
    	}
}


