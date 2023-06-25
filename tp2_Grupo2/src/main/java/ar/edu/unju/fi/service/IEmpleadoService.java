package ar.edu.unju.fi.service;

import ar.edu.unju.fi.entity.Empleado;
import java.util.List;

/**
 * @author Grupo2
 */
public interface IEmpleadoService {
	
	List<Empleado> getListaEmpleado(); /*metodo abstracto para obtener el listado de Empleados*/
	Empleado getEmpleado(); /*metodo abstracto para obtener un objeto tipo Empleado*/
	void guardarEmpleado(Empleado empleado); /*metodo abstracto para guardar un Empleado*/
	Empleado findEmpleadoById(Long id); /*metodo abstracto para buscar un Empleado por su id*/
	void cargarEmpleado(); /*metodo abstracto para cargar un Empleado*/

}
