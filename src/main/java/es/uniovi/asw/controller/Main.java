package es.uniovi.asw.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.physicalVotes.dBUpdate.InsertVotesP;
import es.uniovi.asw.physicalVotes.dBUpdate.WreportR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.Insert;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.InsertPhysicalR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.RVotes;
import es.uniovi.asw.physicalVotes.reportWriter.WreportP;


@Controller
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	private Votacion v = new Votacion();
	// HACE FALTA INICIALIZAR LA VOTACION SACANDOLA DE LA BASE DE DATOS EN ALGUN MOMENTO PARA COMPROBAR LAS FECHAS Y DEMAS
	Date fechaActual = new Date();

	@RequestMapping("/")
	public ModelAndView landing(Model model) {
		LOG.info("Landing page access");
		return new ModelAndView("landing");

	}

	@RequestMapping("/user")
	public ModelAndView Usuarios() {
		try {
			// ESTO ES PARA PROBAR, EN REALIDAD SE SACARIA DE LA BASE DE DATOS
			v.setDiaInicio(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse("Sun Apr 17 20:12:22 CEST 2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOG.info("Pagina de usuario");
		
		if(fechaActual.compareTo(v.getDiaInicio()) < 0)
			return new ModelAndView("tipovotacion");
		else if(fechaActual.compareTo(v.getDiaInicio()) > 0)
			// comprobar que esta dentro del plazo y si la opcion escogida es voto online
			return new ModelAndView("formulario");
		//else if(fechaActutal > getDiaFin()) que no deje hacer nada
		
		return null; // devolver pagina de error cuando la tengamos

	}

	@RequestMapping("/admin")
	public ModelAndView Admin() {
		LOG.info("Pagina de admin");
		return new ModelAndView("config");

	}

	/*
	 * @RequestMapping("/physical") public ModelAndView cargarVotosFisicos()
	 * throws Exception {
	 * 
	 * WreportR report1 = new WreportR(new WreportP()); Insert r1 = new
	 * InsertPhysicalR(new RVotes(),
	 * "src/test/resources/votacionesFisicas.xlsx"); r1.addVoto(new
	 * InsertVotesP(report1));
	 * 
	 * 
	 * return new ModelAndView("physical"); }
	 */

	@RequestMapping(value = "/physical", method = RequestMethod.POST)
	public String cargarVotosFisicos() {
		WreportR report1 = new WreportR(new WreportP());
		Insert r1 = new InsertPhysicalR(new RVotes(), "src/test/resources/votacionesFisicas.xlsx");
		r1.addVoto(new InsertVotesP(report1));
		System.out.println("lalala");

		return "physical";
	}


}