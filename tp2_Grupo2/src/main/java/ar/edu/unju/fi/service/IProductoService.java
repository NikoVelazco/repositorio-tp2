package ar.edu.unju.fi.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;


/**
 * Interfaz para la clase Producto
 * @author Grupo 2
 *
 */


public interface IProductoService {
	
	List<Producto> getListaProducto();
	void guardar (Producto producto); 
	Producto getBy(Long codigo); 
	void modificar (Producto producto); 
	void eliminar (Producto productoEncontrado); 
	Producto getProducto();	
	List<Producto> getListaProductoPorCategoria(String categoria,boolean estado);

}
