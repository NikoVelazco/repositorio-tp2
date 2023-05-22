

package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Producto;
public class ListaProducto {
	private List<Producto> productos;
	
	
	public ListaProducto() {
		productos = new ArrayList<Producto>();
		productos.add(new Producto("Advanced", 01, 6500, "advancealim.png",0));
		productos.add(new Producto("Juguete Pollo", 02, 2500, "juguete pollo.webp",0));
		productos.add(new Producto("Pedigree", 03, 5500, "pedigree.jpeg",0));
		productos.add(new Producto("Campera", 04, 4500, "campera.jpg",0));
		
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


