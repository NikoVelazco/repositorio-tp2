
package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.listas.ListaProducto;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	ListaProducto listaProductos = new ListaProducto();
	
	@GetMapping("/listado")
	public String getListadoProductosPage(Model model) {		
		model.addAttribute("productos",listaProductos.getProductos());		
		return "productos";
	}
	
	@GetMapping("/nuevo")
	public String getProductosAltaPage(Model model){
		boolean edicion = false;
		model.addAttribute("produ",new Producto()); /*se crea un objeto de tipo producto llamado produ (que este en el form de nuevo_producto)y ese nombre es usado en la pagina*/
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
			
	}
	@PostMapping("/guardar")
	public ModelAndView getGuardarProductoPage(@ModelAttribute("produ") Producto producto){
		ModelAndView modelView =new ModelAndView("productos"); 
		listaProductos.getProductos().add(producto); 
		modelView.addObject("productos",listaProductos.getProductos());
		return modelView;
	}
	
	@GetMapping ("/modificar/{nombre}")
	public String getModificarProductoPage(Model model, @PathVariable(value="nombre") String nombre) {
		Producto productoEncontrado = new Producto();
		boolean edicion = true;
		for(Producto produ : listaProductos.getProductos()) {
			if (produ.getNombre().equals(nombre)) {
				productoEncontrado = produ;
				break;
			}			
		}
		model.addAttribute("produ",productoEncontrado);
		model.addAttribute("edicion",edicion);
		return "nuevo_producto";
	}

	/**
	 * Peticion para guardar el objeto modificado. produ tiene los valores cambiados
	 * @param consejo objeto que guarda los valores de productoNuevo de la pagina
	 * 
	 * @return pagina consejossalud usando redirect para usar /consejos/listado 
	 */
	@PostMapping("/modificar")
	public String getModificarProducto(@ModelAttribute("produ") Producto producto){
		for(Producto produ : listaProductos.getProductos()) {
			if(produ.getNombre().equals(producto.getNombre())) {
				produ.setPrecio(producto.getPrecio());
				produ.setCodigo(producto.getCodigo());
				produ.setCategoria(producto.getCategoria());
				produ.setDescuento(producto.getDescuento());			
				
			}
		}
		return "redirect:/productos/listado";
	}
	
	/**
	 * Recibe codigo del objeto a eliminar
	 * @param codigo es codigo del objeto a eliminar
	 * @return pagina productos usando redirect para usar /productos/listado 
	 */
	@GetMapping("/eliminar/{nombre}")
	public String getEliminarProducto (@PathVariable(value="nombre") String nombre){
		for(Producto produ : listaProductos.getProductos()){
			if(produ.getNombre().equals(nombre)){
				listaProductos.getProductos().remove(produ);
				break;			
			}			
		}
		
		return "redirect:/productos/listado";		
	}
	
}



