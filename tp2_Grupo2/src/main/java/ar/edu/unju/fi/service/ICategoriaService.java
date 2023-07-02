package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;


public interface ICategoriaService {
	
	List<Categoria> getListaCategoria();
	public Categoria findByCategoriaId(Long id);
	Categoria getCategoria();
	
	void guardarCategoria(Categoria categoria);
	
	void cargarCategoria();

}
