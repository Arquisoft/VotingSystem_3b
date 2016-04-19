package es.uniovi.asw.persistence;

import es.uniovi.asw.model.Votante;


public interface VotantePers {

	public boolean setTypeVote(Votante v);
	
	public boolean setEstado(Votante v);
	
	public Votante findVotanteByNIF(String NIF);
	
	public boolean insert(Votante v);
	
}
