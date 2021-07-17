package br.com.daniel.comics.usuarios.client.dto;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.model.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Collectors;

public class ClientComicsResponse {

	Random random = new Random();

	private String status;
	private int code;
	private DataResponse data;
	
	public ClientComicsResponse(int code, String status) {
		this.code = code;
		this.status = status;
	}


	public String geraIsbn(){
		Integer n1 = random.nextInt(999);
		Integer n2 = random.nextInt(999);
		Integer n3 = random.nextInt(999);
		Integer n4 = random.nextInt(999);
		Integer n5 = random.nextInt(9);

		String isbn = n1.toString() + "-" + n2.toString() + "-" + n3.toString() + "-" + n4.toString() + "-" + n5.toString();

		return isbn.toString();

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
				data.results.get(0).isbn = geraIsbn(),
				new BigDecimal(data.results.get(0).prices.get(0).getPrice().toString()),
				data.results.get(0).creators.items.stream().map( e ->{ return new Autores(e.getName(),data.results.get(0).id);}).collect(Collectors.toList()),
				usuario
			);
	}

}
