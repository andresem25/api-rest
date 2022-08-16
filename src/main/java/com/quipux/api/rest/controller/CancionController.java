package com.quipux.api.rest.controller;

import java.util.List;
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
import com.quipux.api.rest.services.CancionService;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/api/cancion")
public class CancionController {
	
	@Autowired
	private CancionService cancionService;
	
	@GetMapping
	public ResponseEntity<List<Cancion>> mostrarCanciones(){
		return new ResponseEntity<>(cancionService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cancion> verCancion(@PathVariable int id){
		Cancion cancion = cancionService.findById(id);
		if (cancion != null)
			return new ResponseEntity<>(cancionService.findById(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> guardarCancion(@RequestBody Cancion cancion){
		return new ResponseEntity<>(cancionService.save(cancion), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarCancion(@PathVariable int id){
		Cancion cancion = cancionService.findById(id);
		if(cancion != null) {
			cancionService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/{id}/listaReproduccion")
	public ResponseEntity<Set<Lista>> obtenerListasdeReproduccion(@PathVariable int id){
		Cancion cancion = cancionService.findById(id);
		if(cancion != null) {
			return new ResponseEntity<>(cancion.getListaReproduccion(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
