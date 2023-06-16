package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;

/**
 * Interfaz IConsejoService
 * @author Grupo2
 *
 */
@Service
public interface IConsejoService {
	List<Consejo> getListaConsejo();/*metodo abstracto para obtener la lista de consejos*/
	void guardar (Consejo consejo); /*metodo abstracto para guardar un consejo a la lista de consejos*/
	Consejo getBy(String codigo); /*metodo abstracto para buscar un consejo dentro de la lista de consejos*/
	void modificar (Consejo consejo); /*metodo abstracto para modificar un consejo dentro de la lista de consejos*/
	void eliminar (Consejo consejoEncontrado); /*metodo abstracto para eliminar un consejos de la lista de consejos*/
	Consejo getConsejo();	/*metodo abstracto para obtener un objeto tipo consejo*/

}
