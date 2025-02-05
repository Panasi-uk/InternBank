package com.projeto.InternBank.db.models;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Admin_id;
    
    @Column(name = "Email", nullable = false, unique = true, length = 100)
    private String email;
 
    @Column(name = "Criacao", nullable = false)
    private LocalDateTime criacao;
 
    @Column(name = "Edicao", nullable = true)
    private LocalDateTime edicao;
 
    /*@ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;*/

    //ESTABELECER RELAÇÃO ENTRE TABELAS
    //Um admin para muitos usuarios
    //verificar sobrecarga com o fetchEAGER
    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER ,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Usuario> usuarios = new HashSet<>();

    public Admin() {
    	
    }

	public Integer getAdminId() {
		return Admin_id;
	}

	public void setAdminId(Integer id) {
		this.Admin_id = id;
	}

	public LocalDateTime getCriacao() {
		return criacao;
	}

	public void setCriacao(LocalDateTime criacao) {
		this.criacao = criacao;
	}

	public LocalDateTime getEdicao() {
		return edicao;
	}

	public void setEdicao(LocalDateTime edicao) {
		this.edicao = edicao;
	}
	
	

	/*public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

    
	
}
