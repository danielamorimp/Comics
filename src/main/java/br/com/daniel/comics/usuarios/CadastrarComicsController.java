package br.com.daniel.comics.usuarios;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.usuarios.client.ClientComics;
import br.com.daniel.comics.usuarios.client.dto.ClientComicsResponse;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/marvel/comics")
public class CadastrarComicsController {
	@Autowired
	private ClientComics clientComics;
	@Autowired
	private Comic comic;
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	@GetMapping("/cadastrar/{id}")
	public ClientComicsResponse buscaComics(@PathVariable Long id) {
		ClientComicsResponse resp = clientComics.getClientComicsResponse(id);
		
		Comic comic = resp.toModel();
		return resp;
	}

}
