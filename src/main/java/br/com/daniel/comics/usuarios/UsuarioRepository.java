package br.com.daniel.comics.usuarios;

import org.springframework.stereotype.Repository;
import br.com.daniel.comics.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	public Boolean existsByEmail(String email);
	public Boolean existsByCpf(String cpf);
	
}
