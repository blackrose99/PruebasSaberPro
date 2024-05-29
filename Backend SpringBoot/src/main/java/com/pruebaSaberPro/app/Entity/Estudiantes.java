package com.pruebaSaberPro.app.Entity;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Estudiantes {
	 @Id
	    private String id;
	    private String tipoDocumento;
	    private String numeroDocumento;
	    private String primerApellido;
	    private String segundoApellido;
	    private String primerNombre;
	    private String segundoNombre;
	    private String correoElectronico;
	    private String numeroTelefonico;
	    private String numeroRegistro;
	    private boolean ingreso;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTipoDocumento() {
			return tipoDocumento;
		}
		public void setTipoDocumento(String tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}
		public String getNumeroDocumento() {
			return numeroDocumento;
		}
		public void setNumeroDocumento(String numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
		}
		public String getPrimerApellido() {
			return primerApellido;
		}
		public void setPrimerApellido(String primerApellido) {
			this.primerApellido = primerApellido;
		}
		public String getSegundoApellido() {
			return segundoApellido;
		}
		public void setSegundoApellido(String segundoApellido) {
			this.segundoApellido = segundoApellido;
		}
		public String getPrimerNombre() {
			return primerNombre;
		}
		public void setPrimerNombre(String primerNombre) {
			this.primerNombre = primerNombre;
		}
		public String getSegundoNombre() {
			return segundoNombre;
		}
		public void setSegundoNombre(String segundoNombre) {
			this.segundoNombre = segundoNombre;
		}
		public String getCorreoElectronico() {
			return correoElectronico;
		}
		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}
		public String getNumeroTelefonico() {
			return numeroTelefonico;
		}
		public void setNumeroTelefonico(String numeroTelefonico) {
			this.numeroTelefonico = numeroTelefonico;
		}
		public String getNumeroRegistro() {
			return numeroRegistro;
		}
		public void setNumeroRegistro(String numeroRegistro) {
			this.numeroRegistro = numeroRegistro;		
		}
		public boolean getIngreso() {
			return ingreso;
		}
		public void setIngreso(boolean ingreso) {
			this.ingreso = ingreso;
		}
		

	    
	    
}
