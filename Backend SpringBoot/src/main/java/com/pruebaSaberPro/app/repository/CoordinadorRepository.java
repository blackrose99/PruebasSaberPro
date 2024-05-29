package com.pruebaSaberPro.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pruebaSaberPro.app.Entity.Coordinador;

public interface CoordinadorRepository extends MongoRepository<Coordinador, String> {
	List<Coordinador> findAll();
	Coordinador findByUserAndPassword(String user, String password);
}
