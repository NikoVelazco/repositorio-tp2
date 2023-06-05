package ar.edu.unju.fi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Paseo;
import jakarta.validation.Valid;
import ar.edu.unju.fi.listas.ListaPaseo;

@Controller
@RequestMapping("/paseo")
public class PaseoController {
	@Autowired
	private ListaPaseo listaPaseos;
	
	@Autowired
	private Paseo paseo;
	
	@GetMapping("listado")
	public String getListaPaseosPage(Model model) {
		model.addAttribute("paseos", listaPaseos.getPaseos());
		return "paseos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {
		boolean edicion=false;
		model.addAttribute("paseo", paseo);
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result) {
		ModelAndView modelView = new ModelAndView("paseos");
		if(result.hasErrors()) {
			modelView.setViewName("nuevo_paseo");
			modelView.addObject("paseo", paseo);
			return modelView;
		}
		listaPaseos.getPaseos().add(paseo);
		modelView.addObject("paseos", listaPaseos.getPaseos());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="legajo")String legajo) {
		Paseo paseoEncontrado = new Paseo();
		boolean edicion=true;
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(legajo)) {
				paseoEncontrado = pas;
				break;
			}
		}
		model.addAttribute("paseo", paseoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("paseo")Paseo paseo) {
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(paseo.getLegajo())) {
				pas.setNombre(paseo.getNombre());
				pas.setAnioExperiencia(paseo.getAnioExperiencia());
				pas.setTelefono(paseo.getTelefono());
				pas.setEmail(paseo.getEmail());
				pas.setHorario(paseo.getHorario());
				pas.setDescripcion(paseo.getDescripcion());
			}
		}
		return "redirect:/paseo/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarSucursal(@PathVariable(value="legajo")String legajo) {
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(legajo)) {
				listaPaseos.getPaseos().remove(pas);
				break;
			}
		}
		return "redirect:/paseo/listado";
	}
}


/*package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.model.Paseo;
import ar.edu.unju.fi.listas.ListaPaseo;

@Controller
@RequestMapping("/paseo")
public class PaseoController {
	
	ListaPaseo listaPaseos = new ListaPaseo();
	
	@GetMapping("listado")
	public String getListaPaseosPage(Model model) {
		model.addAttribute("paseos", listaPaseos.getPaseos());
		return "paseos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoPaseadorPage(Model model) {
		boolean edicion=false;
		model.addAttribute("paseo", new Paseo());
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@ModelAttribute("paseo")Paseo paseo) {
		ModelAndView modelView = new ModelAndView("paseos");
		listaPaseos.getPaseos().add(paseo);
		modelView.addObject("paseos", listaPaseos.getPaseos());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="legajo")String legajo) {
		Paseo paseoEncontrado = new Paseo();
		boolean edicion=true;
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(legajo)) {
				paseoEncontrado = pas;
				break;
			}
		}
		model.addAttribute("paseo", paseoEncontrado);
		model.addAttribute("edicion", edicion);
		return "nuevo_paseo";
	}
	
	@PostMapping("/modificar")
	public String modificarSucursal(@ModelAttribute("paseo")Paseo paseo) {
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(paseo.getLegajo())) {
				pas.setNombre(paseo.getNombre());
				pas.setAnioExperiencia(paseo.getAnioExperiencia());
				pas.setTelefono(paseo.getTelefono());
				pas.setEmail(paseo.getEmail());
				pas.setHorario(paseo.getHorario());
				pas.setDescripcion(paseo.getDescripcion());
			}
		}
		return "redirect:/paseo/listado";
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarSucursal(@PathVariable(value="legajo")String legajo) {
		for(Paseo pas : listaPaseos.getPaseos()) {
			if(pas.getLegajo().equals(legajo)) {
				listaPaseos.getPaseos().remove(pas);
				break;
			}
		}
		return "redirect:/paseo/listado";
	}
}*/
