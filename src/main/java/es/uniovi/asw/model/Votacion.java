package es.uniovi.asw.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Votacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Date diaInicio;
	private Date diaFin;
	private List<String> opcionesVotacion;
	private ColegioElectoral colegioElectoral;
	private List<String> tipoVotacion = 
									   Arrays.asList("Referendum", "Generales");
		    						   //Referendum en el proyecto piloto
	Calendar date = Calendar.getInstance();

	DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
	public Votacion() {
		try {
			diaInicio = dateFormat.parse("Sun Apr 17 18:52:54 CEST 2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Long getId() {
	
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDiaInicio() {
		return diaInicio;
	}
	public void setDiaInicio(Date diaInicio) {
		this.diaInicio = diaInicio;
	}
	
	public Date getDiaFin() {
		return diaFin;
	}
	public void setDiaFin(Date diaFin) {
		this.diaFin = diaFin;
	}
	
	public List<String> getOpcionesVotacion() {
		return opcionesVotacion;
	}
	public void setOpcionesVotacion(List<String> opcionesVotacion) {
		this.opcionesVotacion = opcionesVotacion;
	}
	public ColegioElectoral getColegioElectoral() {
		return colegioElectoral;
	}
	public void setColegioElectoral(ColegioElectoral colegioElectoral) {
		this.colegioElectoral = colegioElectoral;
	}
	public List<String> getTipoVotacion() {
		return tipoVotacion;
	}
	public void setTipoVotacion(List<String> tipoVotacion) {
		this.tipoVotacion = tipoVotacion;
	}
	
	

}
