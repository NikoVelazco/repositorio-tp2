package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Categoria;

import ar.edu.unju.fi.repository.ICategoriaRepository;
import ar.edu.unju.fi.service.ICategoriaService;
import jakarta.annotation.PostConstruct;

@Service("categoriaServiceMysql")
public class CategoriaServiceMysqlImp implements ICategoriaService{

	/**
	 * Inveccion e instaciado del objeto listaCategoria al contenedor
	 */
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	
	@Autowired
	private Categoria categoria;
	
	/**
	 * Metodo para obtener la lista de categorias
	 */
	@Override
	public List<Categoria> getListaCategoria() {
		return categoriaRepository.findByEstado(true);
	}
	
	/**
	 * Metodo para obtener una categoria
	 */
	@Override
	public Categoria getCategoria() {
			return categoria;
	}
	
		
	/**
	 * Metodo para guardar una categoria
	 */
	@Override
	public void guardarCategoria(Categoria categoria) {
		categoria.setEstado(true);
		categoriaRepository.save(categoria);
	}

	/**
	 * Metodo para cargar un listado de categorias 
	 */
	@PostConstruct
	@Override
	public void cargarCategoria() {
		categoria = new Categoria(Long.parseLong("1"), "Alimento", true);
		categoriaRepository.save(categoria);
		categoria = new Categoria(Long.parseLong("2"),"Juguetes",true);
		categoriaRepository.save(categoria);
		categoria = new Categoria(Long.parseLong("3"),"Ropa",true);
		categoriaRepository.save(categoria);
		categoria = new Categoria(Long.parseLong("4"),"Otros",true);
		categoriaRepository.save(categoria);
		
		
		
	}
	/**
	 * Metodo para encontrar una categoria por su id
	 */
	@Override
	public Categoria findByCategoriaId(Long id) {
		return categoriaRepository.findById(id).get();
	}

}
