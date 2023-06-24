package ar.edu.unju.fi.service;
import java.time.LocalDate;
import java.util.List;


import ar.edu.unju.fi.entity.Sucursal;

/**
 * Interfaz para la clase sucursal
 * 
 *
 * @author Grupo 2
 *
 */


public interface ISucursalService {
	/*devuelve lista de las sucursales*/
	List<Sucursal> getListaSucursal();
	/*guarda una nueva sucursal*/
	void guardar(Sucursal sucursal);
	/*busca una sucursal*/
	Sucursal getBy(Long id);
	/*modificar una sucursal*/
	void modificar(Sucursal sucursal);
	/*eliminar una sucursal*/
	void eliminar(Sucursal sucursalEncontrada);
	/*obtiene clase sucursal*/
	Sucursal getSucursal();
	/*metodo abstracto para obtener un lista filtarada por fechas*/
	List<Sucursal> getListaSucursalFiltrada(LocalDate fechaInicial, LocalDate fechaFinal); 
	
}