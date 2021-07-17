package br.com.daniel.comics.usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.usuarios.ComicRepository;

@Service
public class RegraDescontoService {
	
	@Autowired
	private ComicRepository comicRepository;
	
	private String isbn;
	
	public String diaSemana(Comic resp) {
		
		 char ultimoDigito = resp.isbn.charAt(isbn.length() - 1);
		
		switch(ultimoDigito) {
		case(0):
		case(1):
			isbn = "segunda-feira";
			break;
		case(2):
		case(3):
			isbn = "terça-feira";
			break;
		case(4):
		case(5):
			isbn = "quart-feira";
			break;
		case(6):
		case(7):
			isbn = "quinta-feira";
			break;
		case(8):
		case(9):
			isbn = "sexta-feira";
			break;
		}
		
		resp.diaDesconto = isbn;
		comicRepository.save(resp);
		
		return resp.diaDesconto;
	}
	
	public String traduzDia(String diaSemana) {
		switch(diaSemana) {
		case("MONDAY"):
			diaSemana = "segunda-feira";
		case("TUESDAY"):
			diaSemana = "terça-feira";
		case("WEDNESDAY"):
			diaSemana = "quarta-feira";
		case("THURSDAY"):
			diaSemana = "quinta-feira";
		case("FRIDAY"):
			diaSemana = "sexta-feira";
		}
		
		return "";
	}

}
