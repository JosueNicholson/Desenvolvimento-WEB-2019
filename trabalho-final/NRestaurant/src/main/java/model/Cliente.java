package model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "preencha o campo nome")
	private String nome;
	
	@NotBlank(message = "preencha o campo cpf")
	private String cpf;
	
	@NotBlank(message = "preencha o campo endereço")
	private String endereco;
	
	@NotBlank(message = "preencha o campo senha")
	private String senha;
	
	@NotNull(message = "data de nascimento não pode ser nula")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataDeNascimento;

	public Cliente(@NotBlank(message = "preencha o campo nome") String nome,
			@NotBlank(message = "preencha o campo cpf") String cpf,
			@NotBlank(message = "preencha o campo endereço") String endereco,
			@NotBlank(message = "preencha o campo senha") String senha,
			@NotNull(message = "data de nascimento não pode ser nula") Date dataDeNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.senha = senha;
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public long getId() {
		return id;
	}
}
