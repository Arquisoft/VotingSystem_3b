package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votos;


public interface PhysicalVotesPers {

	public boolean insert(Votos v);
	
	public void delete();

}
