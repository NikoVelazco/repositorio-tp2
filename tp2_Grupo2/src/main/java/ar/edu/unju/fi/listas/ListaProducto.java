

package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Producto;
public class ListaProducto {
	private List<Producto> productos;
	
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Advanced", 01, 6500, "alimento", 0));
		productos.add(new Producto("Pedigree", 02, 5500, "alimento", 0));
		productos.add(new Producto("Pelota", 03, 2500, "juguete", 0));
		productos.add(new Producto("Buzo", 04, 4500, "ropa", 0));
		productos.add(new Producto("Campera", 05, 4500, "ropa", 0));
		
	}


	public ListaProducto(List<Producto> productos) {
		super();
		this.productos = productos;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	

}


