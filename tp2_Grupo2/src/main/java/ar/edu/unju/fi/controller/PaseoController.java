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
import ar.edu.unju.fi.model.Paseo;
import jakarta.validation.Valid;
import ar.edu.unju.fi.listas.ListaPaseo;

@Controller
@RequestMapping("/paseo")
public class PaseoController {
	
	@Autowired
	private ListaPaseo listaPaseos;
	
	@Autowired
	private Paseo paseo, paseoEncontrado;
	
	@GetMapping("/listado")
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
	public String getGuardarPaseoPage(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result, Model model) {
		boolean edicion = false;
		model.addAttribute("edicion", edicion);
		if(result.hasErrors()) {
			model.addAttribute("paseo", paseo);
			return "nuevo_paseo";
		}
		listaPaseos.getPaseos().add(paseo);
        model.addAttribute("paseo", listaPaseos.getPaseos());
        return "redirect:/paseo/listado";
    }
	
	@GetMapping("/modificar/{legajo}")
	public String getModificarServicioPage(@PathVariable("legajo")String legajo, Model model) {
    	paseoEncontrado = new Paseo();
		boolean edicion = true;
    	model.addAttribute("edicion", edicion);
		for (Paseo pas: listaPaseos.getPaseos()) {
			if (pas.getLegajo().equals(legajo)) {
				paseoEncontrado = pas;
				break;
			}
		}
		model.addAttribute("paseo", paseoEncontrado);
		return "nuevo_paseo";
	}
	
	@PostMapping("/modificar")
	public String modificarPaseo(@Valid @ModelAttribute("paseo")Paseo paseo, BindingResult result, Model model) {
		paseo.setLegajo(paseoEncontrado.getLegajo());
		boolean edicion = true;
		if (result.hasErrors()) {
			paseo.setLegajo(paseoEncontrado.getLegajo());
			model.addAttribute("paseo", paseo);
			model.addAttribute("edicion", edicion);
			return "nuevo_paseo";
		} else {
			for (Paseo pas : listaPaseos.getPaseos()) {
				if (pas.getLegajo().equals(paseoEncontrado.getLegajo())) {
					pas.setNombre(paseo.getNombre());
					pas.setAnioExperiencia(paseo.getAnioExperiencia());
					pas.setTelefono(paseo.getTelefono());
					pas.setEmail(paseo.getEmail());
					pas.setHorario(paseo.getHorario());
					pas.setDescripcion(paseo.getDescripcion());
			        break;
				}
			}
			return "redirect:/paseo/listado";
		}
	}
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarPaseo(@PathVariable("legajo")String legajo) {
		for (Paseo pas : listaPaseos.getPaseos()) {
			if (pas.getLegajo().equals(legajo)) {
				listaPaseos.getPaseos().remove(pas);
				break;
			}
		}
		return "redirect:/paseo/listado";
	}
	
}
