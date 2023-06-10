package ar.edu.unju.fi.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ListaProducto;
import ar.edu.unju.fi.model.Producto;

/**
 * Interfaz para la clase Producto
 * @author Grupo 2
 *
 */

@Service
public interface IProductoService {
	
	List<Producto> getListaProducto();/*metodo abstracto para obtener la lista de productos*/
	void guardar (Producto producto); /*metodo abstracto para guardar un producto a la lista de productos*/
	Producto getBy(String codigo); /*metodo abstracto para buscar un producto dentro de la lista de productos*/
	void modificar (Producto producto); /*metodo abstracto para modificar un producto dentro de la lista de productos*/
	void eliminar (Producto productoEncontrado); /*metodo abstracto para eliminar un producto de la lista de productos*/
	Producto getProducto();	/*metodo abstracto para obtener un objeto tipo producto*/

}
