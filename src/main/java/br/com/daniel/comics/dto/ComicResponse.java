package br.com.daniel.comics.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Comic;
import ch.qos.logback.classic.Logger;

public class ComicResponse {
	
	private Long id;
	private Long comicId;
	private String titulo;
	private String descricao;
	private String isbn;
	private BigDecimal preco;
	private List<Autores> autores;
	private Long idUsuario;
	public String diaDesconto;
	public Boolean descontoAtivo ;
	

	Random random = new Random();
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	


	public ComicResponse(Long comicId, String titulo, String descricao, String isbn, BigDecimal preco,
			List<Autores> autores, Long idUsuario, String diaDesconto, Boolean descontAtivo) {
		this.comicId = comicId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.isbn = isbn;
		this.preco = preco;
		this.autores = autores;
		this.idUsuario = idUsuario;
		this.diaDesconto = diaDesconto;
		this.descontoAtivo = descontAtivo;
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
		this.diaDesconto = comic.getDiaDesconto();
		this.descontoAtivo = comic.getDescontoAtivo();
	}

	
public ComicResponse(Comic comic, BigDecimal desconto) {
		
		this.comicId = comic.getComicId();
		this.titulo = comic.getTitulo();
		this.descricao = comic.getDescricao();
		this.isbn = comic.getIsbn();
		this.preco = desconto;
		this.autores = comic.getAutores();
		this.idUsuario = comic.getUsuario().getId();
		this.diaDesconto = comic.getDiaDesconto();
		this.descontoAtivo = comic.getDescontoAtivo();
	}
	
	public String getDiaDesconto() {
		return diaDesconto;
	}

	public Boolean getDescontoAtivo() {
		return descontoAtivo;
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
