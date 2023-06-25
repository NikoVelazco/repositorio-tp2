package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Paseo;
import ar.edu.unju.fi.repository.IPaseoRepository;
import ar.edu.unju.fi.service.IPaseoService;

@Service("PaseoServiceMysql")
public class PaseoServiceMysqlImp implements IPaseoService {
	
	@Autowired
	public IPaseoRepository paseoRepository;
	
	@Autowired
	private Paseo paseo;

	@Override
	public List<Paseo> getListaPaseo() {
		// TODO Auto-generated method stub
		return paseoRepository.findByEstado(true);
	}

	@Override
	public void guardar(Paseo paseo) {
		// TODO Auto-generated method stub
		paseo.setEstado(true);
		paseoRepository.save(paseo);
	}

	@Override
	public Paseo getBy(Long id) {
		// TODO Auto-generated method stub
		return paseoRepository.findById(id).get();
	}

	@Override
	public void modificar(Paseo paseo, Long id) {
		paseo.setId(id);
		paseo.setEstado(true);
		paseoRepository.save(paseo);
	}

	@Override
	public void eliminar(Paseo paseoEncontrado) {
		// TODO Auto-generated method stub
		paseoEncontrado.setEstado(false);
		paseoRepository.save(paseoEncontrado);
	}

	@Override
	public Paseo getPaseo() {
		// TODO Auto-generated method stub
		return paseo;
	}
	
	@Override
	public List<Paseo> getListaPaseoFiltrada(String diaSemana) {
		return paseoRepository.findByDiaSemana(diaSemana);
	}

}
