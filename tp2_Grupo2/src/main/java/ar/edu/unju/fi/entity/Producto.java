
package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component 
@Entity
@Table(name="productosbd")
public class Producto {

	//Propiedades de la clase Producto
	@Column(name="nombre",length=30,nullable=false)
	@NotEmpty(message="El nombre no puede ser vacio") /* se añaden las validaciones del fromulario  */
	@Size(min=6, message="El nombre debe tener minimo 6 caracteres")
	private String nombre;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Codigo")
	@Positive(message="Solo se permiten valores positivos")
	private Long codigo;
	
	@Column(name="Precio")
	@Min(value=100,message="el valor minimo permitido es 100")
	@Max(value=100000,message="El valor maximo permitido es 1000000")
	@Positive(message="Solo se permiten valores positivos")
	private double precio;
	
	@Column(name="Categoria")
	@NotBlank(message="Debe seleccionar una categoria")
	private String categoria;
	
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
		public Producto(String nombre, Long codigo, double precio, String categoria, int descuento) {
			//inicializamos las propiedades con los valores pasados por párametros
			this.nombre=nombre;
			this.codigo=codigo;
			this.precio=precio;
			this.categoria=categoria;
			this.descuento=descuento;
		}
		
		//Getters y Setters para las propiedades de la clase
		/**
		 * Obtiene el nombre del producto
		 * @return el nombre del producto
		 */
		public String getNombre() {
			return nombre;
		}
		
		/**
		 * Establece el nombre del producto
		 * @param nombre el nuevo nombre
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * Obtiene el código del producto
		 * @return el código del producto
		 */
		/*public int getCodigo() { cambia
			return codigo;
		}
		
		/**
		 * Establece el código del producto
		 * @param codigo nuevo código
		 */
		/**public void setCodigo(int codigo) { cambia
			this.codigo = codigo;
		}
		*/
		/**
		 * Obtiene el precio del producto
		 * @return el precio del producto
		 */
		public double getPrecio() {
			return precio;
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
		public String getCategoria() {
			return categoria;
		}
		
		/**
		 * Estable la categoría del producto
		 * @param categoria nueva categoría
		 */
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		
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
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public void getCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public Object getCodigo() {
			// TODO Auto-generated method stub
			return null;
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
}


