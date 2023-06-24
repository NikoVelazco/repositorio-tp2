package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * 
 * @author Grupo2
 *
 */
@Component
@Entity
@Table(name="servicio")
public class Paseo {
	
	//Atributos de la clase Paseo
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serv_id")
	private Long id; //Clave Primaria
	
	@NotEmpty(message="el campo servicio no puede estar vacio")
	@Pattern(regexp = "[S][e][r][v]+[0-9][0-9][0-9][0-9]", 
	 message = "Ingrese un servicio válido Ej: (Serv0001)")
	@Column(name="serv_idService", length = 8, nullable = false)
	private String idService; /*Id del Servicio*/
	
	@NotEmpty(message="el campo nombre servicio no puede estar vacio")
	@Pattern(regexp = "^[\\p{L} ]+$", message = "El nombre servicio solo puede contener letras y espacios")
	@Size(max=30,message="Máximo 30 caracteres")
	@Column(name="serv_nombre", length = 30, nullable = false)
	private String nombreService;/*Nombre del Servicio*/
	
	@NotEmpty(message="el dia de la semana no puede estar vacio")
	@Column(name="serv_semana", length = 10, nullable = false)
	private String diaSemana; /*Dia de la semana del servicio*/
	
	@Pattern(regexp = "[0-9][0-9][h][s]+-+[0-9][0-9][h][s]",
	message = "Ingrese un horario válido Ej: 08hs-12hs")
	@NotEmpty(message="el horario no puede estar vacio")
	@Column(name="serv_horario", length = 10, nullable = false)
	private String horario; /*Horario del servicio*/
	
	@Column(name="serv_estado")
	private boolean estado; //True=Habilitado; False=Deshabilitado
	
	/**
	 * Constructor por defecto
	 */
	public Paseo() {
		
	}
	
	/**
	 * Constructor parametrizado
	 * @param id
	 * @param idService
	 * @param nombreService
	 * @param diaSemana
	 * @param horario
	 * @param estado
	 */
	public Paseo(Long id, String idService, String nombreService, String diaSemana, String horario, boolean estado) {
		this.id=id;
		this.idService=idService;
		this.nombreService=nombreService;
		this.diaSemana=diaSemana;
		this.horario=horario;
		this.estado=estado;
	}

	/**
	 * Obtiene IdService
	 * @return idService
	 */
	public String getIdService() {
		return idService;
	}
	
	/**
	 * Setea idService
	 * @param idService
	 */
	public void setIdService(String idService) {
		this.idService = idService;
	}
	
	/**
	 * Obtiene nombre de Servicio
	 * @return nombreService
	 */
	public String getNombreService() {
		return nombreService;
	}

	/**
	 * setea nobre de servicio
	 * @param nombreService
	 */
	public void setNombreService(String nombreService) {
		this.nombreService = nombreService;
	}
	
	/**
	 * Obtiene dia de semana
	 * @return diaSemana
	 */
	public String getDiaSemana() {
		return diaSemana;
	}
	
	/**
	 * setea diaSemana
	 * @param diaSemana
	 */
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * obtiene horario
	 * @return horario
	 */
	public String getHorario() {
		return horario;
	}
	
	/**
	 * setea horario
	 * @param horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	/**
	 * obtiene id
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * setea id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * obtiene estado
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

