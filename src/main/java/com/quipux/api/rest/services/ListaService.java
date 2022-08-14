package com.quipux.api.rest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quipux.api.rest.model.Cancion;
import com.quipux.api.rest.model.Lista;
import com.quipux.api.rest.repository.CancionRepository;
import com.quipux.api.rest.repository.ListaRepository;

@Service
public class ListaService {
	
	@Autowired
	ListaRepository listaRepository;
	@Autowired 
	CancionRepository cancionRepository;
	
	public ListaService() {}
	
	public List<Lista> findAll(){
		return listaRepository.findAll();
	}
	
	public Optional<Lista> findById(int id) {
		return listaRepository.findById(id);
	}
	
	public Lista save(Lista lista) {
		return listaRepository.save(lista);
	}
	
	public void deleteById(int id) {
		listaRepository.deleteById(id);
	}
	
	public Lista añadirListaconCanciones(Lista listaReq) {
		Lista listaReproduccion = new Lista();
		listaReproduccion.setIdLista(listaReq.getIdLista());
		listaReproduccion.setNombre(listaReq.getNombre());
		listaReproduccion.setDescripcion(listaReq.getDescripcion());
		listaReproduccion.setCanciones(listaReq.getCanciones()
				.stream().map(cancionContent -> {
					Cancion canciones = cancionContent;
					if(canciones.getIdCancion() > 0) {
						canciones = cancionRepository.findById(canciones.getIdCancion());
					}
					canciones.addListaReproduccion(listaReproduccion);
					return canciones;
				})
				.collect(Collectors.toSet()));
		return listaRepository.save(listaReproduccion);
	}

}
