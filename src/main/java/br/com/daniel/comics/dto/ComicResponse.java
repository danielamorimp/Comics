package br.com.daniel.comics.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Comic;

public class ComicResponse {
	
	private Long comicId;
	private String titulo;
	private String descricao;
	private String isbn;
	private BigDecimal preco;
	private List<Autores> autores;
	private Long idUsuario;
	
		
	public ComicResponse(Long comicId, String titulo, String descricao, String isbn, BigDecimal preco,
			List<Autores> autores, Long idUsuario) {
		this.comicId = comicId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.isbn = isbn;
		this.preco = preco;
		this.autores = autores;
		this.idUsuario = idUsuario;
	}
	
	@Deprecated
	public ComicResponse() {
		
	}
	
	public ComicResponse(Comic comic) {
		
		this.comicId = comic.getComicId();
		this.titulo = comic.getTitulo();
		this.descricao = comic.getDescricao();
		this.isbn = comic.getIsbn();
		this.preco = comic.getPreco();
		this.autores = comic.getAutores();
		this.idUsuario = comic.getUsuario().getId();
	}


	public Long getComicId() {
		return comicId;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getIsbn() {
		return isbn;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public List<Autores> getAutores() {
		return autores;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	
		
}
