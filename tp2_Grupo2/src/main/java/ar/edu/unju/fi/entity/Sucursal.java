package ar.edu.unju.fi.entity;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo 2
 * Clase Sucursal
 */

@Component
@Entity 
@Table(name="sucursales")
public class Sucursal {
	
	@Id/*clave primaria*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)/*genera valores numericos secuenciales*/
	@Column(name="sucu_id")	
	private Long id; 
	
	
	@NotEmpty(message="El nombre no puede estar vacio")
	@Column(name="sucu_nombre", length = 20, nullable = false)
	private String nombre;/*nombre de la surusal*/
	
	@NotEmpty(message="La dirección no puede estar vacio")
	@Column(name="sucu_direccion",length = 50, nullable = false)
	private String direccion; /*direccion de la surusal*/
	
	@Autowired
	@JoinColumn(name="provi_id")
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@NotNull(message="Debe seleccionar una provincia")
	
	private Provincia provincia; /*provincia a la que pertenece la sucursal. Provincia es una clase*/
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull(message="La fecha no puede ser vacia")
	@Past(message="La fecha debe ser menor a la fecha actual")
	@Column(name="sucu_fecha_inicio")
	private LocalDate fechaInicio; /*fecha inicio de la sucursal*/
	
	@Email(message="Debe ingresar un email con formato válido")
	@NotEmpty(message="El correo no puede ser vacio")
	@Column(name="sucu_email", nullable = false)
	private String email; /*email de la sucursal*/
	
	@Pattern(regexp="[0-9]*", message="El telefono solo puede tener números sin espacios ni guiones")
	@NotEmpty(message="El teléfono no puede estar vacio")
	@Size(min=10 , max=10, message="El telefono tiene que tener 10 digitos")
	@Column(name="sucu_tel" , nullable = false)
	private String telefono; /*telefono de la sucursal*/
	
	@Column(name="sucu_estado")
	private boolean estado; /*true el objeto esta activo, false el objeto esta eliminado*/
	
	/**
	 * Constructor por defecto
	 */
	public Sucursal() {
		
	}

	/**
	 * Constructor parametrizado
	 * @param id de la sucursal
	 * @param nombre de la sucursal
	 * @param direccion de la sucursal
	 * @param provincia de la sucursal
	 * @param fechaInicio de la sucursal
	 * @param email de la sucursal
	 * @param telefono de la sucursal
	 * @param estado variable logica valor true la sucursal existe, false eliminado
	 */
	public Sucursal(Long id, String nombre, String direccion, Provincia provincia, LocalDate fechaInicio, String email,
			String telefono, boolean estado) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.provincia = provincia;
		this.fechaInicio = fechaInicio;
		this.email = email;
		this.telefono = telefono;
		this.estado = estado;
	}

	/**
	 * Metodo que recupera el atributo nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para guardar el nombre de la sucursal
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que recupera el atributo direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo para guardar la direccion de la sucursal
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo que recupera el atributo provincia
	 * @return provincia
	 */
	public Provincia getProvincia() {
		return provincia;
	}

	/**
	 * Metodo para guardar el atributo provincia
	 * @param provincia
	 */
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	/**
	 * Metodo que recupera el atributo fechaInicio
	 * @return fechaInicio
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Metodo para guardar la fecha de inicio de la sucursal
	 * @param fechaInicio
	 */
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Metodo que recupera el atributo email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo para guardar el email de la sucursal
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que recupera el atributo telefono de la sucursal
	 * @return telefono
	 */ 
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Metodo para guardar el telefono de la sucursal
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo que recupera el atributo id
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo para guardar el id de la sucursal
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo que recupera el atributo estado
	 * @return estado 
	 */
	public boolean isEstado() {
		return estado;
	}

	/**
	 * Metodo para guardar el atributo estado de la sucursal
	 * @param estado si es true el objeto esta diponible, false el objeto esta eliminado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
