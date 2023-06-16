package ar.edu.unju.fi.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Paseo;

/**
 * Interfaz IPaseoService
 * @author Grupo2
 *
 */
@Service
public interface IPaseoService {
	
	List <Paseo> getListaPaseo(); /*metodo abstracto para obtener la lista de paseadores*/
	void guardar (Paseo paseo); /*metodo abstracto para guardar un paseador a la lista de paseadores*/
	Paseo getBy(String legajo); /*metodo abstracto para buscar un paseador dentro de la lista de paseadores*/
	void modificar (Paseo paseo); /*metodo abstracto para modificar un paseador dentro de la lista de paseadores*/
	void eliminar (String legajo); /*metodo abstracto para eliminar un paseador de la lista de paseadores*/
	Paseo getPaseo(); /*metodo abstracto para obtener un objeto tipo paseador*/
	
}
