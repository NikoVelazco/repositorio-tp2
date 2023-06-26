package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;


@Service("ConsejoServiceMysql")
public class ConsejoServiceMysqlImp implements IConsejoService{

	/*Objeto de la interfaz IConsejoRepository*/
	@Autowired
	private IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getListaConsejo() {
		return consejoRepository.findByEstadoConsejo(true);
	}

	@Override
	public void guardar(Consejo consejo) {
		consejoRepository.save(consejo);
		
	}

	@Override
	public Consejo getBy(Long codigo) {
		return consejoRepository.findById(codigo).get();
	}

	@Override
	public void modificar(Consejo consejo) {
		consejoRepository.save(consejo);
		
	}

	@Override
	public void eliminar(Consejo consejoEncontrado) {
		// eliminacion logica
		consejoEncontrado.setEstadoConsejo(false);
		consejoRepository.save(consejoEncontrado);
		
	}

	@Override
	public Consejo getConsejo() {
		return consejo;
	}

	
}
