package com.pruebaSaberPro.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaSaberPro.app.Entity.Calificacion;
import com.pruebaSaberPro.app.exeption.NotFoundException;
import com.pruebaSaberPro.app.repository.CalificacionRepository;


@RestController
@RequestMapping(value = "/api/calificaciones")
public class CalificacionController {
	@Autowired
    private CalificacionRepository calificacionRepository;


	
    @GetMapping("/")
    public List<Calificacion> getCalificaciones() {
        return calificacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Calificacion getCalificacionById(@PathVariable String id) {
        return calificacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe la calificación con el ID " + id));
    }

    @PostMapping("/")
    public ResponseEntity<Calificacion> crearCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion calificacionCreada = calificacionRepository.save(calificacion);
        return new ResponseEntity<>(calificacionCreada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Calificacion updateCalificacion(@PathVariable String id, @RequestBody Calificacion calificacion) {
        calificacion.setId(id);
        return calificacionRepository.save(calificacion);
    }

    @DeleteMapping("/{id}")
    public Calificacion deleteCalificacion(@PathVariable String id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Calificación no encontrada"));
        calificacionRepository.deleteById(id);
        return calificacion;
    }
    
    

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<Object> getEstudiantePuntajeNivel(@PathVariable String id) {
        Calificacion calificacion = calificacionRepository.findByEstudianteId(id);
        
        if (calificacion == null) {
            throw new NotFoundException("No existe una calificación para el estudiante con el ID " + id);
        }
        
        String puntaje = calificacion.puntaje();
        String nivel = calificacion.calcularNivel();
        
        // Crear un objeto JSON para devolver el puntaje y el nivel
        Map<String, String> resultado = new HashMap<>();
        resultado.put("puntaje", puntaje);
        resultado.put("nivel", nivel);
        
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }
    
    @GetMapping("/calificacion/{id}")
    public List<Calificacion> getCalificacionesByEstudiante(@PathVariable String id) {
        List<Calificacion> calificaciones = calificacionRepository.findCalificacionesByEstudianteId(id);
        return calificaciones;
    }

}


