package br.com.daniel.comics.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Comic {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Long comicId;
	private String titulo;
	private String descricao;
	private String isbn;
	private float preco;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idComic")
	private List<Autores> autores = new ArrayList<Autores>();

	
	public Comic(Long comicId, String titulo, String descricao, String isbn, float preco) {
		super();
		this.comicId = comicId;
		this.titulo = titulo;
		this.descricao = descricao;
		this.isbn = isbn;
		this.preco = preco;
	}


	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Long getComicId() {
		return comicId;
	}
	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
