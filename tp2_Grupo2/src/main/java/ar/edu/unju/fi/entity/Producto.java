
package ar.edu.unju.fi.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


@Component 
@Entity
@Table(name="productosbd")
public class Producto {
	
	@Id/*clave primaria*/
	@GeneratedValue(strategy=GenerationType.IDENTITY)/*genera valores numericos secuenciales*/
	@Column(name="Id")	
	private Long idProducto; 

	//Propiedades de la clase Producto
	@Column(name="Nombre",length=30,nullable=false)
	@NotEmpty(message="El nombre no puede ser vacio") /* se añaden las validaciones del formulario  */
	@Size(min=6, message="El nombre debe tener minimo 6 caracteres")
	private String nombre;
	
	
	@Column(name="Precio")
	@Min(value=100,message="el valor minimo permitido es 100")
	@Max(value=100000,message="El valor maximo permitido es 1000000")
	@Positive(message="Solo se permiten valores positivos")
	private double precio;
	
	
	
	@Autowired
	@JoinColumn(name="categoria_id")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@NotNull(message="Debe seleccionar una categoria")
	private Categoria categoria; 
	
	@Column(name="Descuento")
	/*@Min(value=0,message="el valor minimo permitido es 1")*/
	@Max(value=50,message="El valor maximo permitido es 50")
	@PositiveOrZero(message="Solo se permiten valores enteros positivos o cero")
	private int descuento;
	
	@Column(name="Estado")
	private boolean estado;

		
		public Producto(boolean estado) {
		super();
		this.estado = estado;
	}

		//Constructor por defecto
		public Producto() {
			
		}
		
		/**
		 * Constructor con párametros
		 * @param nombre Nombre del producto
		 * @param codigo Código del producto
		 * @param precio Precio del producto
		 * @param categoria Categoría del producto
		 * @param descuento Descuento del producto
		 */
		
				
		public Producto(Long idProducto, String nombre, double precio, Categoria categoria, int descuento, boolean estado) {
			//inicializamos las propiedades con los valores pasados por párametros
			super();
			this.idProducto = idProducto;
			this.nombre = nombre;
			this.precio = precio;
			this.categoria = categoria;
			this.descuento = descuento;
			this.estado = estado;
		}

		//Getters y Setters para las propiedades de la clase
			
		
		/**
		 * Obtiene el precio del producto
		 * @return el precio del producto
		 */
		public double getPrecio() {
			return precio;
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setIdProducto(Long idProducto) {
			this.idProducto = idProducto;
		}

		/**
		 * Establece el precio del producto
		 * @param precio nuevo precio
		 */
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		
		/**
		 * Obtiene la categoría del producto
		 * @return la categoría del producto
		 */
		
		
		/**
		 * Estable la categoría del producto
		 * @param unaCategoria nueva categoría
		 */
		
		
		/**
		 * Obtiene el descuento del producto
		 * @return descuento del producto
		 */
		public int getDescuento() {
			return descuento;
		}
		
		/**
		 * Estable descuento del producto
		 * @param descuento nuevo descuento
		 */
		public void setDescuento(int descuento) {
			this.descuento = descuento;
		}
		
		
		/**
		 * Calcula el descuento del producto, el descuento es entero entre (0-50)
		 * @return retorna el nuevo precio
		 */
		public double calcularDescuento() {
			return this.precio - (this.precio * ((double)descuento/100)); // (double) para que tome la división decimal
			
		}
		
		public boolean getEstado() {
			return estado;
		}
		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public Long getIdProducto() {
			return idProducto;
		}

		public void setId(Long idProducto) {
			this.idProducto = idProducto;
		}

		

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		

		
		
}


