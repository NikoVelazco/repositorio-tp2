package ar.edu.unju.fi.model;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Component
public class Sucursal {
	@NotEmpty(message="el nombre no puede estar vacio")
	private String nombre;
	@NotEmpty(message="la dirección no puede estar vacio")
	private String direccion;
	@NotBlank(message="Debe seleccionar una provincia")
	private String provincia;
	@DateTimeFormat(pattern="dd/MM/yyy")
	@NotNull(message="La fecha no puede ser vacia")
	@Past(message="La fecha debe ser menor a la fecha actual")
	private LocalDate fechaInicio;
	@Email(message="Debe ingresar un email con formato válido")
	@NotEmpty(message="El correo no puede ser vacio")
	private String email;
	@NotEmpty(message="el teléfono no puede estar vacio")
	private String telefono;
	
	public Sucursal () {
		
	}

	public Sucursal(String nombre, String direccion, String provincia, LocalDate fechaInicio, String email,
			String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
