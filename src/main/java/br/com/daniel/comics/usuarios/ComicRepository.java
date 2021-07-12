package br.com.daniel.comics.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daniel.comics.model.Comic;

public interface ComicRepository extends JpaRepository<Comic,Long> {

}
