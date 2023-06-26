package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.repository.IProductoRepository;
import ar.edu.unju.fi.service.IProductoService;

@Service("productoServiceMysql")
public class ProductoServiceMysqlImp implements IProductoService {

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	Producto producto;
	
	@Override
	public List<Producto> getListaProducto() {
		
		return productoRepository.findByEstado(true);
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public Producto getBy(Long idProducto) {
		
		return productoRepository.findById(idProducto).get();
	}

	@Override
	public void modificar(Producto producto) {
		productoRepository.save(producto);

	}

	@Override
	public void eliminar(Producto productoEncontrado) {
		// eliminacion logica
		productoEncontrado.setEstado(false);
		productoRepository.save(producto);

	}

	@Override
	public Producto getProducto() {
		
		return producto;
	}
	@Override
	public List<Producto> getListaProductoPorCategoria(String categoria) {
		return productoRepository.findByEstado(true);
	}
}
