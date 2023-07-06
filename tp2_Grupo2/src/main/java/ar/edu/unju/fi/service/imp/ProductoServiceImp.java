package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.service.IProductoService;

/**
 * Clase para la implementacion del servicio IProductoService
  @author Grupo 2
 *
 */
@Service("productoServiceImp")
public class ProductoServiceImp implements IProductoService {

	/**
	 * Inyecta e intancia el objeto listaProductos en el contenedor
	 */
	@Autowired
	private ListaProducto listaProductos;
	
	/**
	 * Inyecta e intancia el objeto productos en el contenedor
	 */
	@Autowired
	private Producto productos;

	/**
	 * metodo que retorna la lista de productos
	 */
	@Override
	public List<Producto> getListaProducto() {
		
		return  listaProductos.getProductos();
	}

	/**
	 * metodo para guardar el objeto producto en listaProductos
	 */
		@Override
	public void guardar(Producto producto) {
		listaProductos.getProductos().add(producto);
	}
		
	/**
	 * metodo de busqueda por el codigo de producto
	 * retunr el objeto productoEncontrado de tipo Producto
	 * @return 
	 */
	@Override
	public Producto getBy(Long idProducto) {
		Producto productoEncontrado = null;
		for(Producto produ : listaProductos.getProductos()) {
			if(produ.getIdProducto()==idProducto) {
				productoEncontrado = produ;
			break;
		}
		
		return productoEncontrado;
	
	}
		return productoEncontrado;

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

	/**
 * Metodo para modificar los atributos del objeto producto
 * producto es el objeto a modificar enviado por parametro
 */
	
	@Override
	public void modificar(Producto producto){
		for(Producto produ: listaProductos.getProductos()) {
			if(produ.getIdProducto()==producto.getIdProducto()) {
				produ.setNombre(producto.getNombre());
				produ.setPrecio(producto.getPrecio());
				produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());
				break;
				
					
			}
		}
	}

	@Override
	public List<Producto> getListaProductoPorCategoria(String categoria, boolean estado) {
		return listaProductos.getProductos();
	}
	
	}