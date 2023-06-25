package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.entity.Paseo;
import ar.edu.unju.fi.service.IEmpleadoService;
import ar.edu.unju.fi.service.IPaseoService;
import jakarta.validation.Valid;

/**
 * 
 * @author Grupo2
 * Capa Controladora para la Página paseos.html
 *
 */

@Controller
@RequestMapping("/paseo")
public class PaseoController {
	
	/**
	 * Inyecta e instancia el objeto paseoService de tipo IPaseoService al contenedor
	 * La interfaz es IPaseoService
	 */
	@Autowired
	@Qualifier("PaseoServiceMysql")
	private IPaseoService paseoService;
	
	/**
	 * Inyecta el servicio empleadoServiceMysql
	 */
	@Autowired
	@Qualifier("EmpleadoServiceMysqlImp")
	private IEmpleadoService empleadoService;
	
	/**
	 * Inyecta e instancia un objeto Empleado al contenedor
	 */
	@Autowired
	private Empleado unEmpleado;
	
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
		model.addAttribute("empleados", empleadoService.getListaEmpleado());
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
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result) {
		unEmpleado = empleadoService.findEmpleadoById(paseo.getEmpleado().getId());
		paseo.setEmpleado(unEmpleado);
		ModelAndView modelView = new ModelAndView("paseos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_paseo");
			modelView.addObject("paseo", paseo);
			modelView.addObject("empleados", empleadoService.getListaEmpleado());
			return modelView;
		}
		paseoService.guardar(paseo);
		modelView.addObject("paseos", paseoService.getListaPaseo());
		return modelView;
	}
	
	/**
	 * Petición para modificar un servicio
	 * @param id a modificar
	 * @param model usado para enviar el objeto encontrado a la página
	 * @return pagina nuevo_paseo
	 */
	@GetMapping("/modificar/{id}")
	public String getModificarServicioPage(@PathVariable(value="id")Long id, Model model) {
		boolean edicion = true;
    	model.addAttribute("edicion", edicion);
    	Paseo paseoEncontrado = paseoService.getBy(id);
		model.addAttribute("paseo", paseoEncontrado);
		model.addAttribute("empleados", empleadoService.getListaEmpleado());
		return "nuevo_paseo";
	}
	
	/**
	 * Petición para guardar el objeto modificado
	 * @param paseo objeto que contiene a los servicios
	 * @param result activa las validaciones
	 * @param model vincula la variable al formulario
	 * @return paseos.html
	 */
	@PostMapping("/modificar")
	public String modificarPaseo(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result, Model model) {
		Paseo paseoEncontrado = paseoService.getBy(paseo.getId());
	    boolean edicion = true;
		if (result.hasErrors()) {
			paseo.setId(paseoEncontrado.getId());
			model.addAttribute("paseo", paseo);
			model.addAttribute("edicion", edicion);
			model.addAttribute("empleados", empleadoService.getListaEmpleado());
			return "nuevo_paseo";
		} else {
			unEmpleado = empleadoService.findEmpleadoById(paseo.getEmpleado().getId());
			paseo.setEmpleado(unEmpleado);
			paseoService.modificar(paseo, paseo.getId()); 
			return "redirect:/paseo/listado";
		}
	}
	
	/**
	 * Petición para eliminar un servicio según el id
	 * @param id a eliminar
	 * @return paseos.html
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarPaseo(@PathVariable(value="id")Long id) {
		Paseo paseoEncontrado = paseoService.getBy(id);
		paseoService.eliminar(paseoEncontrado);
		return "redirect:/paseo/listado";
	}
	
}
