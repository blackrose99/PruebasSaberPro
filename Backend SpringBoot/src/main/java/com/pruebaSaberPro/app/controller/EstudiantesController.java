package com.pruebaSaberPro.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pruebaSaberPro.app.Entity.Estudiantes;
import com.pruebaSaberPro.app.exeption.NotFoundException;
import com.pruebaSaberPro.app.repository.EstudianteRepository;

@RestController
@RequestMapping(value = "/api/estudiantes")
public class EstudiantesController {
	
	    @Autowired
	    private EstudianteRepository estudianteRepository;

	    @GetMapping("/")
	    public List<Estudiantes> getEstudiantes() {
	        return estudianteRepository.findAll();
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> loginEstudiante(@RequestBody Estudiantes estudiante) {
	        Estudiantes estudianteEncontrado = estudianteRepository.findByNumeroDocumentoAndNumeroRegistro(
	            estudiante.getNumeroDocumento(),
	            estudiante.getNumeroRegistro()
	        );

	        if (estudianteEncontrado != null) {
	            estudianteEncontrado.setIngreso(true);
	            estudianteRepository.save(estudianteEncontrado);
	            return new ResponseEntity<>(estudianteEncontrado.getId(), HttpStatus.OK);
	        } else {
	            // Autenticación fallida
	            return new ResponseEntity<>("Inicio de sesión fallido", HttpStatus.UNAUTHORIZED);
	        }
	    }
	    

	    @GetMapping("/{id}")
	    public ResponseEntity<Estudiantes> getEstudianteById(@PathVariable String id) {
	        Optional<Estudiantes> estudianteOptional = estudianteRepository.findById(id);
	        if (estudianteOptional.isPresent()) {
	            return new ResponseEntity<>(estudianteOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }


	    @PostMapping("/")
	    public ResponseEntity<Estudiantes> crearEstudiante(@RequestBody Estudiantes estudiante) {
	        Estudiantes estudianteCreado = estudianteRepository.save(estudiante);
	        return new ResponseEntity<>(estudianteCreado, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public Estudiantes updateEstudiante(@PathVariable String id, @RequestBody Estudiantes estudiante) {
	        estudiante.setId(id);
	        return estudianteRepository.save(estudiante);
	    }

	    @DeleteMapping("/{id}")
	    public Estudiantes deleteEstudiante(@PathVariable String id) {
	        Estudiantes estudiante = estudianteRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
	        estudianteRepository.deleteById(id);
	        return estudiante;
	    }
	    
	



	   
	    

}
