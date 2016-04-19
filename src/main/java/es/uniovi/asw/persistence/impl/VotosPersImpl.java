package es.uniovi.asw.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.model.Votos;
import es.uniovi.asw.persistence.VotosPers;
import es.uniovi.asw.persistence.config.Jdbc;

public class VotosPersImpl implements VotosPers {

	@Override
	public Votos findVotosById(Long id) {
		Connection c;
		String error = "";
		ResultSet rs;
		Votos vot = null;
		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"SELECT * FROM VOTOS WHERE ID=?");

			ps.setLong(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				vot = new Votos();
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
	public boolean insert(Votos v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Votos v) {
		Connection c;
		String error = "";

		// if(reportR.validarVotante(v)){
		try {
			c = Jdbc.getConnection();
			PreparedStatement ps = c.prepareStatement(
					"UPDATE VOTOS SET TOTALVOTOL=? WHERE ID=?");

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

}
