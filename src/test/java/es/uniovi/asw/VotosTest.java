package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.Votos;
import es.uniovi.asw.persistence.config.ObjectDaoImpl;

public class VotosTest {

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
	public void test() {
		
		dao.insertVotos(new Votos("Virtual", new Long(1), 1, new Long(1), "12"));
		
		assertEquals(1, dao.findAllVotaciones().size());
		
	}

}
