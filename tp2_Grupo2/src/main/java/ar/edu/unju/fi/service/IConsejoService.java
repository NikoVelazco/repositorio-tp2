package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;

/**
 * Interfaz IConsejoService
 * @author Grupo2
 *
 */

public interface IConsejoService {
	List<Consejo> getListaConsejo();
	void guardar (Consejo consejo); 
	Consejo getBy(Long id); 
	void modificar (Consejo consejo, Long id); 
	void eliminar (Consejo consejoEncontrado); 
	Consejo getConsejo();	
}