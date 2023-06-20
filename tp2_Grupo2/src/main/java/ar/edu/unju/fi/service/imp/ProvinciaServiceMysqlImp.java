package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;

import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;
import jakarta.annotation.PostConstruct;

@Service("provinciaServiceMysql")
public class ProvinciaServiceMysqlImp implements IProvinciaService{

	/**
	 * Inveccion e instaciado del objeto listaProvinicias al contenedor
	 */
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	/**
	 * Inveccion e instaciado del objeto provinicia al contenedor
	 */
	@Autowired
	private Provincia provincia;
	
	/**
	 * Metodo para obtener la lista de provicias
	 */
	@Override
	public List<Provincia> getListaProvincia() {
		
		return provinciaRepository.findByEstado(true);
	}

	/**
	 * Metodo para obtener una provincia
	 */
	@Override
	public Provincia getProvincia() {
		
		return provincia;
	}

	/**
	 * Metodo para guardar una provincia
	 */
	@Override
	public void guardarProvincia(Provincia provincia) {
		provincia.setEstado(true);
		provinciaRepository.save(provincia);
		
	}

	/**
	 * Metodo para encontrar una provincia por si id
	 */
	@Override
	public Provincia findProvinciaById(Long id) {
		return provinciaRepository.findById(id).get();
	}

	/**
	 * Metodo para cargar un listado de provincias 
	 */
	@PostConstruct
	@Override
	public void cargarProvincia() {
		provincia = new Provincia(Long.parseLong("1"), "Jujuy", true);
		provinciaRepository.save(provincia);
		provincia = new Provincia(Long.parseLong("2"),"Salta",true);
		provinciaRepository.save(provincia);
		provincia = new Provincia(Long.parseLong("3"),"Misiones",true);
		provinciaRepository.save(provincia);
		provincia = new Provincia(Long.parseLong("4"),"Córdoba",true);
		provinciaRepository.save(provincia);
		provincia = new Provincia(Long.parseLong("5"),"Buenos Aires",true);
		provinciaRepository.save(provincia);
		provincia = new Provincia(Long.parseLong("6"),"Corrientes",true);
		provinciaRepository.save(provincia);
		
		
	}

}
