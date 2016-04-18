package es.uniovi.asw.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.model.Censos;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Votos;

public class ObjectDaoImpl implements ObjectDao{

	@Override
	public void insertColegio(ColegioElectoral v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteColegio(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante findColegio(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColegioElectoral> findAllColegios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCensos(Censos c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCensos(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante findCensos(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Censos> findAllCensos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertVotacion(Votacion v) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement("INSERT INTO VOTACION(DIAINICIO, DIAFIN,"
					+ " TIPOVOTACION) VALUES(?, ?, ?)");
			ps.setDate(1, new java.sql.Date(v.getDiaInicio().getTime()));
			ps.setDate(2, new java.sql.Date(v.getDiaFin().getTime()));
			ps.setString(3, v.getTipoVotacion());
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteVotacion(Long id) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement("DELETE FROM VOTACION WHERE ID = ?");
			ps.setLong(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Votacion findVotacion(Long id) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Votacion vot = null;
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement("SELECT * FROM VOTACION WHERE ID = ?");
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			while(rs.next()){
				
				Date diaInicio = new Date(rs.getDate(2).getTime());
				Date diaFinal = new Date(rs.getDate(3).getTime());
				String tipoVotacion = rs.getString(4);
				
				vot = new Votacion(id, diaInicio, diaFinal, tipoVotacion);
							
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vot;
	}

	@Override
	public List<Votacion> findAllVotaciones() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Votacion vot = null;
		ArrayList<Votacion> votaciones = new ArrayList<>();
		
		try {
			
			con=Jdbc.getConnection();
			ps=con.prepareStatement("SELECT * FROM VOTACION");
			
			rs = ps.executeQuery();
			while(rs.next()){
				
				Long id = rs.getLong(1);
				Date diaInicio = new Date(rs.getDate(2).getTime());
				Date diaFinal = new Date(rs.getDate(3).getTime());
				String tipoVotacion = rs.getString(4);
				
				vot = new Votacion(id, diaInicio, diaFinal, tipoVotacion);
				votaciones.add(vot);		
				
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return votaciones;
	}

	@Override
	public void insert(Votante v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante findVotante(String NIF) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Votante> findAllVotantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOpcion(Opcion o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOpcion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante findOpcion(Long opcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opcion> findAllOpciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertVotos(Votos v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteVotos(Long opcionEscogida, Long idVotacion,
			String colegioEletoral, String tipoVoto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Votante findVotos(Long opcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Votos> findAllVotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restoreDatabase() {
		try {
			Jdbc.crearDB();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
