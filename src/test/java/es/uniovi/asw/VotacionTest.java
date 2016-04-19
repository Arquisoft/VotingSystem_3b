package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.config.ObjectDaoImpl;

public class VotacionTest {
	
	ObjectDaoImpl dao = null;
	
	@Before
	public void run() {
		dao = new ObjectDaoImpl();
		
	}
	
	@After
	public void finalize() {
		dao.restoreDatabase();
	}

	@Test
	public void test() {
		
		Votacion v = new Votacion(new Date(), new Date(), "Referendum");
		
	
		
		dao.insertVotacion(v);
		assertEquals(1, dao.findAllVotaciones().size());
		assertEquals(v.getTipoVotacion(), dao.findVotacion(new Long(1)).getTipoVotacion());
	}
	
	

}
