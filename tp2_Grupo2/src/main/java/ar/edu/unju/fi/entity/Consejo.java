package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="consejo")
public class Consejo {	
	
	//@NotNull(message = "{error.idConsejo.notEmpty}")
	//@Positive(message="El id debe ser un numero positivo") /validacion para que el idConsejo sea mayor que cero/
	//private int idConsejo;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cons_id")
	private Long id;
	
	@Column(name="cons_categoria")
	@NotBlank(message="Debe seleccionar una categoria")//validacion para que no se ingrese atributo en blanco/
	private String categoria;
	
	@Column(name="cons_edadMascota")
	@NotBlank(message="Debe seleccionar un rango edad") //validacion para que no se ingrese atributo en blanco/
	private String edadMascota;	
	
	@Column(name="cons_sexoMascota")
	@NotBlank(message="Debe seleccionar una opcion de sexo de mascota") //validacion para que no se ingrese atributo en blanco/
	private String sexoMascota;
	
	@Column(name="cons_descripcion")
	@Size(min=15,message="Descripcion minima de 15 caracteres") //validacion para que se ingrese atributo con mas de 15 caracteres/
	private String descripcion;
	
	@Column(name="cons_estado")
	private boolean estado;
	
	
	//Constructor por defecto/
	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * @param idConsejo numero de identificacion del consejo, usado como clave primaria
	 * @param categoria ALIMENTACION, SALUD, CUIDADOS, VARIOS
	 * @param edad CACHORRO, JOVEN, ADULTO, INDISTINTO
	 * @param sexoMascota MACHO, HEMBRA, INDISTINTO	
	 * @param descripcion del consejo
	 */	
	
	public Consejo(Long id, String categoria, String edadMascota, String sexoMascota, String descripcion, boolean estado) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.edadMascota = edadMascota;
		this.sexoMascota = sexoMascota;
		this.descripcion = descripcion;
		this.estado=estado;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Metodo que recupera el atributo sexoMascota
	 * @return sexoMascota
	 */
	public String getSexoMascota() {
		return sexoMascota;
	}

	/**
	 * Metodo para guardar el sexo de la mascota
	 * @param sexoMascota
	 */
	public void setSexoMascota(String sexoMascota) {
		this.sexoMascota = sexoMascota;
	}

	/**
	 * Metodo que recupera el atributo edadMascota
	 * @return edadMascota
	 */
	public String getEdadMascota() {
		return edadMascota;
	}

	/**
	 * Metodo para guardar la edad de la mascota
	 * @param edadMascota
	 */
	public void setEdadMascota(String edadMascota) {
		this.edadMascota = edadMascota;
	}

	/**
	 * Metodo que recupera el atributo categoria
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * metodo para guardar la categoría del consejo
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Metodo que recupera el atributo descripcion del consejo
	 * @return descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo para guardar el consejo 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}