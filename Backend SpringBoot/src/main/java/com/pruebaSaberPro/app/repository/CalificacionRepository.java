package com.pruebaSaberPro.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.pruebaSaberPro.app.Entity.Calificacion;

public interface CalificacionRepository extends MongoRepository<Calificacion, String>{
	List<Calificacion> findAll();
	Calificacion findByEstudianteId(String id);
	List<Calificacion> findCalificacionesByEstudianteId(String id);
}
