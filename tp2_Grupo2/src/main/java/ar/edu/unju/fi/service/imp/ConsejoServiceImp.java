package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;


/**
 * Clase para implementar el servicio IConsejoService
 * @author Grupo2
 *
 */
@Service ("ConsejoServiceImp")
public class ConsejoServiceImp implements IConsejoService {
	
	/**
	 * Inyecta e instancia el objeto listaConsejos en el contenedor
	 */	
	@Autowired
	private ListaConsejo listaConsejos;	

	/**
	 * Inyecta e instancia el objeto consejoI en el contenedor
	 */	
	@Autowired
	private Consejo consejoI;
	
	/**
	 * metodo que retorna la lista de consejoI
	 */
	@Override
	public List<Consejo> getListaConsejo() {
		return listaConsejos.getConsejos();
	}
	
	/**
	 * metodo para guardar el objeto consejo en listaConsejos
	 */

	@Override
	public void guardar(Consejo consejo) {
		listaConsejos.getConsejos().add(consejo);
		
	}
	/**
	 * Metodo de busqueda por el codigo de consejo
	 * return el objeto consejoEncontrado de tipo Consejo
	 */
	@Override
	public Consejo getBy(Long idConsejo) {
		Consejo consejoEncontrado = null;
		  for(Consejo conse : listaConsejos.getConsejos()) {
			if (conse.getIdConsejo() == idConsejo) {
			 consejoEncontrado = conse;
			 break;

			}			
		}

		return consejoEncontrado;
	}
	
	/**
	 * Metodo para modificar los atributos del obejto consejo
	 * consejo es el objeto a modificar enviado por parametro
	 */
	@Override
	public void modificar(Consejo consejo) {
		for(Consejo conse : listaConsejos.getConsejos()) {
			if(conse.getIdConsejo()==consejo.getIdConsejo()) {
				conse.setCategoria(consejo.getCategoria());
				conse.setDescripcion(consejo.getDescripcion());
				conse.setEdadMascota(consejo.getEdadMascota());
				conse.setSexoMascota(consejo.getSexoMascota());			
				
			}
		}
	}
	
	/**
	 * Metodo para eliminar un consejo de la lista
	 */
	@Override
	public void eliminar(Consejo consejoEncontrado) {
		listaConsejos.getConsejos().remove(consejoEncontrado);		
	}
	
	/**
	 * Metodo para crear un objeto tipo Consejo
	 */
	@Override
	public Consejo getConsejo() {
		return consejoI;
	}

}
