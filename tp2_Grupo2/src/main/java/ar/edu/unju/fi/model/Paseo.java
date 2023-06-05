package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Component
public class Paseo {
	@NotEmpty(message="el legajo no puede estar vacio")
	private String legajo;
	@NotEmpty(message="el nombre no puede estar vacio")
	private String nombre;
	@NotEmpty(message="el año de experiencia no puede estar vacio")
	private String anioExperiencia;
	@NotEmpty(message="el teléfono no puede estar vacio")
	private String telefono;
	@Email(message="Debe ingresar un email con formato válido")
	@NotEmpty(message="El correo no puede ser vacio")
	private String email;
	@NotEmpty(message="el horario no puede estar vacio")
	private String horario;
	@NotEmpty(message="la descripción no puede estar vacio")
	private String descripcion;
	
	public Paseo() {
		
	}
	
	public Paseo(String legajo, String nombre, String anioExperiencia, String telefono, String email, String horario, String descripcion) {
		this.legajo=legajo;
		this.nombre=nombre;
		this.anioExperiencia=anioExperiencia;
		this.telefono=telefono;
		this.email=email;
		this.horario=horario;
		this.descripcion=descripcion;
	}
	
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnioExperiencia() {
		return anioExperiencia;
	}

	public void setAnioExperiencia(String anioExperiencia) {
		this.anioExperiencia = anioExperiencia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}


