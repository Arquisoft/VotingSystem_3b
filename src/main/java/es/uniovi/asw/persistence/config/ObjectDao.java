package es.uniovi.asw.persistence.config;

import java.util.List;

import es.uniovi.asw.model.Censos;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Votos;

public interface ObjectDao {

	// ColegioElectoral
	public void insertColegio(ColegioElectoral v);
	public void deleteColegio(String codigo);
	public Votante findColegio(String codigo);
	public List<ColegioElectoral> findAllColegios();

	// Censos
	public void insertCensos(Censos c);
	public void deleteCensos(int id);
	public Votante findCensos(int id);
	public List<Censos> findAllCensos();
	
	// Votacion
	public void insertVotacion(Votacion v);
	public void deleteVotacion(Long id);
	public Votacion findVotacion(Long id);
	public List<Votacion> findAllVotaciones();
	

	// Votante
	public void insert(Votante v);
	public void delete();
	public Votante findVotante(String NIF);
	public List<Votante> findAllVotantes();

	// Opcion
	public void insertOpcion(Opcion o);
	public void deleteOpcion();
	public Votante findOpcion(Long opcion);
	public List<Opcion> findAllOpciones();
	
	//Votos
	public void insertVotos(Votos v);
	public void deleteVotos(Long opcionEscogida, Long idVotacion,
			String colegioEletoral, String tipoVoto);
	public Votante findVotos(Long opcion);
	public List<Votos> findAllVotos();

	
	public void restoreDatabase();
	
	


}
