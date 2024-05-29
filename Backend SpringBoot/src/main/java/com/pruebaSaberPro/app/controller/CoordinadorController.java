package com.pruebaSaberPro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pruebaSaberPro.app.Entity.Coordinador;
import com.pruebaSaberPro.app.Entity.Estudiantes;
import com.pruebaSaberPro.app.repository.CoordinadorRepository;
import com.pruebaSaberPro.app.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/coordinadores")
public class CoordinadorController {

	@Autowired
	private CoordinadorRepository coordinadorRepository;

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	  @PostMapping("/")
	  public ResponseEntity<Coordinador> registerCoordinador(@RequestBody Coordinador coordinador) {
	    Coordinador coordinadorRegistrado = coordinadorRepository.save(coordinador);
	    return new ResponseEntity<>(coordinadorRegistrado, HttpStatus.CREATED);
	  }

	  @PostMapping("/login")
	    public ResponseEntity<String> loginCoordinador(@RequestBody Coordinador coordinador) {
	        Coordinador coordinadorEncontrado = coordinadorRepository.findByUserAndPassword(
	            coordinador.getUser(),
	            coordinador.getPassword()
	        );

	        if (coordinadorEncontrado != null) {
	            // Autenticación exitosa
	            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
	        } else {
	            // Autenticación fallida
	            return new ResponseEntity<>("Inicio de sesión fallido", HttpStatus.UNAUTHORIZED);
	        }
	    }

	    @GetMapping("/estudiantes")
	    public List<Estudiantes> getEstudiantes() {
	        return estudianteRepository.findAll();
	    }

}
