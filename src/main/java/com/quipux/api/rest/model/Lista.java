package com.quipux.api.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "listaReproduccion")
public class Lista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLista;
	private String nombre;
	private String descripcion;
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonBackReference
	@JoinTable(name = "ListaxCancion",
	joinColumns = @JoinColumn(name = "idLista", referencedColumnName = "idLista"),
	inverseJoinColumns = @JoinColumn(name = "idCancion", referencedColumnName = "idCancion"),
	uniqueConstraints = @UniqueConstraint(name = "uniqueListaxCancion", columnNames = {"idLista","idCancion"}))
	private Set<Cancion> canciones = new HashSet<>();
	
	public Lista() {
		
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(Set<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	

}
