package br.com.daniel.comics.usuarios.client.dto;

import java.util.ArrayList;

public class ResultResponse {
 public int id;
 public String title;
 public String description;
 public String isbn;
 public ArrayList<PriceResponse> prices;
 public CreatorsResponse creators;


	public ArrayList<PriceResponse> getPrices() {
		return prices;
	}
 
	public int getId() {
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
