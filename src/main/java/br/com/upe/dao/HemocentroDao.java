package br.com.upe.dao;

import java.util.List;

import br.com.upe.model.Hemocentro;

public interface HemocentroDao {

	Hemocentro findById(int id);

	void saveHemocentro(Hemocentro Hemocentro);
	
	void deleteHemocentroById(int id);
	
	List<Hemocentro> findAllHemocentros();

	Hemocentro findHemocentroById(int id);
	
	Hemocentro findHemocentroByNome(String nome);

}
