package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Paseo;

/**
 * Interfaz IPaseoService
 * @author Grupo2
 *
 */

public interface IPaseoService {
	
	List <Paseo> getListaPaseo(); 
	void guardar (Paseo paseo); 
	Paseo getBy(Long id); 
	void modificar (Paseo paseo, Long id); 
	void eliminar (Paseo paseoEncontrado); 
	Paseo getPaseo(); 
	List<Paseo> getListaPaseoFiltrada(String diadesemana); 
	
}
