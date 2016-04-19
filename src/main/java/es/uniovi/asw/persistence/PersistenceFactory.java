package es.uniovi.asw.persistence;

import es.uniovi.asw.persistence.impl.PhysicalVotesPersImpl;
import es.uniovi.asw.persistence.impl.VotantePersImpl;

public class PersistenceFactory {
	
	public static PhysicalVotesPers getPhysicalVotesPers(){
		return new PhysicalVotesPersImpl();
	}
	
	public static VotantePers getVotantePers(){
		return new VotantePersImpl();
	}

}
