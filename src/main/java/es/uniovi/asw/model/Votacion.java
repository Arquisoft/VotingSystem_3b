package es.uniovi.asw.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
