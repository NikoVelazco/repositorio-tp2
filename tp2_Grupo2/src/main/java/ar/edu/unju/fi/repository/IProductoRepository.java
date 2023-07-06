package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto,Long> {

	/*recupera lista sucursal*/
	public List<Producto> findByEstado(boolean estado);

	/**public List<Producto> findByCategoriaAndEstado(String categoria, boolean estado);**/
	
	@Query("SELECT p FROM Producto p WHERE p.categoria = :categoria AND p.estado = :estado")
    List<Producto> findByCategoriaAndEstado(@Param("categoria") String categoria, @Param("estado") boolean estado);
}

