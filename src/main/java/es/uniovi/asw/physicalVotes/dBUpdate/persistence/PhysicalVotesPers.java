package es.uniovi.asw.physicalVotes.dBUpdate.persistence;

import es.uniovi.asw.model.Votos;


public interface PhysicalVotesPers {

	public void insert(Votos v);
	
	public void delete();

}
