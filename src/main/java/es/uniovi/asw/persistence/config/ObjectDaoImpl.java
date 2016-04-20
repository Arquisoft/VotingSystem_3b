package es.uniovi.asw.persistence.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.electors.dbUpdate.WriteReport;
import es.uniovi.asw.model.Censos;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.Votos;

public class ObjectDaoImpl implements ObjectDao {


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
	public void insertVotacion(Votacion v, WriteReport r) {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement("INSERT INTO VOTACION(DIAINICIO, DIAFIN,"
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

			con = Jdbc.getConnection();
			ps = con.prepareStatement("DELETE FROM VOTACION WHERE ID = ?");
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

			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM VOTACION WHERE ID = ?");
			ps.setLong(1, id);

			rs = ps.executeQuery();
			while (rs.next()) {

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

			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM VOTACION");

			rs = ps.executeQuery();
			while (rs.next()) {

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
	public void insertOpcion(Opcion o) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO OPCION(ID, NOMBRE,"
											+ " IDVOTACION) VALUES (?, ?, ?)");

			ps.setLong(1, o.getId());
			ps.setString(2, o.getNombre());
			ps.setLong(3, o.getIdVotacion());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "La opción no se ha podido cargar correctamente en la base"
					+ " de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
		}


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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Opcion> opciones = new ArrayList<>();

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM OPCION");

			rs = ps.executeQuery();
			while (rs.next()) {
				
				Long id = rs.getLong(1);
				String nombre = rs.getString(2);
				Long idVotacion = rs.getLong(3);
				Opcion op = new Opcion(id, nombre, idVotacion);
				opciones.add(op);

			}

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return opciones;
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

	/*
	 * Metodos de ceci
	 */

	@Override
	public boolean insertVotante(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();

			PreparedStatement ps = c
					.prepareStatement("INSERT INTO VOTANTE (NIF, TIPOVOTO, ESTADO, IDVOTACION) VALUES ( ?, ?, ?, ?)");

			ps.setString(1, v.getNif());
			ps.setString(2, v.getTipovoto());
			ps.setBoolean(3, v.isEstado());
			ps.setLong(4, v.getIdVotacion());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return false;
		}

		return true;

	}

	@Override
	public boolean setTipoVoto(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("UPDATE VOTANTE SET TIPOVOTO=? WHERE NIF=?");

			ps.setString(1, v.getTipovoto());
			ps.setString(2, v.getNif());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return false;
		}

		return true;
	}

	@Override
	public boolean setEstadoVoto(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("UPDATE VOTANTE SET ESTADO=? WHERE NIF=?");

			ps.setBoolean(1, v.isEstado());
			ps.setString(2, v.getNif());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return false;
		}

		return true;
	}

	@Override
	public Votante findVotante(String NIF) {
		Connection c;
		String error = "";
		ResultSet rs;
		Votante vot = null;
		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("SELECT * FROM VOTANTE WHERE NIF=?");

			ps.setString(1, NIF);
			rs = ps.executeQuery();

			if (rs.next()) {
				vot = new Votante();
				vot.setNif(rs.getString(0));
				vot.setTipovoto(rs.getString(1));
				vot.setEstado(rs.getBoolean(2));
				vot.setIdVotacion(rs.getLong(3));
			}

			ps.close();
			c.close();
			rs.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return vot;
		}

		return vot;
	}

	@Override
	public Votos findVotos(Long id) {
		Connection c;
		String error = "";
		ResultSet rs;
		Votos vot = null;
		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("SELECT * FROM VOTOS WHERE ID=?");

			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				Long idC = rs.getLong(1);
				String tipoVoto = rs.getString(2);
				Long opcionEscogida = rs.getLong(3);
				int totalVotos = rs.getInt(4);
				Long idVotacion = rs.getLong(5);
				String colegioElectoral = rs.getString(6);
				
				vot = new Votos(idC, tipoVoto, opcionEscogida, totalVotos,
												  idVotacion, colegioElectoral);
			}

			ps.close();
			c.close();
			rs.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return vot;
		}

		return vot;
	}
	
	@Override
	public List<Votos> findAllVotos() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Votos> votos = new ArrayList<>();

		try {

			con = Jdbc.getConnection();
			ps = con.prepareStatement("SELECT * FROM VOTOS");

			rs = ps.executeQuery();
			while (rs.next()) {

				
				Long id = rs.getLong(1);
				String tipoVoto = rs.getString(2);
				Long opcionEscogida = rs.getLong(3);
				int totalVotos = rs.getInt(4);
				Long idVotacion = rs.getLong(5);
				String colegioElectoral = rs.getString(6);
				Votos v = new Votos(id, tipoVoto, opcionEscogida, totalVotos, idVotacion, colegioElectoral);
				
				votos.add(v);

			}

			ps.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return votos;
	}


	@Override
	public boolean updateVotos(Votos v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("UPDATE VOTOS SET TOTALVOTOL=? WHERE ID=?");

			ps.setInt(1, v.getTotalVotos());
			ps.setLong(2, v.getId());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return false;
		}

		return true;
	}
	
	@Override
	public boolean insertVotos(Votos v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c
					.prepareStatement("INSERT INTO VOTOS(TIPOVOTO, OPCIONESCOGIDA, TOTALVOTOS, IDVOTACION, COLEGIOELECTORAL) VALUES ( ?, ?, ?, ?, ?)");

			ps.setString(1, v.getTipoVoto());
			ps.setLong(2, v.getOpcionEscogida());
			ps.setInt(3, v.getTotalVotos());
			ps.setLong(4, v.getIdVotacion());
			ps.setString(5, v.getColegioElectoral());
			ps.execute();

			ps.close();
			c.close();

		} catch (SQLException e) {
			error = "El voto no se ha podido cargar correctamente en la base de datos.";
			System.out.println(error);
			e.printStackTrace();
			// reportR.setLog("ERROR: " + error);
			return false;
		}

		return true;

	}

	
}
