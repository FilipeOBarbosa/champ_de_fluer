package Pacote.Usuario;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Pacote.Flor.Flor;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CPF_USUARIO")
	private String cpf;
	
	@Column(name = "NOME_USUARIO")
	private String nome;
	
	@Column(name = "EMAIL_USUARIO")
	private String email;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
	@JoinColumn(name = "USUARIO_FK")
	private Endereco endereco;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
	@JoinColumn(name = "USUARIO_FK")
	private List<Flor> flores;
	

	public String getCpf() {
		return cpf;
	}


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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Flor> getFlores() {
		return flores;
	}

	public void setFlores(List<Flor> flores) {
		this.flores = flores;
	}
	
}
