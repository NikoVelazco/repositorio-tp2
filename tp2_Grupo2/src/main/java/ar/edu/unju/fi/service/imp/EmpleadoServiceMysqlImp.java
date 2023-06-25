package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;
import jakarta.annotation.PostConstruct;

@Service("EmpleadoServiceMysqlImp")
public class EmpleadoServiceMysqlImp implements IEmpleadoService{
	
	/**
	 * Inveccion e instaciado del objeto empleadoRepository al contenedor
	 */
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	/**
	 * Inveccion e instaciado del objeto Empleado al contenedor
	 */
	@Autowired
	private Empleado empleado;
	
	/**
	 * Metodo para obtener la lista de Empleados
	 */
	@Override
	public List<Empleado> getListaEmpleado() {
		
		return empleadoRepository.findByEstado(true);
	}

	/**
	 * Metodo para obtener un Empleado
	 */
	@Override
	public Empleado getEmpleado() {
		
		return empleado;
	}

	/**
	 * Metodo para guardar un Empleado
	 */
	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleado.setEstado(true);
		empleadoRepository.save(empleado);
		
	}

	/**
	 * Metodo para encontrar un Empleado por su id
	 */
	@Override
	public Empleado findEmpleadoById(Long id) {
		return empleadoRepository.findById(id).get();
	}

	/**
	 * Metodo para cargar un listado de Empleados
	 */
	@PostConstruct
	@Override
	public void cargarEmpleado() {
		empleado = new Empleado(Long.parseLong("1"), "Sara Denise Mercado", true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("2"),"Nicolás Velazco",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("3"),"Alicia Roberts",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("4"),"Nolei Mamaní",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("5"),"Cristian Ortega",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("6"),"Dibu Martinez",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("7"),"Rodrigo De Paul",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("8"),"Juan Roman Riquelme",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("9"),"Martin Palermo",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("10"),"Lionel Messi",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("11"),"Ángel Di María",true);
		empleadoRepository.save(empleado);
		empleado = new Empleado(Long.parseLong("12"),"Lionel Scaloni",true);
		empleadoRepository.save(empleado);
	}
	
}

