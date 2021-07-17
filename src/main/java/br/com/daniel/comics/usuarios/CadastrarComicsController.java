package br.com.daniel.comics.usuarios;

import java.net.URI;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.daniel.comics.dto.ComicResponse;
import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.model.Usuario;
import br.com.daniel.comics.usuarios.client.ClientComics;
import br.com.daniel.comics.usuarios.client.dto.ClientComicsResponse;
import br.com.daniel.comics.usuarios.service.RegraDescontoService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/api/marvel/comics")
public class CadastrarComicsController {
	@Autowired
	private ClientComics clientComics;
	
	@Autowired
	private ComicRepository comicRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RegraDescontoService regra;
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	@PostMapping("/cadastrar/{id}/{idUsuario}")
	public ResponseEntity<?> buscaComics(@PathVariable Long id,@PathVariable Long idUsuario, UriComponentsBuilder uriBuilder) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		
		//if(usuario.isEmpty())return ResponseEntity.notFound().build();
		
		ClientComicsResponse resp = clientComics.getClientComicsResponse(id);
			
		Comic comic = resp.toModel(usuario.get());
		
		Comic dado = comicRepository.save(comic);

		log.info(dado.isbn);
		
		regra.diaSemana(dado);
		
		URI uri = uriBuilder.path("api/marvel/comic/detalhar/{id}").buildAndExpand(dado.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ComicResponse(dado));
				
	}


}
