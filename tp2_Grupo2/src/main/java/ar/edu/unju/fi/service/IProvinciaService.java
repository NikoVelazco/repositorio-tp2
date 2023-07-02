package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;

/**
 * Servicio Provincia
 * @author Grupo 2
 *
 */

public interface IProvinciaService {
	List<Provincia> getListaProvincia();
	Provincia getProvincia(); 
	void guardarProvincia(Provincia provincia); 
	public Provincia findProvinciaById(Long id); 
	void cargarProvincia(); 

}
