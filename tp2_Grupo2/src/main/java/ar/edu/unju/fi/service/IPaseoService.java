package ar.edu.unju.fi.service;

import java.util.List;
import ar.edu.unju.fi.entity.Paseo;

/**
 * Interfaz IPaseoService
 * @author Grupo2
 *
 */

public interface IPaseoService {
	
	List <Paseo> getListaPaseo(); /*metodo abstracto para obtener la lista de servicios*/
	void guardar (Paseo paseo); /*metodo abstracto para guardar un paseador a la lista de servicios*/
	Paseo getBy(Long id); /*metodo abstracto para buscar un paseador dentro de la lista de servicios*/
	void modificar (Paseo paseo, Long id); /*metodo abstracto para modificar un paseador dentro de la lista de servicios*/
	void eliminar (Paseo paseoEncontrado); /*metodo abstracto para eliminar un paseador de la lista de servicios*/
	Paseo getPaseo(); /*metodo abstracto para obtener un objeto tipo servicios*/
	
}
