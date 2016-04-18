package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.persistence.ObjectDaoImpl;

public class VotacionTest {

	@Test
	public void test() {
		
		Votacion v = new Votacion(new Date(), new Date(), "Referendum");
		ObjectDaoImpl dao = new ObjectDaoImpl();
	
		
		dao.insertVotacion(v);
		assertEquals(1, dao.findAllVotaciones().size());
		assertEquals(v.getTipoVotacion(), dao.findVotacion(new Long(1)).getTipoVotacion());
	}
	
	

}
