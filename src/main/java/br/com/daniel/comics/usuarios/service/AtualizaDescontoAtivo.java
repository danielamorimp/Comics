package br.com.daniel.comics.usuarios.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.usuarios.ComicRepository;
import ch.qos.logback.classic.Logger;

@Component
public class AtualizaDescontoAtivo {
	@Autowired
	private ComicRepository comicRepository;

	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	
	@Scheduled(fixedDelay = 11000)
	public List<Comic> teste(){
		String diaSemana = LocalDate.now().getDayOfWeek().toString();
		
		List<Comic> comic = comicRepository.findAll();
		comic.stream().map(e -> {
			if(e.diaDesconto == diaSemana)
				return e.descontoAtivo = true;
			return false;
			})						
			.collect(Collectors.toList());
		
		return comicRepository.saveAll(comic);
	}
}
