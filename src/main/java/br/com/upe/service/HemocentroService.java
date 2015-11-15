package br.com.upe.service;

import java.util.List;

import br.com.upe.model.Hemocentro;

public interface HemocentroService {

	Hemocentro findById(int id);
	
	void saveHemocentro(Hemocentro hemocentro);
	
	void updateHemocentro(Hemocentro hemocentro);
	
	void deleteHemocentroById(int id);

	List<Hemocentro> findAllHemocentros(); 
	
	Hemocentro findHemocentroById(int id);
	
	Hemocentro findHemocentroByNome(String nome);

	boolean isHemocentroNomeUnique(String nome);
	
}
