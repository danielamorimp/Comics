package br.com.daniel.comics.usuarios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.daniel.comics.model.Comic;

public interface ComicRepository extends JpaRepository<Comic,Long> {
	
	public List<Comic> findAllById(Long id);
	
	@Query("SELECT c FROM Comic c WHERE c.usuario.id = :id")
	public  List<Comic> buscarComicUsuario(Long id);

}
