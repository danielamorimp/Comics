package br.com.daniel.comics.usuarios;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
		
		return ResponseEntity.ok(comics.stream().map(e -> {
			float precoDesconto = e.preco.floatValue();
			Double porcentagem = 0.1;
			float porcentagemDouble = porcentagem.floatValue();
			BigDecimal preco = e.preco;
			
			if(e.descontoAtivo == true){
				precoDesconto = (e.preco.floatValue() - (e.preco.floatValue() * porcentagemDouble));
				preco = new BigDecimal (precoDesconto);
				
			}
			if(e.descontoAtivo == false) {
				 preco =  e.preco;
			}	

			
			return new ComicResponse(e, preco.setScale(2,RoundingMode.FLOOR));})
				
				.collect(Collectors.toList()));
		
		
	}
}
