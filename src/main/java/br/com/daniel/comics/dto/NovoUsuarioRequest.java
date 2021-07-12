package br.com.daniel.comics.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.daniel.comics.model.Usuario;

public class NovoUsuarioRequest {
	@NotBlank @NotNull
	private String nome;
	@NotBlank @NotNull @Email
	private String email;
	@NotBlank @NotNull @CPF
	private String cpf;
	@NotNull
	private LocalDate nascimento;
	
	public NovoUsuarioRequest(@NotBlank @NotNull String nome, @NotBlank @NotNull @Email String email,
			@NotBlank @NotNull @CPF String cpf, @NotNull LocalDate nascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	@Deprecated
	public NovoUsuarioRequest() {
		
	}
	public Usuario toModel() {
		
		return new Usuario(
				nome,
				email,
				cpf,
				nascimento			
		);
	}
}
