package br.com.daniel.comics.usuarios;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.daniel.comics.dto.NovoUsuarioRequest;
import br.com.daniel.comics.dto.NovoUsuarioResponse;
import br.com.daniel.comics.model.Comic;
import br.com.daniel.comics.model.Usuario;

@RestController
@RequestMapping("/api/comics")
public class CadastroUsuariosController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> Cadastrar(@RequestBody @Valid NovoUsuarioRequest request, UriComponentsBuilder uriBuilder){
		//if(usuarioRepository.existEmail(request.getEmail()))
			//return ResponseEntity.unprocessableEntity().body("Email já cadstrado");
	
		//if(usuarioRepository.existCpf(request.getCpf()))
			//return ResponseEntity.unprocessableEntity().body("ÇPF já cadastrado");
		
		Usuario usuario = usuarioRepository.save(request.toModel());
		
		URI uri = uriBuilder.path("api/marvel/usuario/detalhar/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new NovoUsuarioResponse(request));
	}

}
