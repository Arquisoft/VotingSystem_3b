package es.uniovi.asw.model;

import java.util.Date;


public class VotacionForm {
	
	private Date fechaInicio;
	private Date fechaFin;
	private String tipoVotacion;
	

	public VotacionForm() {	}
	
	public VotacionForm(Date fechaInicio, Date fechaFin, String tipoVot) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tipoVotacion = tipoVot;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getTipoVotacion() {
		return tipoVotacion;
	}

	public void setTipoVotacion(String tipoVotacion) {
		this.tipoVotacion = tipoVotacion;
	}

	
}
