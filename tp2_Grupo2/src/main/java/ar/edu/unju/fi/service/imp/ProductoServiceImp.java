package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

/**
 * 
 * @author Grupo 2
 * Clase para implementar el servicio IProductoService
 */
@Service
public class ProductoServiceImp implements IProductoService {
	
	/**
	 * Inyecta e instancia el objeto listaProductos en el contenedor
	 */	
	@Autowired
	private ListaProducto listaProductos;
	
	/**
	 * Inyecta e instancia el objeto productos en el contenedor
	 */	
	@Autowired
	private Producto productos;
		
	/**
	 * metodo que retorna la lista de productos
	 */
	@Override
	public List<Producto> getListaProducto() {
		
		return listaProductos.getProductos(); 
	}

	/**
	 * metodo para guardar el objeto producto en listaProductos
	 */
	@Override
	public void guardar(Producto producto) {
		listaProductos.getProductos().add(producto);		
	}

	/**
	 * Metodo de busqueda por el codigo de producto
	 * return el objeto productoEncontrado de tipo Producto
	 */
	@Override
	public Producto getBy(String codigo) {
		Producto productoEncontrado = null;
		for(Producto produ : listaProductos.getProductos()) {
			if (produ.getCodigo()==Integer.parseInt(codigo)) {
				productoEncontrado = produ;
				break;
			}			
		}

		return productoEncontrado;
	}

	/**
	 * Metodo para modificar los atributos del obejto producto
	 * producto es el objeto a modificar enviado por parametro
	 */
	@Override
	public void modificar(Producto producto) {
		for(Producto produ : listaProductos.getProductos()) {
			if(produ.getCodigo()==producto.getCodigo()) {
				produ.setNombre(producto.getNombre());
				produ.setPrecio(producto.getPrecio());				
				produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());
				break;
			}
		}
		
	}

	/**
	 * Metodo para eliminar un producto de la lista
	 */
	@Override
	public void eliminar(Producto productoEncontrado) {		
		listaProductos.getProductos().remove(productoEncontrado);		
	}

	/**
	 * Metodo para crear un objeto tipo Producto
	 */
	@Override	
	public Producto getProducto() {		
		return productos;
	}	

}
