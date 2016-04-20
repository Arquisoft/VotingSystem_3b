package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.persistence.config.ObjectDaoImpl;

public class OpcionTest {
	
	ObjectDaoImpl dao = null;

	@Before
	public void run() {
		dao = new ObjectDaoImpl();
		dao.restoreDatabase();
	}

	@After
	public void finalize() {
		dao.restoreDatabase();
	}

	@Test
	public void testDB() {
		dao.restoreDatabase();
		
		assertEquals(1, dao.findAllOpciones().size());
		dao.insertOpcion(new Opcion(new Long(2), "Opcion 2", new Long(1)));
		assertEquals(2, dao.findAllOpciones().size());
		
	}

}
