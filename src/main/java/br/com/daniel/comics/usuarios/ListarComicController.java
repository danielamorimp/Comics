package br.com.daniel.comics.usuarios;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.comics.dto.ComicResponse;
import br.com.daniel.comics.model.Comic;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/comics")
public class ListarComicController {
	
	
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ComicRepository comicRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/lista/{id}")
	public ResponseEntity<List<ComicResponse>> listar(@PathVariable Long id) {
		
		if(usuarioRepository.existsById(id) != true) return ResponseEntity.notFound().build();
		List<Comic> comics = comicRepository.buscarComicUsuario(id);
	
		log.info(comics.toString());
		
		return ResponseEntity.ok(comics.stream().map(e -> {return new ComicResponse(e);}).collect(Collectors.toList()));
		
		
	}
}
