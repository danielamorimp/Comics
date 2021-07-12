package br.com.daniel.comics.dto;

import java.time.LocalDate;


public class NovoUsuarioResponse {

	private String nome;
	private String email;
	private String cpf;
	private LocalDate nascimento;
	
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
	public NovoUsuarioResponse() {
	}
	
	public NovoUsuarioResponse(NovoUsuarioRequest request) {
		this.nome = request.getNome();
		this.email = request.getEmail();
		this.cpf = request.getCpf();
		this.nascimento = request.getNascimento();
	}
	
}
