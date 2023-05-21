package ar.edu.unju.fi.model;

public class Consejo {
	
	private int idConsejo;
	private String categoria;
	private String edadMascota;	
	private String sexoMascota;		
	private String descripcion;
	
	/*Constructor por defecto*/
	public Consejo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor parametrizado
	 * @param idConsejo
	 * @param categoria ALIMENTACION, SALUD, CUIDADOS, VARIOS
	 * @param edad CACHORRO, JOVEN, ADULTO, INDISTINTO
	 * @param sexoMascota MACHO, HEMBRA, INDISTINTO	
	 * @param descripcion del consejo
	 */	
	
	public Consejo(int idConsejo, String categoria, String edadMascota, String sexoMascota, String descripcion) {
		super();
		this.idConsejo = idConsejo;
		this.categoria = categoria;
		this.edadMascota = edadMascota;
		this.sexoMascota = sexoMascota;
		this.descripcion = descripcion;
	}

	/**
	 * Metodo que recupera el atributo idConsejo
	 * @return id del consejo
	 */
	public int getIdConsejo() {
		return idConsejo;
	}

	
	/**
	 * Metodo para guardar un numero de id en el atributo idConsejo
	 * @param idConsejo
	 */
	public void setIdConsejo(int idConsejo) {
		this.idConsejo = idConsejo;
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
