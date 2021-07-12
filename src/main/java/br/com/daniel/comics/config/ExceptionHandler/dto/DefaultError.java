package br.com.daniel.comics.config.ExceptionHandler.dto;

public class DefaultError {
	private String campo;
	private String erro;
	
	public DefaultError(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}
	public String getErro() {
		return erro;
	}
}
