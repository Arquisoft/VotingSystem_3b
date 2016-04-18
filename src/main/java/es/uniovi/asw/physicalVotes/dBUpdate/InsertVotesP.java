package es.uniovi.asw.physicalVotes.dBUpdate;

import es.uniovi.asw.model.Votos;
import es.uniovi.asw.physicalVotes.dBUpdate.persistence.PersistenceFactory;


/*
 * Verifica los datos de entrada y si falta algún atributo
 * obligatorio genera el correspondiente error.
 */
public class InsertVotesP implements Insert {
	
	WreportR reportR;

	public InsertVotesP(WreportR reportR) {
		super();
		this.reportR = reportR;
	}
	
	/**
	 * Método que inserta un nuevo votante en la base de datos
	 * Si se produce un error se enviará a ReportWriter
	 * para que sea almacenado en el fichero de LOG
	 */
	@Override
	public void insertar(Votos v) {
		//if(reportR.validarVotante(v)){
			PersistenceFactory.getPhysicalVotesPers().insert(v);
		//}
	}
	
}
