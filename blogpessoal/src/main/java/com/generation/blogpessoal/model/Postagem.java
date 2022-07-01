package com.generation.blogpessoal.model;

import java.time.LocalDateTime;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//transforma o objeto de postagem em uma tabela no banco de dados.
@Entity
//renomeia a tabela no banco de dados.
@Table(name = "postagem")

public class Postagem {
	//chave primaria da table.
	@Id
	//auto increment da chave primaria.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//não permite campo sem conteudo.
	@NotNull
	//minimo de caractere e maximo.
	@Size(min = 5, max = 100)
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 500)
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}

