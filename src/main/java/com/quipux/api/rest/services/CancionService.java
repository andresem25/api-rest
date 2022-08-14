package com.quipux.api.rest.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipux.api.rest.model.Cancion;
import com.quipux.api.rest.repository.CancionRepository;

@Service
public class CancionService {
	
	@Autowired
	CancionRepository cancionRepository;
	
	public CancionService() {}
	
	public List<Cancion> findAll(){
		return cancionRepository.findAll();
	}
	
	public Cancion findById(int id) {
		return cancionRepository.findById(id);
	}
	
	public Cancion save(Cancion cancion) {
		return cancionRepository.save(cancion);
	}
	
	public void deleteById(int id) {
		cancionRepository.deleteById(id);
	}

}
