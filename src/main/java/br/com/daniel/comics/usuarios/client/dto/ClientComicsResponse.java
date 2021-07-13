package br.com.daniel.comics.usuarios.client.dto;

import br.com.daniel.comics.model.Comic;

public class ClientComicsResponse {

	private String status;
	private int code;
	private DataResponse data;
	
	public ClientComicsResponse(int code, String status) {
		this.code = code;
		this.status = status;
	}
	
	
	public int getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}


	public DataResponse getData() {
		return data;
	}


	public Comic toModel() {
		return new Comic(
				data.results.get(0).id,
				data.results.get(0).title,
				data.results.get(0).description,
				data.results.get(0).isbn,
				data.results.get(0).prices.get(0).getPrice());
	}

}
