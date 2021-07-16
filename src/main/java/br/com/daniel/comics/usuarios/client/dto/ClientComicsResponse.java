package br.com.daniel.comics.usuarios.client.dto;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.model.Usuario;
import br.com.daniel.comics.usuarios.service.GeraIsbn;

import java.math.BigDecimal;
import java.util.stream.Collectors;

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


	public Comic toModel(Usuario usuario) {
		return new Comic(
				data.results.get(0).id,
				data.results.get(0).title,
				data.results.get(0).description,
				//if(data.results.get(0).isbn.equals("")) {geraIsbn.isbn();} else data.results.get(0).isbn
				//(data.results.get(0).isbn.equals("")) ? geraIsbn.isbn() : data.results.get(0).isbn);
				data.results.get(0).isbn,
				new BigDecimal(data.results.get(0).prices.get(0).getPrice().toString()),
				data.results.get(0).creators.items.stream().map( e ->{ return new Autores(e.getName());}).collect(Collectors.toList()),
				usuario
			);

	}

}
