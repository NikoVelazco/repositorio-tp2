package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ar.edu.unju.fi.listas.ListaConsejo;
import ar.edu.unju.fi.model.Consejo;


@Controller
@RequestMapping("/consejos") /*peticion general para la pagina consejos*/
public class ConsejosSaludController {

	/**
	 * se construye el objeto listaConsejos tipo arraylist que se usara en /guardar
	 */
	ListaConsejo listaConsejos =new ListaConsejo();	
	
	/**
	 * Model es el nexo a la pagina
	 * Metodo que captura la peticion http en forma de URL 
	 * agrega a la pagina un atributo llamado consejosLista, que es un arraylist con objetos Consejo
	 * @return la pagina consejossalud
	 */
	
	@GetMapping("/listado")
	public String getListadoConsejosSaludPage(Model model) { 
		model.addAttribute("consejosLista",listaConsejos.getConsejos());		
		return "consejossalud";
	
	}
	
	/**
	 * Peticion para ingresar a nuevo consejo
	 * @param model para que vincule la variable tipo Consejo al formulario
	 * @return pagina para nuevo consejo y una variable llamada consejoAuxiliar de tipo Consejo
	 * y la variable edicion que identifica la accion dentro de la pagina nuevo_consejo
	 */
	@GetMapping("/nuevo")
	public String getConsejosSaludAltaPage(Model model){
		boolean edicion = false;
		model.addAttribute("consejoAuxiliar",new Consejo()); /*se crea un objeto de tipo Consejo llamado consejoNuevo (que este en el form de nuevo_consejo)y ese nombre es usado en la pagina*/
		model.addAttribute("edicion",edicion);
		return "nuevo_consejo";
			
	}
	
	/**
	 * Peticion para guardar el objeto consejoAuxiliar en el array list
	 * @param consejo es un objeto de la clase Consejo que guarda los valores de consejoNuevo
	 * modelView objeto ModelAndView asociado a la pagina consejossalud, 
	 * se usa getConsejos para traer el arraylist y leugo con add se agrega el objeto consejo
	 * se agrega a modelView (la pagina consejossalud) la lista actualizada 	 
	 * @return modelView (consejossalud)
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarConsejoPage(@ModelAttribute("consejoAuxiliar") Consejo consejo){
		ModelAndView modelView =new ModelAndView("consejossalud"); 
		listaConsejos.getConsejos().add(consejo); 
		modelView.addObject("consejosLista",listaConsejos.getConsejos());
		return modelView;
	}
	
	
	/**
	 * Peticion para encontrar objeto consejo dentro de listaConsejos mediante el idConsejo
	 * @param model usado para enviar el objeto encontrado a la pagina 
	 * @param id se usa para la busqueda del objeto, se lo transforma a entero para hacer la busqueda
	 * @return a la pagina nuevo_consejo el objeto encontrado con el nombre consejoNuevo
	 * consejoNuevo es el nombre del objeto usado en la pagina nuevo_consejo
	 * tambien regresa una varible logica usada en formulario para identificar la accion a realizar
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
	 * Peticion para guardar el objeto modificado. consejoAuxiliar tiene los valores cambiados
	 * @param consejo objeto que guarda los valores de consejoNuevo de la pagina
	 * 
	 * @return pagina consejossalud usando redirect para usar /consejos/listado 
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
	 * Recibe codigo del objeto a eliminar
	 * @param codigo es codigo del objeto a eliminar
	 * @return pagina consejossalud usando redirect para usar /consejos/listado 
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
