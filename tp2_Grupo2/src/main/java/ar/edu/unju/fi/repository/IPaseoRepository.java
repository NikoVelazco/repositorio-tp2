package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.fi.entity.Paseo;
import java.util.List;

@Repository
public interface IPaseoRepository extends CrudRepository<Paseo,Long>{
	
	/*Obtiene lista paseo*/
	public List<Paseo> findByEstado(boolean estado);
	
	/*recupera listado filtrado por dia*/
	public List<Paseo>findByDiaSemana(String diaSemana);
}
