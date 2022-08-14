package com.quipux.api.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.api.rest.model.Lista;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
	
	List<Lista> findAll();

}
