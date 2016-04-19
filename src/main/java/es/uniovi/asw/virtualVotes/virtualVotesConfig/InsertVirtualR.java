package es.uniovi.asw.virtualVotes.virtualVotesConfig;

import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Votos;
import es.uniovi.asw.virtualVotes.dBUpdate.InsertVirtualVotesP;

/*
 * Verifica los datos a enviar a DBUpdate.
 */
public class InsertVirtualR implements InsertVirtual {

	private Votante votante;
	private Votos votos;

	public InsertVirtualR(Votante votante) {
		this.votante = votante;
	}

	public InsertVirtualR(Votante votante, Votos votos) {
		this.votante = votante;
		this.setVotos(votos);
	}

	@Override
	public void setTypeVote(InsertVirtualVotesP database) {

		// buscar si existe
		Votante vot = database.findVotanteByNIF(votante.getNif());
		// si existe-> modifica
		if (vot != null) {
			database.setTypeVote(votante);
		} else {
			// si no, añadir
			database.insertar(votante);
		}
	}
	
	
	@Override
	public void getVoteInfo(InsertVirtualVotesP database) {
		
		//modificar votos
		database.insert(votos);
		
		//marcar al usuario como que ya votó
		database.setEstado(votante);
	}


	public Votante getVotante() {
		return votante;
	}

	public void setVotante(Votante votante) {
		this.votante = votante;
	}

	public Votos getVotos() {
		return votos;
	}

	public void setVotos(Votos votos) {
		this.votos = votos;
	}

	
}
