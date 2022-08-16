package com.quipux.api.rest.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.api.rest.model.Cancion;
import com.quipux.api.rest.model.Lista;
import com.quipux.api.rest.services.ListaService;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/listaReproduccion")
public class ListaReproduccionController {
	
	@Autowired
	private ListaService listaService;
	
	@GetMapping
	public ResponseEntity<List<Lista>> mostrarListaReproduccion(){
		return new ResponseEntity<>(listaService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Lista>> verLista(@PathVariable int id){
		Optional<Lista> listaReproduccion = listaService.findById(id);
		if(listaReproduccion.isPresent())
			return new ResponseEntity<>(listaReproduccion, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> guardarLista(@RequestBody Lista listaReproduccion){
		return new ResponseEntity<>(listaService.save(listaReproduccion), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarLista(@PathVariable int id){
		Optional<Lista> listaReproduccion = listaService.findById(id);
		if(listaReproduccion.isPresent()) {
			listaService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/{id}/canciones")
	public ResponseEntity<Set<Cancion>> obtenerCanciones(@PathVariable int id){
		Lista listaReproduccion = listaService.findById(id).orElseThrow();
		if(listaReproduccion != null) {
			return new ResponseEntity<>(listaReproduccion.getCanciones(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("añadirListaCanciones")
	public ResponseEntity<Lista> añadirListaCanciones(@RequestBody Lista listaReq){
		return new ResponseEntity<>(listaService.añadirListaconCanciones(listaReq), HttpStatus.OK);
	}
	
}
