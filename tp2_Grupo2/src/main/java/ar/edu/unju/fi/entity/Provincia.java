package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author Grupo 2
 * Clase Provincia
 */

@Component
@Entity 
@Table(name="provincias")
public class Provincia {
	
	@Id
	@Column(name="provi_id")	
	private Long id; /*Identificador para la provincia*/
	
	
	@Column(name="provi_nombre")
	private String nombre; /*nombre de la provincia*/
	
	@Column(name="provi_estado")
	private boolean estado;
	
	/**
	 * Constructor por defecto
	 */
	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * @param id
	 * @param nombre
	 * @param estado	
	 */
	public Provincia(Long id, String nombre, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}

	/**
	 * Método para obtener el id de la provincia
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	

	/**
	 * Metodo para guardar el id de la provinica
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Método para obtener el nombre de la provinica
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

   /**
    * Metodo para guardar el nombre de la provincia
    * @param nombre
    */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Regresa el estado de la provincia
	 * @return estado
	 */
	public boolean isEstado() {
		return estado;
	}
	
	/**
	 * Guarda estado de la provincia
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
