package es.uniovi.asw.virtualVotes.virtualVotesConfig;

import es.uniovi.asw.model.Votante;
import es.uniovi.asw.virtualVotes.dBUpdate.InsertVirtualVotesP;

/*
 * Verifica los datos a enviar a DBUpdate.
 */
public class InsertVirtualR implements InsertVirtual {

	private Votante votante;
	
	public InsertVirtualR(Votante votante) {
		this.votante=votante;
	}
	
	
	@Override
	public void setTypeVote(InsertVirtualVotesP database) {

		//buscar si existe
		Votante vot = database.findVotanteByNIF(votante.getNif());
		//si existe-> modifica
		if(vot != null){
			database.setTypeVote(votante);			
		}else{
			//si no, añadir
			database.insertar(votante);
		}
		
		
	}


	public Votante getVotante() {
		return votante;
	}
	public void setVotante(Votante votante) {
		this.votante = votante;
	}

}
