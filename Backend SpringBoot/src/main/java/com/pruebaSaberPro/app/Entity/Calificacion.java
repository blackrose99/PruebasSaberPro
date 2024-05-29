package com.pruebaSaberPro.app.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Calificacion {

	@Id
	private String id;

	private int comunicacionEscrita;
	private int razonamientoCuantitativo;
	private int lecturaCritica;
	private int competenciasCiudadanas;
	private int ingles;
	private int formulacionProyectos;
	private int pensamientoCientifico;
	private int diseñoSoftware;
	
	@DocumentReference
	private Estudiantes estudiante;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getComunicacionEscrita() {
		return comunicacionEscrita;
	}
	public void setComunicacionEscrita(int comunicacionEscrita) {
		this.comunicacionEscrita = comunicacionEscrita;
	}
	public int getRazonamientoCuantitativo() {
		return razonamientoCuantitativo;
	}
	public void setRazonamientoCuantitativo(int razonamientoCuantitativo) {
		this.razonamientoCuantitativo = razonamientoCuantitativo;
	}
	public int getLecturaCritica() {
		return lecturaCritica;
	}
	public void setLecturaCritica(int lecturaCritica) {
		this.lecturaCritica = lecturaCritica;
	}
	public int getCompetenciasCiudadanas() {
		return competenciasCiudadanas;
	}
	public void setCompetenciasCiudadanas(int competenciasCiudadanas) {
		this.competenciasCiudadanas = competenciasCiudadanas;
	}
	public int getIngles() {
		return ingles;
	}
	public void setIngles(int ingles) {
		this.ingles = ingles;
	}
	public int getFormulacionProyectos() {
		return formulacionProyectos;
	}
	public void setFormulacionProyectos(int formulacionProyectos) {
		this.formulacionProyectos = formulacionProyectos;
	}
	public int getPensamientoCientifico() {
		return pensamientoCientifico;
	}
	public void setPensamientoCientifico(int pensamientoCientifico) {
		this.pensamientoCientifico = pensamientoCientifico;
	}
	public int getDiseñoSoftware() {
		return diseñoSoftware;
	}
	public void setDiseñoSoftware(int diseñoSoftware) {
		this.diseñoSoftware = diseñoSoftware;
	}
	 
	 
	public Estudiantes getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiantes estudiante) {
		this.estudiante = estudiante;
	}
	
	
	public String puntaje() {
	    int sumaNotas = comunicacionEscrita + razonamientoCuantitativo
	            + lecturaCritica + competenciasCiudadanas + ingles
	            + formulacionProyectos + pensamientoCientifico
	            + diseñoSoftware;
	    
	    int promedio = Math.round((float) sumaNotas / 8);

	    if (promedio < 100) {
	        return "Anulado";
	    } else {	        
	        return String.valueOf(promedio);
	    }
	}

	public String calcularNivel() {
	    String puntaje = puntaje(); 

	    if (puntaje.equals("Anulado")) {
	        return "Nivel 0"; 
	    } else {
	        int valorPuntaje = Integer.parseInt(puntaje); 
	        
	        if (valorPuntaje >= 191 && valorPuntaje <= 300) {
	            return "Nivel 4";
	        } else if (valorPuntaje >= 156 && valorPuntaje <= 190) {
	            return "Nivel 3";
	        } else if (valorPuntaje >= 126 && valorPuntaje <= 155) {
	            return "Nivel 2";
	        } else if (valorPuntaje >= 0 && valorPuntaje <= 125) {
	            return "Nivel 1";
	        } else {
	            return "Error";
	        }
	    }
	}


}
