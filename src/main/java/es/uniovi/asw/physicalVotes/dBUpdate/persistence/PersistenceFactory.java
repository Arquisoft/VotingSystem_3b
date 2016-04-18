package es.uniovi.asw.physicalVotes.dBUpdate.persistence;

public class PersistenceFactory {
	
	public static PhysicalVotesPers getPhysicalVotesPers(){
		return new PhysicalVotesPersImpl();
	}

}
