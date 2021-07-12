package br.com.daniel.comics.usuarios;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.daniel.comics.dto.NovoUsuarioRequest;
import br.com.daniel.comics.dto.NovoUsuarioResponse;

@RestController
@RequestMapping("/api/comics")
public class CadastroUsuariosController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> Cadastrar(@RequestBody @Valid NovoUsuarioRequest request){
		
		usuarioRepository.save(request.toModel());
		return ResponseEntity.ok(new NovoUsuarioResponse(request));
	}

}
