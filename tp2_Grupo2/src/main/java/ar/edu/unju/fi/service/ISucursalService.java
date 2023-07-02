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
	
	List<Sucursal> getListaSucursal();
	
	void guardar(Sucursal sucursal);
	
	Sucursal getBy(Long id);
	
	void modificar(Sucursal sucursal);
	
	void eliminar(Sucursal sucursalEncontrada);
	
	Sucursal getSucursal();
	
	List<Sucursal> getListaSucursalFiltrada(LocalDate fechaInicial, LocalDate fechaFinal); 
	
}