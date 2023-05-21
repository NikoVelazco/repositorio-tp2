package ar.edu.unju.fi.model;

public class Paseo {
	
	private String legajo;
	private String nombre;
	private String anioExperiencia;
	private String telefono;
	private String email;
	private String horario;
	
	public Paseo() {
		
	}
	
	public Paseo(String legajo, String nombre, String anioExperiencia, String telefono, String email, String horario) {
		this.legajo=legajo;
		this.nombre=nombre;
		this.anioExperiencia=anioExperiencia;
		this.telefono=telefono;
		this.email=email;
		this.horario=horario;
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
	
	
}
