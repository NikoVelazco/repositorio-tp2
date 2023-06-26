package ar.edu.unju.fi.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.repository.IConsejoRepository;
import ar.edu.unju.fi.service.IConsejoService;

@Service("ConsejoServiceMysqlImp")
public class ConsejoServiceMysqlImp implements IConsejoService{
	@Autowired
	public IConsejoRepository consejoRepository;
	
	@Autowired
	private Consejo consejo;
	
	@Override
	public List<Consejo> getListaConsejo() {
		// TODO Auto-generated method stub
		return consejoRepository.findByEstado(true);
	}
	
	@Override
	public void guardar(Consejo consejo) {
		// TODO Auto-generated method stub
		consejo.setEstado(true);
		consejoRepository.save(consejo);
	}
	
	@Override
	public Consejo getBy(Long id) {
		// TODO Auto-generated method stub
		return consejoRepository.findById(id).get();
	}
	
	@Override
	public void modificar(Consejo consejo, Long id) {
		consejo.setId(id);
		consejo.setEstado(true);
		consejoRepository.save(consejo);
	}
	
	@Override
	public void eliminar(Consejo consejoEncontrado) {
		// TODO Auto-generated method stub
		consejoEncontrado.setEstado(false);
		consejoRepository.save(consejoEncontrado);
	}

	@Override
	public Consejo getConsejo() {
		// TODO Auto-generated method stub
		return consejo;
	}
}