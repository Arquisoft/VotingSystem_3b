package es.uniovi.asw.physicalVotes.dBUpdate.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import es.uniovi.asw.model.Votos;
import es.uniovi.asw.physicalVotes.dBUpdate.Jdbc;

public class PhysicalVotesPersImpl implements PhysicalVotesPers {

	@Override
	public void insert(Votos v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"INSERT INTO VOTOS (TIPOVOTO, OPCIONESCOGIDA, TOTALVOTOS, IDVOTACION, COLEGIOELECTORAL) VALUES ( ?, ?, ?, ?, ?)");

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
		}

		/*
		 * Connection c; String error = "";
		 * 
		 * // if(reportR.validarVotante(v)){ try { c = Jdbc.getConnection();
		 * PreparedStatement ps = c.prepareStatement("SELECT * FROM OPCION");
		 * 
		 * ResultSet rs = ps.executeQuery();
		 * 
		 * System.out.println("OPCIONESSS:"); while(rs.next()){
		 * System.out.println("OPCION: " + rs.getString(2)); }
		 * 
		 * 
		 * ps.close(); c.close();
		 * 
		 * } catch (SQLException e) { error =
		 * "El voto no se ha podido cargar correctamente en la base de datos.";
		 * System.out.println(error); // reportR.setLog("ERROR: " + error); }
		 */

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
