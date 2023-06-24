package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface ISucursalRepository extends CrudRepository <Sucursal,Long>{
	
	/*recupera lista sucursal de la base de datos*/
	public List<Sucursal> findByEstado(boolean estado);
	/*recupera listado filtrado entre dos fechas*/
	public List<Sucursal>findByFechaInicioBetween(LocalDate fechaInicial, LocalDate fechaFinal);
}
