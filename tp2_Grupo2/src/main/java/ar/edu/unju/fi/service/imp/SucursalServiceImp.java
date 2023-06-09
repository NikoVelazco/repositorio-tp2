package ar.edu.unju.fi.service.imp;
import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;

/*Se crea la clase SucursalesServiceImp y va a implementar los servicios de ISucuralService*/

@Service("sucursalServiceImp")
public class SucursalServiceImp implements ISucursalService{
	@Autowired
	private ListaSucursal listaSucursales;
	@Autowired
	private Sucursal sucursales;
	@Override
	public List<Sucursal> getListaSucursal(){
		return listaSucursales.getSucursales();
	}
	@Override
	public void guardar(Sucursal sucursal) {
		listaSucursales.getSucursales().add(sucursal);
	}
	@Override
	public Sucursal getBy(Long id) {
		Sucursal sucursalEncontrada=null;
		for(Sucursal sucu : listaSucursales.getSucursales()){
			if(sucu.getId()==id) {
				sucursalEncontrada=sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}
	public void modificar(Sucursal sucursal) {
		for (Sucursal sucu : listaSucursales.getSucursales()) {
			if(sucu.getId() == sucursal.getId()) {
				sucu.setNombre(sucursal.getNombre());
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				break;
			}
		}
	}
	@Override
	public void eliminar(Sucursal sucursalEncontrada) {
		listaSucursales.getSucursales().remove(sucursalEncontrada);
	}
	@Override
	public Sucursal getSucursal() {
		return sucursales;
	}
	@Override
	public List<Sucursal> getListaSucursalFiltrada(LocalDate fechaInicio, LocalDate fechaFin) {
		// TODO Auto-generated method stub
		return null;
	}
}
