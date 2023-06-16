package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.entity.Paseo;
import ar.edu.unju.fi.service.IPaseoService;
import jakarta.validation.Valid;

/**
 * 
 * @author Grupo2
 * Capa Controladora para la Página paseos.html
 *
 */

@Component
@Controller
@RequestMapping("/paseo")
public class PaseoController {
	
	/**
	 * Inyecta e instancia el objeto paseoService de tipo IPaseoService al contenedor
	 * La interfaz es IPaseoService
	 */
	@Autowired
	private IPaseoService paseoService;
	
	/**
	 * Petición para dirigirse a la página paseos.html
	 * @param model usado para agregar a la vista de paseos
	 * @return pagina paseos
	 */
	@GetMapping("/listado")
	public String getListaPaseosPage(Model model) {
		model.addAttribute("paseos", paseoService.getListaPaseo());
		return "paseos";
	}
	
	
	/**
	 * Petición para dirigirse a la página nuevo_paseo
	 * @param model vincula la variable pas de tipo paseo al formulario
	 * la variable edicion indentifica la acción que debe realizar
	 * @return página nuevo_paseo
	 */
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {
		boolean edicion=false;
		model.addAttribute("paseo", paseoService.getPaseo());
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	/**
	 * Petición para guardar el objeto pas dentro de la lista de paseos
	 * @param paseo es el objeto a guardar
	 * @param result activa las validaciones dentro del modelo
	 * @param model vincula la variable al formulario
	 * @return página paseos
	 */
	@PostMapping("/guardar")
	public String getGuardarPaseoPage(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result, Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		if(result.hasErrors()) {
			model.addAttribute("paseo", paseo);
			return "nuevo_paseo";
		}
		paseoService.guardar(paseo);
		model.addAttribute("paseo", paseoService.getPaseo());
        return "redirect:/paseo/listado";
    }
	
	/**
	 * Petición para modificar un paseador
	 * @param legajo a modificar
	 * @param model usado para enviar el objeto encontrado a la página
	 * @return pagina nuevo_paseo
	 */
	@GetMapping("/modificar/{legajo}")
	public String getModificarServicioPage(@PathVariable("legajo")String legajo, Model model) {
		boolean edicion = true;
    	model.addAttribute("edicion", edicion);
    	Paseo paseoEncontrado = paseoService.getBy(legajo);
		model.addAttribute("paseo", paseoEncontrado);
		return "nuevo_paseo";
	}
	
	/**
	 * Petición para guardar el objeto modificado
	 * @param paseo objeto que contiene a los paseadores
	 * @param result activa las validaciones
	 * @param model vincula la variable al formulario
	 * @return paseos.html
	 */
	@PostMapping("/modificar")
	public String modificarPaseo(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result, Model model) {
		Paseo paseoEncontrado = paseoService.getBy(paseo.getLegajo());
	    boolean edicion = true;
		if (result.hasErrors()) {
			paseo.setLegajo(paseoEncontrado.getLegajo());
			model.addAttribute("paseo", paseo);
			model.addAttribute("edicion", edicion);
			return "nuevo_paseo";
		} else {
			paseoService.modificar(paseo); 
			return "redirect:/paseo/listado";
		}
	}
	
	/**
	 * Petición para eliminar un paseador según el legajo
	 * @param legajo a eliminar
	 * @return paseos.html
	 */
	@GetMapping("/eliminar/{legajo}")
	public String eliminarPaseo(@PathVariable("legajo")String legajo) {
		paseoService.eliminar(legajo);
		return "redirect:/paseo/listado";
	}
	
}

