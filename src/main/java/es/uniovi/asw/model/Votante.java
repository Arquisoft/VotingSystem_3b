package es.uniovi.asw.model;

public class Votante {
	private String nif;
	private String tipovoto;
	private boolean estado;
	private Long idVotacion;
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getTipovoto() {
		return tipovoto;
	}
	public void setTipovoto(String tipovoto) {
		this.tipovoto = tipovoto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public Long getIdVotacion() {
		return idVotacion;
	}
	public void setIdVotacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}
	
	
	
}
