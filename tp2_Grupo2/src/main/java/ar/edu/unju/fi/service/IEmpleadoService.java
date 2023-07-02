package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Empleado;
import java.util.List;

/**
 * @author Grupo2
 */
public interface IEmpleadoService {
	
	List<Empleado> getListaEmpleado(); 
	Empleado getEmpleado(); 
	void guardarEmpleado(Empleado empleado); 
	Empleado findEmpleadoById(Long id); 
	void cargarEmpleado(); 

}
