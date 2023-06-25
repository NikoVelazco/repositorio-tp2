package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Empleado;
import java.util.List;

/**
 * @author Grupo2
 */
@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado,Long>{
	
	/*Obtiene la lista de Empleado*/
	public List<Empleado> findByEstado(boolean estado);
	
}
