package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Component 

public class Producto {

	//Propiedades de la clase Producto
	@NotEmpty(message="El nombre no puede ser vacio") /* se añaden las validaciones del fromulario  */
	@Size(min=6, message="El nombre debe tener minimo 6 caracteres")
	private String nombre;
	
	@Positive(message="Solo se permiten valores positivos")
	private int codigo;
	
	@Min(value=100,message="el valor minimo permitido es 100")
	@Max(value=100000,message="El valor maximo permitido es 1000000")
	@Positive(message="Solo se permiten valores positivos")
	private double precio;
	
	@NotBlank(message="Debe seleccionar una categoria")
	private String categoria;
	
	@Max(value=50,message="El valor maximo permitido es 50")
	@PositiveOrZero(message="Solo se permiten valores enteros positivos o cero")
	private int descuento;

		
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
		public Producto(String nombre, int codigo, double precio, String categoria, int descuento) {
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
		public int getCodigo() {
			return codigo;
		}
		
		/**
		 * Establece el código del producto
		 * @param codigo nuevo código
		 */
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		
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
}

