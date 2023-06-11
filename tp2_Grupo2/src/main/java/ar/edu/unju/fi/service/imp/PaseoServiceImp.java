package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.listas.ListaPaseo;
import ar.edu.unju.fi.model.Paseo;
import java.util.List;
import ar.edu.unju.fi.service.IPaseoService;

/**
 * Clase para implementar el servicio IPaseoService
 * @author Grupo2
 *
 */
@Service
public class PaseoServiceImp implements IPaseoService{
	
	/**
	 * Inyecta e instancia el objeto listaPaseos en el contenedor
	 */
	@Autowired
	private ListaPaseo listaPaseos;
	
	/**
	 * Inyecta e instancia el objeto paseo en el contenedor
	 */
	@Autowired
	private Paseo paseo;
	
	/**
	 * Método que retorna la lista paseo
	 */
	@Override
	public List<Paseo> getListaPaseo(){
		
		return listaPaseos.getPaseos();
		
	}
	
	/**
	 * Método que guarda la lista paseo
	 */
	@Override
	public void guardar(Paseo paseo) {
		listaPaseos.getPaseos().add(paseo);		
	}
	
	/**
	 * Método de busqueda por el legajo del paseador
	 */
	@Override
	public Paseo getBy(String legajo) {
		Paseo paseoEncontrado = null;
		for(Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getLegajo().equals(legajo)) {
				paseoEncontrado = pas;
				break;
			}			
		}

		return paseoEncontrado;
	}
	
	/**
	 * Método para modificar los atributos del obejto paseo
	 */
	@Override
	public void modificar(Paseo paseo) {
		for (Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getLegajo().equals(paseo.getLegajo())) {
				pas.setNombre(paseo.getNombre());
				pas.setAnioExperiencia(paseo.getAnioExperiencia());
				pas.setTelefono(paseo.getTelefono());
				pas.setEmail(paseo.getEmail());
				pas.setHorario(paseo.getHorario());
				pas.setDescripcion(paseo.getDescripcion());
		        break;
			}
		}
	}
	
	/**
	 * Método para eliminar un paseador de la lista
	 */
	@Override
	public void eliminar(String legajo) {	
		for (Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getLegajo().equals(legajo)) {
				listaPaseos.getPaseos().remove(pas);   
				break;
			}
		}		
	}
	
	/**
	 * Metodo para crear un objeto tipo Paseo
	 */
	@Override	
	public Paseo getPaseo() {		
		return paseo;
	}
	
}
