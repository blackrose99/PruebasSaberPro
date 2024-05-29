package com.pruebaSaberPro.app.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.pruebaSaberPro.app.Entity.Estudiantes;

public interface EstudianteRepository extends MongoRepository<Estudiantes, String> {
	List<Estudiantes> findAll();

	Estudiantes findByNumeroDocumento(String numeroDocumento);
	Estudiantes findByNumeroRegistro(String numeroRegistro);

	Estudiantes findByNumeroDocumentoAndNumeroRegistro(String numeroDocumento, String numeroRegistro);
	
}
