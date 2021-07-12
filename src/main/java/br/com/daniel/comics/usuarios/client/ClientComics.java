package br.com.daniel.comics.usuarios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.daniel.comics.usuarios.client.dto.ClientComicsResponse;

@FeignClient(name = "marvel", url = "http://gateway.marvel.com/v1/public/comics")
public interface ClientComics {
		
		@GetMapping("/{id}?ts=1625970558&apikey=1936c6421fc7550575304e3dde4d3d21&hash=6a17706d892553a652b58b98fa56e478")		
		ClientComicsResponse getClientComicsResponse(@PathVariable Long id);

}

