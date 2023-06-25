package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Grupo2
 */
@Component
@Entity
@Table(name="empleado")
public class Empleado {
	
	//Atributos de la clase Empleado
	@Id
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; //id de empleado en la BD
	
	@Column(name="emp_nombre")
	private String nombreEmpleado; //nombre del empleado
	
	@Column(name="emp_estado")
	private boolean estado; //1=existe 0=no existe
	
	/**
	 * Constructor por defecto
	 */
	public Empleado() {
		
	}
	
	/**
	 * Constructor parametrizado
	 * @param id
	 * @param nombreEmpleado
	 * @param estado
	 */
	public Empleado(Long id, String nombreEmpleado, boolean estado) {
		this.id=id;
		this.nombreEmpleado=nombreEmpleado;
		this.estado=estado;
	}

	/**
	 * Obtiene id
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setea id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene nombreEmpleado
	 * @return nombreEmpleado
	 */
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	/**
	 * Setea nombreEmpleado
	 * @param nombreEmpleado
	 */
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	/**
	 * Obtiene estado
	 * @return estado
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Setea estado
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
