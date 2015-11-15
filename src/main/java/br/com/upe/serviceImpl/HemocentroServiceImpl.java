package br.com.upe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.upe.dao.HemocentroDao;
import br.com.upe.model.Hemocentro;
import br.com.upe.service.HemocentroService;

@Service("hemocentroService")
@Transactional
public class HemocentroServiceImpl implements HemocentroService {

	@Autowired
	private HemocentroDao dao;
	
	public Hemocentro findById(int id) {
		return dao.findById(id);
	}

	public void saveHemocentro(Hemocentro hemocentro) {
		dao.saveHemocentro(hemocentro);
	}

	public void updateHemocentro(Hemocentro hemocentro) {
		Hemocentro entity = dao.findById(hemocentro.getId());
		if(entity!=null){
			entity.setId(hemocentro.getId());
			entity.setNome(hemocentro.getNome());
		}
	}

	public void deleteHemocentroById(int id) {
		dao.deleteHemocentroById(id);
	}
	
	public List<Hemocentro> findAllHemocentros() {
		return dao.findAllHemocentros();
	}

	public Hemocentro findHemocentroById(int id) {
		return dao.findHemocentroById(id);
	}
	
	public Hemocentro findHemocentroByNome(String nome) {
		return dao.findHemocentroByNome(nome);
	}

	public boolean isHemocentroNomeUnique(String nome) {
		Hemocentro hemocentro = findHemocentroByNome(nome);
		return ( hemocentro == null || (hemocentro.getNome() == nome));
	}

	public boolean isHemocentroIdUnique(Integer id) {
		Hemocentro hemocentro = findHemocentroById(id);
		return ( hemocentro == null || (hemocentro.getId() == id));
	}
}
