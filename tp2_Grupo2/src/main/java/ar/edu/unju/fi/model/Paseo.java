package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo2
 *
 */
@Component
public class Paseo {
	
	//Atributos de la clase Paseo
	@NotEmpty(message="el legajo no puede estar vacio")
	@Pattern(regexp = "[L][e][g]+[0-9][0-9][0-9][0-9]", 
	 message = "Ingrese un legajo válido Ej: (Leg0001)")
	private String legajo;
	
	@NotEmpty(message="el campo nombre no puede estar vacio")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "El nombre solo puede contener letras y espacios")
	private String nombre;
	
	@NotEmpty(message="el año de experiencia no puede estar vacio")
	@Pattern(regexp = "^(?:[1-9]|[1-9][0-9]+)$", message = "Solo se permiten números positivos")
	private String anioExperiencia;
	
	@NotEmpty(message="el teléfono no puede estar vacio")
	@Pattern(regexp = "[0-9][0-9][0-9]+-+[0-9][0-9][0-9][0-9][0-9][0-9][0-9]", 
	 message = "Ingrese un número de teléfono válido Ej: (011-1234567)")
	private String telefono;
	
	@Email(message="Debe ingresar un email con formato válido")
	@NotEmpty(message="El correo no puede ser vacio")
	private String email;
	
	@NotEmpty(message="el horario no puede estar vacio")
	private String horario;
	
	@NotEmpty(message="la descripción no puede estar vacio")
	@Size(min=15,message="Descripcion minima de 15 caracteres")
	private String descripcion;
	
	/**
	 * Constructor por defecto
	 */
	public Paseo() {
		
	}
	
	/**
	 * Constructor especializado
	 * @param legajo
	 * @param nombre
	 * @param anioExperiencia
	 * @param telefono
	 * @param email
	 * @param horario
	 * @param descripcion
	 */
	public Paseo(String legajo, String nombre, String anioExperiencia, String telefono, String email, String horario, String descripcion) {
		super();
		this.legajo=legajo;
		this.nombre=nombre;
		this.anioExperiencia=anioExperiencia;
		this.telefono=telefono;
		this.email=email;
		this.horario=horario;
		this.descripcion=descripcion;
	}
	
	/**
	 * Obtiene telefono
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/*
	 * setea telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Obtiene legajo
	 * @return legajo
	 */
	public String getLegajo() {
		return legajo;
	}
	
	/**
	 * setea legajo
	 * @param legajo
	 */
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	/**
	 * obtiene nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * setea nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Obtiene año
	 * @return anioExperiencia
	 */
	public String getAnioExperiencia() {
		return anioExperiencia;
	}
	
	/**
	 * Setea el año
	 * @param anioExperiencia
	 */
	public void setAnioExperiencia(String anioExperiencia) {
		this.anioExperiencia = anioExperiencia;
	}
	
	/**
	 * obtiene email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setea email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * obtiene horario
	 * @return horario
	 */
	public String getHorario() {
		return horario;
	}
	
	/**
	 * Setea horario
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**
	 * Obtiene descripción
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * setea descripcion
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
