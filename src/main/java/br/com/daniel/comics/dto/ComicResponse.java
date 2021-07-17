package br.com.daniel.comics.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;

import br.com.daniel.comics.model.Autores;
import br.com.daniel.comics.model.Comic;
import ch.qos.logback.classic.Logger;

public class ComicResponse {
	
	private Long comicId;
	private String titulo;
	private String descricao;
	private String isbn;
	private BigDecimal preco;
	private List<Autores> autores;
	private Long idUsuario;
	

	Random random = new Random();
	
	protected final Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	public String geraIsbn(){
		Integer n1 = random.nextInt(999);
		Integer n2 = random.nextInt(999);
		Integer n3 = random.nextInt(999);
		Integer n4 = random.nextInt(999);
		Integer n5 = random.nextInt(9);

		String isbn = n1.toString() + "-" + n2.toString() + "-" + n3.toString() + "-" + n4.toString() + "-" + n5.toString();
		
		log.info(isbn);
		
		return isbn.toString();
	}
	
	
		
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
