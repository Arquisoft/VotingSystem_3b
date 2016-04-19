package es.uniovi.asw.virtualVotes.dBUpdate;

import es.uniovi.asw.model.Votante;
import es.uniovi.asw.persistence.PersistenceFactory;

/*
 * Verifica los datos de entrada y si falta algún atributo
 * obligatorio genera el correspondiente error.
 */
public class InsertVirtualVotesP implements InsertVirtual{

	@Override
	public boolean insertar(Votante v) {
		return PersistenceFactory.getVotantePers().insert(v);
	}

	@Override
	public Votante findVotanteByNIF(String NIF) {
		return PersistenceFactory.getVotantePers().findVotanteByNIF(NIF);
	}

	@Override
	public boolean setTypeVote(Votante v) {
		return PersistenceFactory.getVotantePers().setTypeVote(v);
	}

	@Override
	public boolean setEstado(Votante v) {
		return PersistenceFactory.getVotantePers().setEstado(v);
	}

}
