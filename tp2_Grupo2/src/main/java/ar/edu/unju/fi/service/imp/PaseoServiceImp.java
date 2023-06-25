package ar.edu.unju.fi.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Paseo;
import ar.edu.unju.fi.listas.ListaPaseo;
import java.util.List;
import ar.edu.unju.fi.service.IPaseoService;

/**
 * Clase para implementar el servicio IPaseoService
 * @author Grupo2
 *
 */
@Service("PaseoServiceImp")
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
	 * Método de busqueda por el id del servicio
	 */
	@Override
	public Paseo getBy(Long id) {
		Paseo paseoEncontrado = null;
		for(Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getId()==id) {
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
	public void modificar(Paseo paseo, Long id) {
		for (Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getId()==id) {
				pas.setNombreService(paseo.getNombreService());
				pas.setEmpleado(paseo.getEmpleado());
				pas.setDiaSemana(paseo.getDiaSemana());
				pas.setHorario(paseo.getHorario());
		        break;
			}
		}
	}
	
	/**
	 * Método para eliminar un servicio de la lista
	 */
	@Override
	public void eliminar(Paseo paseoEncontrado) {	
		listaPaseos.getPaseos().remove(paseoEncontrado);
	}
	
	/**
	 * Metodo para crear un objeto tipo Paseo
	 */
	@Override	
	public Paseo getPaseo() {		
		return paseo;
	}
	
}
