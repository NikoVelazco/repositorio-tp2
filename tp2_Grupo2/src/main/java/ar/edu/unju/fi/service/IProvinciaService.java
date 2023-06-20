package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;

/**
 * Servicio Provincia
 * @author Grupo 2
 *
 */
@Service
public interface IProvinciaService {
	List<Provincia> getListaProvincia();/*metodo abstracto para obtener el listado de Provincias*/
	Provincia getProvincia(); /*metodo abstracto para obtener un objeto tipo Provincia*/
	void guardarProvincia(Provincia provincia); /*metodo abstracto para guardar una Provincia*/
	public Provincia findProvinciaById(Long id); /*metodo abstracto para buscar una provincia por su id*/
	void cargarProvincia(); /*metodo abstracto para cargar una provincia*/

}
