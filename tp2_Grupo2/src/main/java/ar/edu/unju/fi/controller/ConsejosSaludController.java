package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;
import jakarta.validation.Valid;

/**
 * capa Controladora para la pagina consejossalud
 * @author Cristian Ortega
 *
 */

@Component

@Controller
@RequestMapping("/consejos") /*peticion general para la pagina consejossalud*/
public class ConsejosSaludController {

	/**
	 * Autowired  inyecta el objeto listaConsejos dentro del contendor. El objeto es instanciado 	  
	 */
	@Autowired
	private ListaConsejo listaConsejos;	
	/**
	 * Autowired inyecta el objeto consejoI dentro del contendor. El objeto es instanciado
	 */
	@Autowired
	private Consejo consejoI;
	
	/**	 
	 * Peticion para dirigirse a la pagina  consejossalud
	 * agrega a la pagina un atributo llamado consejosLista, que es un arraylist con objetos Consejo
	 * @return la pagina consejossalud
	 */
	
	@GetMapping("/listado")
	public String getListadoConsejosSaludPage(Model model) { 
		model.addAttribute("consejosLista",listaConsejos.getConsejos());		
		return "consejossalud";
	
	}
	
	/**
	 * Peticion para ingresar a la pagina nuevo_consejo
	 * @param model vincula la variable tipo Consejo al formulario
	 * @return pagina nuevo_consejo y una variable llamada consejoAuxiliar de tipo Consejo
	 * la variable edicion identifica la accion dentro de la pagina nuevo_consejo
	 * si es false se va a ingresar un nuevo consejo;
	 * si es true se va a modificar un consejo;
	 */
	@GetMapping("/nuevo")
	public String getConsejosSaludAltaPage(Model model){
		boolean edicion = false;
		model.addAttribute("consejoAuxiliar",consejoI); /*se crea un objeto de tipo Consejo llamado consejoNuevo (que este en el form de nuevo_consejo)y ese nombre es usado en la pagina*/
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
			
	}
	
	/**
	 * Peticion para guardar el objeto consejoAuxiliar en el array list
	 * @param consejo objeto de clase Consejo que guarda los valores de consejoNuevo
	 * modelView objeto ModelAndView asociado a la pagina consejossalud, 
	 * se usa getConsejos para traer el arraylist y luego con add se agrega el objeto consejo
	 * se agrega a modelView (la pagina consejossalud) la lista actualizada
	 * @Valid activa las validaciones dentro del modelo 	 
	 * @return modelView (consejossalud)
	 * 
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejoAuxiliar") Consejo consejo, BindingResult result){   /*resutl objeto para capturar el resultado de la validacion*/
		ModelAndView modelView =new ModelAndView("consejossalud");
		if (result.hasErrors()) { /*resutado de la validacion*/
			modelView.setViewName("nuevo_consejo"); /*si hay error, se mantien la vista*/
			modelView.addObject("consejoAuxiliar",consejo);/*devuelve el objeto a la vista con los ingresados*/
			return modelView;
		}
		listaConsejos.getConsejos().add(consejo); 
		modelView.addObject("consejosLista",listaConsejos.getConsejos());
		return modelView;
	}
	
	
	/**
	 * Peticion para encontrar objeto consejo dentro de listaConsejos mediante el idConsejo
	 * @param model usado para enviar el objeto encontrado a la pagina 
	 * @param id se usa para la busqueda del objeto, se lo transforma a entero para hacer la busqueda
	 * @return pagina nuevo_consejo y el objeto encontrado (con el nombre consejoNuevo)
	 * consejoNuevo es el nombre del objeto usado en la pagina nuevo_consejo
	 * edicion: varible logica usada en formulario para identificar la accion a realizar(guardar/eliminar)
	 */
	
	@GetMapping ("/modificar/{codigo}")
	public String getModificarConsejosPage(Model model, @PathVariable(value="codigo") String codigo ) {
		Consejo consejoEncontrado = new Consejo();
		boolean edicion = true;
		for(Consejo conse : listaConsejos.getConsejos()) {
			if (conse.getIdConsejo() == Integer.parseInt(codigo)) {
				consejoEncontrado = conse;
				break;
			}			
		}
		model.addAttribute("consejoAuxiliar",consejoEncontrado);
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
	}

	/**
	 * Peticion para guardar el objeto consejoAuxiliar con valores modificados
	 * @param consejo objeto que guarda los valores de consejoAuxiliar de la pagina
	 * 
	 * @return pagina consejossalud usando redirect  
	 */
	@PostMapping("/modificar")
	public String getModificarConsejo(@ModelAttribute("consejoAuxiliar") Consejo consejo){
		for(Consejo conse : listaConsejos.getConsejos()) {
			if(conse.getIdConsejo()==consejo.getIdConsejo()) {
				conse.setCategoria(consejo.getCategoria());
				conse.setDescripcion(consejo.getDescripcion());
				conse.setEdadMascota(consejo.getEdadMascota());
				conse.setSexoMascota(consejo.getSexoMascota());			
				
			}
		}
		return "redirect:/consejos/listado";
	}
	
	/**
	 * Peticion para eliminar un objeto tipo Consejo 
	 * @param codigo: guarda el atributo idConsejo del objeto a eliminar
	 * @return pagina consejossalud usando redirect 
	 */
	@GetMapping("/eliminar/{codigo}")
	public String getEliminarConsejo (@PathVariable(value="codigo") String codigo){
		Consejo consejoEncontrado = new Consejo();
		for(Consejo conse : listaConsejos.getConsejos()){
			if(conse.getIdConsejo() == Integer.parseInt(codigo)){
				consejoEncontrado = conse;
				break;			
			}			
		}
		listaConsejos.getConsejos().remove(consejoEncontrado);
		return "redirect:/consejos/listado";		
	}	
}


