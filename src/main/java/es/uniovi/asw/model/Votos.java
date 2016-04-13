package es.uniovi.asw.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Votos {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipoVoto;
	private Long opcionEscogida; //id
	private int totalVotos;
	private Long idVotacion; //id
	private Long colegioElectoral; //id

	
	public Votos() { }	
	

	public Votos(String tipoVoto, Long opcionEscogida, int totalVotos,
			Long idVotacion, Long colegioElectoral) {
		super();
		this.tipoVoto = tipoVoto;
		this.opcionEscogida = opcionEscogida;
		this.totalVotos = totalVotos;
		this.idVotacion = idVotacion;
		this.colegioElectoral = colegioElectoral;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoVoto() {
		return tipoVoto;
	}

	public void setTipoVoto(String tipoVoto) {
		this.tipoVoto = tipoVoto;
	}

	public Long getOpcionEscogida() {
		return opcionEscogida;
	}

	public void setOpcionEscogida(Long opcionEscogida) {
		this.opcionEscogida = opcionEscogida;
	}

	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}

	public Long getIdVotacion() {
		return idVotacion;
	}

	public void setIdVotacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}

	public Long getColegioElectoral() {
		return colegioElectoral;
	}

	public void setColegioElectoral(Long colegioElectoral) {
		this.colegioElectoral = colegioElectoral;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((colegioElectoral == null) ? 0 : colegioElectoral.hashCode());
		result = prime * result
				+ ((idVotacion == null) ? 0 : idVotacion.hashCode());
		result = prime * result
				+ ((opcionEscogida == null) ? 0 : opcionEscogida.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votos other = (Votos) obj;
		if (colegioElectoral == null) {
			if (other.colegioElectoral != null)
				return false;
		} else if (!colegioElectoral.equals(other.colegioElectoral))
			return false;
		if (idVotacion == null) {
			if (other.idVotacion != null)
				return false;
		} else if (!idVotacion.equals(other.idVotacion))
			return false;
		if (opcionEscogida == null) {
			if (other.opcionEscogida != null)
				return false;
		} else if (!opcionEscogida.equals(other.opcionEscogida))
			return false;
		return true;
	}
	

}
