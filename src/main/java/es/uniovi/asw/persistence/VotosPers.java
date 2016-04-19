package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votos;


public interface VotosPers {

	public Votos findVotosById(Long id);
	
	public boolean insert(Votos v);
	
	public boolean update(Votos v);
	
}
