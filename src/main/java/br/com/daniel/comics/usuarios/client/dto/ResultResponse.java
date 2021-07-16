package br.com.daniel.comics.usuarios.client.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Usuario;

public class ResultResponse {
 public Long id;
 public String title;
 public String description;
 public String isbn;
 public ArrayList<PriceResponse> prices;
 public CreatorsResponse creators;


	public ArrayList<PriceResponse> getPrices() {
		return prices;
	}
 
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getDescription() {
		return description;
	}
	public CreatorsResponse getCreators() {
		return creators;
	}
	
}
