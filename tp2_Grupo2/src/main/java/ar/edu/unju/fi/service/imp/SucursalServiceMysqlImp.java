package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;

@Service("sucursalServiceMysql")
public class SucursalServiceMysqlImp implements ISucursalService{

	@Autowired
	public ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	
	@Autowired
	private List<Sucursal> sucursalesFiltradas;
	
	/**
	 * Lista las sucursales con estado true
	 */
	@Override
	public List<Sucursal> getListaSucursal() {		
		return sucursalRepository.findByEstado(true);
	}

	/**
	 * guarda una sucursal, el campo estado debe tener el valor true
	 */
	@Override
	public void guardar(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
		
	}

	/**
	 * Recupera una sucursal por su id
	 */
	@Override
	public Sucursal getBy(Long id) {
		return sucursalRepository.findById(id).get();
	}

	/**
	 * Modifica una sucursal
	 */
	@Override
	public void modificar(Sucursal sucursal) {
	
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
		
	}

	/**
	 * eliminacion logica de una sucursal
	 */
	@Override
	public void eliminar(Sucursal sucursalEncontrada){ 
		
		sucursalEncontrada.setEstado(false);
		sucursalRepository.save(sucursalEncontrada);
		
	}

	/**
	 * retorna un objeto Sucursal
	 */
	@Override
	public Sucursal getSucursal() {
		return sucursal;
		
	}
    
	/**
	 * Retorna listado de sucursales filtrada entre dos fechas
	 */
	@Override
	public List<Sucursal> getListaSucursalFiltrada(LocalDate fechaInicial, LocalDate fechaFinal) {
		return sucursalRepository.findByFechaInicioBetween(fechaInicial, fechaFinal);
	}

}
