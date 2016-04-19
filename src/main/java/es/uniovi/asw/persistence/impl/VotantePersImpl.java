package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.model.Votante;
import es.uniovi.asw.persistence.VotantePers;
import es.uniovi.asw.persistence.config.Jdbc;

public class VotantePersImpl implements VotantePers {

	@Override
	public boolean insert(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			
			PreparedStatement ps = c.prepareStatement(
					"INSERT INTO VOTANTE (NIF, TIPOVOTO, ESTADO, IDVOTACION) VALUES ( ?, ?, ?, ?)");

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
	public boolean setTypeVote(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE VOTANTE SET TIPOVOTO=? WHERE NIF=?");

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
	public boolean setEstado(Votante v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE VOTANTE SET ESTADO=? WHERE NIF=?");

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
	public Votante findVotanteByNIF(String NIF) {
		Connection c;
		String error = "";
		ResultSet rs;
		Votante vot = null;
		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM VOTANTE WHERE NIF=?");

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

}
