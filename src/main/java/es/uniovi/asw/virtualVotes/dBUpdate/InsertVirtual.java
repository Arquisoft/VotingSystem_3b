package es.uniovi.asw.virtualVotes.dBUpdate;

import es.uniovi.asw.model.Votante;

/*
 * Recibe la información para modificar en la base de
 *datos.
 */
public interface InsertVirtual {

	public boolean insertar(Votante v);

	public Votante findVotanteByNIF(String NIF);

	public boolean setTypeVote(Votante v);

	public boolean setEstado(Votante v);

}
