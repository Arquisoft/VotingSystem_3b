package es.uniovi.asw.physicalVotes.physicalVotesConfig;

import java.util.ArrayList;
import java.util.Map;
import es.uniovi.asw.physicalVotes.dBUpdate.InsertVotesP;

/*
 * Verifica los datos a enviar a DBUpdate.
 */
public class InsertPhysicalR implements Insert {
	
	private ReadVotes reader;
	private String ruta;

	public InsertPhysicalR(ReadVotes readVotes, String ruta) {
		super();
		this.reader = readVotes;
		this.ruta = ruta ;
	}

	public ReadVotes getReader() {
		return reader;
	}

	public void setReader(ReadVotes reader) {
		this.reader = reader;
	}

	@Override
	public void addVoto(InsertVotesP database) {
		Map<Integer, ArrayList<String>> map = reader.leerFichero(ruta);
		//Votos votos;
		for(Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()){
			System.out.print(entry.getKey() + "\t");
			for(String voto: entry.getValue()){
				System.out.print(voto + "\t");
			}
			System.out.println();
		}
	}

}
