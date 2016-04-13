package es.uniovi.asw.physicalVotes.dBUpdate;

import es.uniovi.asw.physicalVotes.reportWriter.WriteReport;
import es.uniovi.asw.physicalVotes.reportWriter.WreportP;

/*
 * Verifica los datos a escribir.
 */
public class WreportR implements WriteReport{
	
	
	WriteReport report;
	
	public WreportR(WreportP report) {
		this.report = report;
	}
	
}
