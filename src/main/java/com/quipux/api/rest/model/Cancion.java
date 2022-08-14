package com.quipux.api.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "canciones")
public class Cancion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCancion;
	private String titulo;
	private String artista;
	private String album;
	private String anno;
	private String genero;
	@ManyToMany(mappedBy = "canciones", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonBackReference
	private Set<Lista> listaReproduccion = new HashSet<>();
	

	public Cancion() {
		
	}

	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Set<Lista> getListaReproduccion() {
		return listaReproduccion;
	}

	public void setListaReproduccion(Set<Lista> listaReproduccion) {
		this.listaReproduccion = listaReproduccion;
	}

	public void addListaReproduccion(Lista lista) {
		this.listaReproduccion.add(lista);
	}
	
	
	

}
