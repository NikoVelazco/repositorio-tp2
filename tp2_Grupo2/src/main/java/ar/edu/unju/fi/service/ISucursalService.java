package ar.edu.unju.fi.service;
import java.util.List;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;

/**
 * Interfaz para la clase sucursal
 * 
 *
 * @author Grupo 2
 *
 */

@Service
public interface ISucursalService {
	/*devuelve lista de las sucursales*/
	List<Sucursal> getListaSucursal();
	/*guarda una nueva sucursal*/
	void guardar(Sucursal sucursal);
	/*busca una sucursal*/
	Sucursal getBy(String nombre);
	/*modificar una sucursal*/
	void modificar(Sucursal sucursal);
	/*eliminar una sucursal*/
	void eliminar(Sucursal sucursalEncontrada);
	Sucursal getSucursal();
	
}