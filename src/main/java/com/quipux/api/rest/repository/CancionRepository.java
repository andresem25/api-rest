package com.quipux.api.rest.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.api.rest.model.Cancion;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer> {
	Cancion findById(int id);
	List<Cancion> findAll();

}
