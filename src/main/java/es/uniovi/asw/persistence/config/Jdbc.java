package es.uniovi.asw.persistence.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc {

	/*
	 * Configuration for Oracle private static String DRIVER =
	 * "oracle.jdbc.driver.OracleDriver"; private static String URL =
	 * "jdbc:oracle:thin:@156.35.94.99:1521:DESA"; private static String USER =
	 * ""; private static String PASS = "";
	 */
	/*
	 * Configuration for Hsqldb
	 */
	// private static String DRIVER = "org.hsqldb.jdbcDriver";
	// private static String URL = "jdbc:hsqldb:hsql://localhost";
	// private static String USER = "sa";
	// private static String PASS = "";

	/*
	 * Configuration for h2
	 */
	private static String BD = "h2";
	private static final String DRIVER = "org.h2.Driver";
	private static String URL = "jdbc:h2:~/test";
	private static String USER = "sa";
	private static String PASS = "";

	private static final String SCRIPT = "src/main/java/script.properties";
	private static Properties database;

	static {

		database = loadProperties(SCRIPT);

		try {
			Class.forName(DRIVER);
			if (BD.equals("h2")) {

				try {
					crearDB();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found in classpath", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public static void crearDB() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		// ejecutamos el script de creacion de la BD

		Class.forName(DRIVER).newInstance();
		Connection con = getConnection();
		java.sql.Statement stm = con.createStatement();

		stm.execute(database.getProperty("BORRAR_TABLA_VOTOS"));
		stm.execute(database.getProperty("BORRAR_TABLA_OPCION"));
		stm.execute(database.getProperty("BORRAR_TABLA_VOTANTE"));
		stm.execute(database.getProperty("BORRAR_TABLA_VOTACION"));
		stm.execute(database.getProperty("BORRAR_TABLA_CENSOS"));
		stm.execute(database.getProperty("BORRAR_TABLA_COLEGIOELECTORAL"));

		stm.execute(database.getProperty("CREAR_TABLA_COLEGIO"));
		stm.execute(database.getProperty("CREAR_TABLA_CENSOS"));
		stm.execute(database.getProperty("CREAR_TABLA_VOTACION"));
		stm.execute(database.getProperty("CREAR_TABLA_VOTANTE"));
		stm.execute(database.getProperty("CREAR_TABLA_OPCION"));
		stm.execute(database.getProperty("CREAR_TABLA_VOTOS"));
		// stm.execute("truncate table CENSOS");

		stm.close();
		con.close();

	}

	public static void close(ResultSet rs, Statement st, Connection c) {
		close(rs);
		close(st);
		close(c);
	}

	public static void close(ResultSet rs, Statement st) {
		close(rs);
		close(st);
	}

	protected static void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
		;
	}

	public static void close(Statement st) {
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
			}
		;
	}

	public static void close(Connection c) {
		if (c != null)
			try {
				c.close();
			} catch (SQLException e) {
			}
		;
	}

	public static Connection createThreadConnection() throws SQLException {
		Connection con = getConnection();
		con.setAutoCommit(false);
		threadConnection.set(con);
		return con;
	}

	private static ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

	public static Connection getCurrentConnection() {
		return threadConnection.get();
	}

	private static Properties loadProperties(String fileName) {

		Properties prop = new Properties();
		InputStream stream;

		try {

			stream = new FileInputStream(fileName);
			prop.load(stream);

		} catch (IOException e) {
		}

		return prop;

	}

}
