package ar.edu.unju.fi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

/**
 * capa Controladora para la pagina consejossalud
 * @author Grupo2
 *
 */

@Controller
@RequestMapping("/consejos") //peticion general para la pagina consejossalud/
public class ConsejoSaludController {

	/**
	 * Inyecta e instancia el objeto ConsejoServise de tipo IConsejoService al contendor. 	  
	 * La interfaz es IConsejoService
	 */
	@Autowired
	@Qualifier("ConsejoServiceMysqlImp")
	private IConsejoService consejoService;	
	
	/**	 
	 * Peticion para dirigirse a la pagina  consejossalud
	 * agrega a la pagina un atributo llamado consejosLista, que es un arraylist con objetos Consejo
	 * @return la pagina consejossalud
	 */
	
	@GetMapping("/listado")
	public String getListadoConsejosSaludPage(Model model) { 
		model.addAttribute("consejosLista",consejoService.getListaConsejo());		
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
		model.addAttribute("consejoAuxiliar", consejoService.getConsejo()); //se crea un objeto de tipo Consejo llamado consejoNuevo (que este en el form de nuevo_consejo)y ese nombre es usado en la pagina/
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
	public ModelAndView getGuardarConsejoPage(@Valid @ModelAttribute("consejoAuxiliar") Consejo consejo, BindingResult result){   //resutl objeto para capturar el resultado de la validacion/
		ModelAndView modelView =new ModelAndView("consejossalud");
		if (result.hasErrors()) { //resutado de la validacion/
			modelView.setViewName("nuevo_consejo"); //si hay error, se mantien la vista/
			modelView.addObject("consejoAuxiliar",consejo);//devuelve el objeto a la vista con los ingresados/
			return modelView;
		}
		consejoService.guardar(consejo);
		modelView.addObject("consejosLista",consejoService.getListaConsejo());
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
	
	@GetMapping ("/modificar/{id}")
	public String getModificarConsejosPage(Model model, @PathVariable(value="id") Long id ) {
		Consejo consejoEncontrado = consejoService.getConsejo();
		boolean edicion = true;
		consejoEncontrado=consejoService.getBy(id);
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
	public String getModificarConsejo(@Valid @ModelAttribute("consejoAuxiliar") Consejo consejo,BindingResult result,Model model){
		if(result.hasErrors()) {
			model.addAttribute("edicion",true);
			return "nuevo_consejo";
		}		
		consejoService.modificar(consejo, consejo.getId());
		return "redirect:/consejos/listado";
	}
	
	/**
	 * Peticion para eliminar un objeto tipo Consejo 
	 * @param codigo: guarda el atributo idConsejo del objeto a eliminar
	 * @return pagina consejossalud usando redirect 
	 */
	@GetMapping("/eliminar/{id}")
	public String getEliminarConsejo (@PathVariable(value="id") Long id){
		Consejo consejoEncontrado = consejoService.getBy(id);
		consejoService.eliminar(consejoEncontrado);
		return "redirect:/consejos/listado";		
	}	
}