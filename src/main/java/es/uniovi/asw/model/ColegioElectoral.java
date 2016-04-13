package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLEGIOELECTORAL")
public class ColegioElectoral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// Se considera que una circunscripción es el distrito electoral (barrio de la ciudad)
	private String circunscripcion;
	private String ciudad;	
	private String comunidadAutonoma;
	private String codColegioElectoral;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCircunscripcion() {
		return circunscripcion;
	}

	public void setCircunscripcion(String circunscripcion) {
		this.circunscripcion = circunscripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	
	
	public String getCodColegioElectoral() {
		return codColegioElectoral;
	}

	public void setCodColegioElectoral(String codColegioElectoral) {
		this.codColegioElectoral = codColegioElectoral;
	}

	public ColegioElectoral(){	}

	public ColegioElectoral(Long id, String circunscripcion, String ciudad,
			String comunidadAutonoma, String codColegioElectoral) {
		super();
		this.id = id;
		this.circunscripcion = circunscripcion;
		this.ciudad = ciudad;
		this.comunidadAutonoma = comunidadAutonoma;
		this.codColegioElectoral = codColegioElectoral + comunidadAutonoma.subSequence(0, 2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((circunscripcion == null) ? 0 : circunscripcion.hashCode());
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime
				* result
				+ ((codColegioElectoral == null) ? 0 : codColegioElectoral
						.hashCode());
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
		ColegioElectoral other = (ColegioElectoral) obj;
		if (circunscripcion == null) {
			if (other.circunscripcion != null)
				return false;
		} else if (!circunscripcion.equals(other.circunscripcion))
			return false;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (codColegioElectoral == null) {
			if (other.codColegioElectoral != null)
				return false;
		} else if (!codColegioElectoral.equals(other.codColegioElectoral))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColegioElectoral [id=" + id + ", circunscripcion="
				+ circunscripcion + ", ciudad=" + ciudad
				+ ", comunidadAutonoma=" + comunidadAutonoma
				+ ", codColegioElectoral=" + codColegioElectoral + "]";
	}
	
	
	

	
	
		
	
}
