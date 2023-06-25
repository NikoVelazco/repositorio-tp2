package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;

@Service
public interface ICategoriaService {
	
	List<Categoria> getListaCategoria();
	public Categoria findByCategoriaId(Long id);
	Categoria getCategoria();
	/**
	 * Metodo para guardar una categoria
	 */
	void guardarCategoria(Categoria categoria);
	/**
	 * Metodo para cargar un listado de categorias 
	 */
	void cargarCategoria();

}
