package br.com.daniel.comics.usuarios.service;

import br.com.daniel.comics.usuarios.ComicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.daniel.comics.model.Comic;


@Service
public class RegraDescontoService {

	@Autowired
	private ComicRepository comicRepository;


	private Logger lg  = LoggerFactory.getLogger(this.getClass());
	
	private String diaDesconto;
	
	public String diaSemana(Comic resp) {

		char ultimoDigito = resp.isbn.charAt(resp.isbn.length()-1);

		switch(ultimoDigito) {
			case('0'):
			case('1'):
				diaDesconto = "segunda-feira";
				break;
			case('2'):
			case('3'):
				diaDesconto = "terça-feira";
				break;
			case('4'):
			case('5'):
				diaDesconto = "quart-feira";
				break;
			case('6'):
			case('7'):
				diaDesconto = "quinta-feira";
				break;
			case('8'):
			case('9'):
				diaDesconto = "sexta-feira";
				break;
		}

		resp.diaDesconto = diaDesconto;
		comicRepository.save(resp);

		lg.info(diaDesconto);


		return resp.diaDesconto;

	}



}
