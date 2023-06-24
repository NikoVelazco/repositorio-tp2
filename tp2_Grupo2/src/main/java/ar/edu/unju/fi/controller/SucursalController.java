package ar.edu.unju.fi.controller;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.service.IProvinciaService;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

/**
 * Capa controladora para la pagina sucursal
 * @author Grupo 2
 *
 */


@Controller
@RequestMapping("/sucursal")
public class SucursalController{
	@Autowired
	@Qualifier("sucursalServiceMysql")
	private ISucursalService sucursalService;
	
	/**
	 * Inyecta el servicio provinciaServiceMysql
	 */
	@Autowired
	@Qualifier("provinciaServiceMysql")
	private IProvinciaService provinciaService;
	
	/**
	 * Inyecta e instancia un objeto Provincia al contenedor
	 */
	@Autowired
	private Provincia unaProvincia;
	
	/**
	 * Peticion para dirigirse a la pagina sucursales
	 * @param model usado para agregar a la vista la lista de productos
	 * @return pagina sucursales
	 */
	@GetMapping("listado")
	public String getListaSucursalesPage(Model model) {
		model.addAttribute("sucursales", sucursalService.getListaSucursal());
		return "sucursales";
	}	
	
	/**
	 * Peticion para dirigirse a la pagina nueva_sucursal
	 * @param model vincula la variable sucursal de tipo Sucursal al formulario
	 * la variable edicion identifica la accion dentro de la pagina 
	 * si es false se va a ingresar una nueva sucursal
	 * si es trus se va a modificar una sucursal
	 * * @return pagina nuevo_producto
	 */
	@GetMapping("/nuevo")
	public String getNuevaSucursalPage(Model model) {
		boolean edicion=false;
		model.addAttribute("sucursal", sucursalService.getSucursal());
		model.addAttribute("provincias", provinciaService.getListaProvincia());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	/**
	 * Peticion para guardar el objeto sucursal dentro de la Base de datos
	 * @param sucursal es el objeto a guardar
	 * @param result activa las validaciones dentro del modelo
	 * @return pagina nueva_sucursal
	 */
	
	@PostMapping("/guardar")
	public ModelAndView getGuardarSucursalPage(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result) {
		unaProvincia = provinciaService.findProvinciaById(sucursal.getProvincia().getId());
		sucursal.setProvincia(unaProvincia);
		ModelAndView modelView = new ModelAndView("sucursales");
		if(result.hasErrors()) {
			modelView.setViewName("nueva_sucursal");
			modelView.addObject("sucursal", sucursal);
			modelView.addObject("provincias", provinciaService.getListaProvincia());
			return modelView;
		}
		sucursalService.guardar(sucursal);
		modelView.addObject("sucursales", sucursalService.getListaSucursal());
		return modelView;
	}
	
	/**
	 * Peticion para modificar una sucursal
	 * @param model usado para enviar el objeto encontrado a la pagina
	 * @param id contiene el id de la sucursal  a modificar
	 * @return pagina nueva sucursal
	 */
	
	@GetMapping("/modificar/{id}")
	public String getModificarSucursalPage(Model model, @PathVariable(value="id")Long id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id);
		boolean edicion=true;		
		model.addAttribute("sucursal", sucursalEncontrada);
		model.addAttribute("provincias", provinciaService.getListaProvincia());
		model.addAttribute("edicion", edicion);
		return "nueva_sucursal";
	}
	
	/**
	 * Peticion para guardar el objeto modificado. sucursal tiene los valores cambiados
	 * @param sucursal objeto que guarda los valores cargados en la pagina	 * 
	 * @return pagina nueva_sucursal si es que no se cumplen las validaciones 
	 * @return pagina sucursales/listado usando redirect 
	 */
	
	@PostMapping("/modificar")
	public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("edicion",true);
			model.addAttribute("provincias", provinciaService.getListaProvincia());
			return "nueva_sucursal";
		}
		unaProvincia = provinciaService.findProvinciaById(sucursal.getProvincia().getId());
		sucursal.setProvincia(unaProvincia);
		sucursalService.modificar(sucursal);
		return "redirect:/sucursal/listado";
	}
	
	/**
	 * Recibe id del objeto a eliminar
	 * @param id es el id del objeto a eliminar (la eliminacion es una eliminacion logica)
	 * @return pagina sucursales usando redirect  
	 */
	
	@GetMapping("/eliminar/{id}")
	public String eliminarSucursal(@PathVariable(value="id")Long id) {
		Sucursal sucursalEncontrada = sucursalService.getBy(id); 
		sucursalService.eliminar(sucursalEncontrada);
		return "redirect:/sucursal/listado";
	}
	
	/**
	 * Peticion para mostrar la lista de sucursales filtradas entre dos fechas
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param model
	 * @return sucursale filtradas 
	 */
	@PostMapping("/buscar")
	public String buscarSucursalesPorFechas(@RequestParam("fechaInicial") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaInicial,
	                                        @RequestParam("fechaFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaFinal,
	                                        Model model) {
	   
		model.addAttribute("fechaInicial", fechaInicial);
		model.addAttribute("fechaFinal", fechaFinal);
		model.addAttribute("sucursales", sucursalService.getListaSucursalFiltrada(fechaInicial, fechaFinal));
	    return "sucursales";
	}
}
