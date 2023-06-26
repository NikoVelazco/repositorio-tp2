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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Categoria;
import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.ICategoriaService;
import ar.edu.unju.fi.service.IProductoService;

import jakarta.validation.Valid;


/**
 * 
 * @author Grupo 2 
 * capa cpntroladora para la pagina producto
 * 
 */


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	/**
	 * Inyecta e intancia el objeto productoService de tipo IProductoService al contenedor
	* IProductoService es la interfaz
	 */
	@Autowired
	@Qualifier("productoServiceMysql")
	private IProductoService productoService;
	
	
	/**
	 * Inyecta el servicio categoriaServiceMysql
	 */
	@Autowired
	@Qualifier("categoriaServiceMysql")
	private ICategoriaService categoriaService;
	
	/**
	 * Inyecta e instancia un objeto Categoria al contenedor
	 */
	@Autowired
	private Categoria unaCategoria;
	
	
	
	@GetMapping("/listado")
	public String getListadoProductosPage(Model model) {		
		model.addAttribute("productos",productoService.getListaProducto());		
		return "productos";
	}
	
	/**
	 * Peticion para dirigirse a la pagina nuevo_producto
	 * @param model vincula la variable produ de tipo Producto al formulario
	 * la variable edicion identifica la accion dentro de la pagina nuveo_producto
	 * si es false se va a ingresar un nuevo producto
	 * si es trus se va a modificar un producto
	 * * @return pagina nuevo_producto
	 */
	@GetMapping("/nuevo")
	public String getProductosAltaPage(Model model){
		boolean edicion = false;
		model.addAttribute("produ",productoService.getProducto()); /*se crea un objeto de tipo producto llamado produ (que este en el form de nuevo_producto)y ese nombre es usado en la pagina*/
		model.addAttribute("categoria", categoriaService.getListaCategoria());
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
		}
	
	/**
	 * Peticion para guardar el objeto produ dentro de la lista productos
	 * @param producto es el objeto a guardar
	 * @param result activa las validaciones dentro del modelo
	 * @return pagina nuevo_producto
	 */
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("produ") Producto producto, BindingResult result ){ 
		unaCategoria = categoriaService.findByCategoriaId(producto.getCategoria().getId());
		producto.setCategoria(unaCategoria);
		ModelAndView modelView =new ModelAndView("produ"); 
		if(result.hasErrors()) { /*verificacion de errores*/
			modelView.setViewName("nuevo_producto");
			modelView.addObject("produ", producto);
			modelView.addObject("categoria", categoriaService.getListaCategoria());
			return modelView;
		}
		productoService.guardar(producto); 
		modelView.addObject("productos",productoService.getListaProducto());
		return modelView;
	}

	/**
 * Peticion para modificar un producto
 * @param model usado para enviar el objeto encontrado a la pagina
 * @param codigo contiene codigo del producto a modificar
 * @return pagina nuevo producto 
 */
	
	@GetMapping ("/modificar/{idProducto}")
	public String getModificarProductoPage(Model model, @PathVariable(value="idProducto") Long idProducto) {
		Producto productoEncontrado = productoService.getBy(idProducto);
		boolean edicion = true;
		model.addAttribute("produ",productoEncontrado);
		model.addAttribute("categoria", categoriaService.getListaCategoria());
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}

	/**
	 * Peticion para guardar el objeto modificado. produ tiene los valores cambiados
	 * @param consejo objeto que guarda los valores de productoNuevo de la pagina
	 * 
	 * @return pagina nuevo_producto usando redirect para ir a /productos/listado 
	 */
	@PostMapping("/modificar")
	public String getModificarProducto(@Valid @ModelAttribute("produ") Producto producto, BindingResult result, Model model){
		if(result.hasErrors()) {
			model.addAttribute("edicion", true);
			model.addAttribute("categoria", categoriaService.getListaCategoria());
		return "nuevo_producto";
		}
		unaCategoria = categoriaService.findByCategoriaId(producto.getCategoria().getId());
		producto.setCategoria(unaCategoria);
		productoService.modificar(producto);
		return "redirect:/productos/listado";
	}
	
	/**
	 * Recibe codigo del objeto a eliminar
	 * @param codigo es codigo del objeto a eliminar
	 * @return pagina productos usando redirect para usar /productos/listado 
	 */
	@GetMapping("/eliminar/{idProducto}")
	public String getEliminarProducto (@PathVariable(value="idProducto") Long idProducto){
		Producto productoEncontrado = productoService.getBy(idProducto);
		productoService.eliminar(productoEncontrado);
		return "redirect:/productos/listado";		
	}
	
	@PostMapping("/buscar")
	public String findByCategoria(@RequestParam("categoria") String categoria, Model model) {
		model.addAttribute("categoria", categoria);
		model.addAttribute("productos", productoService.getListaProductoPorCategoria(categoria));
	    return "productos";
	}
}



