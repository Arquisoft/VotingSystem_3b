package es.uniovi.asw.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.electors.dbUpdate.ConfigP;
import es.uniovi.asw.electors.electorsConfig.ConfigR;
import es.uniovi.asw.model.TipoVotoForm;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.VotacionForm;
import es.uniovi.asw.model.VotoForm;
import es.uniovi.asw.physicalVotes.dBUpdate.InsertVotesP;
import es.uniovi.asw.physicalVotes.dBUpdate.WreportR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.Insert;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.InsertPhysicalR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.RVotes;
import es.uniovi.asw.physicalVotes.reportWriter.WreportP;

@Controller
@SessionAttributes("vot")
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);
	private Votacion v = new Votacion();
	// HACE FALTA INICIALIZAR LA VOTACION SACANDOLA DE LA BASE DE DATOS EN ALGUN
	// MOMENTO PARA COMPROBAR LAS FECHAS Y DEMAS
	Date fechaActual = new Date();

	@RequestMapping("/")
	public ModelAndView landing(Model model) {
		VotacionForm n = new VotacionForm();
		model.addAttribute("vot", n);
		
		TipoVotoForm m = new TipoVotoForm();
		model.addAttribute("voto", m);
		
		
		LOG.info("Landing page access");
		return new ModelAndView("landing");

	}

	@RequestMapping("/user")
	public ModelAndView Usuarios(Model model) {
		try {
			// ESTO ES PARA PROBAR, EN REALIDAD SE SACARIA DE LA BASE DE DATOS
			v.setDiaInicio(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",
					Locale.US).parse("Sun Apr 17 20:12:22 CEST 2016"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOG.info("Pagina de usuario");
		
		/*TipoVotoForm tipo = new TipoVotoForm();
		model.addAttribute("voto", tipo);
		
		return new ModelAndView("tipovotacion");*/
		
		VotoForm votoform = new VotoForm();
		model.addAttribute("votacion", votoform);
		
		return new ModelAndView("formulario");
		
		/*
		 * if (fechaActual.compareTo(v.getDiaInicio()) < 0) return new
		 * ModelAndView("tipovotacion"); else if
		 * (fechaActual.compareTo(v.getDiaInicio()) > 0) // comprobar que esta
		 * dentro del plazo y si la opcion escogida es // voto online return new
		 * ModelAndView("formulario"); // else if(fechaActutal > getDiaFin())
		 * que no deje hacer nada
		 * 
		 * return null; // devolver pagina de error cuando la tengamos
		 */

	}

	@RequestMapping("/admin")
	public ModelAndView Admin() {
		LOG.info("Pagina de admin");
		return new ModelAndView("config");

	}

	@RequestMapping("/physical")
	public ModelAndView cargarVotosFisicos() {
		WreportR report1 = new WreportR(new WreportP());
		Insert r1 = new InsertPhysicalR(new RVotes(),
				"src/test/resources/votacionesFisicas.xlsx");
		boolean exito = r1.addVoto(new InsertVotesP(report1));

		if (exito)
			return new ModelAndView("physical")
					.addObject("resultado",
							"Se han almacenado todos los datos con éxito en la base de datos.");
		else
			return new ModelAndView("physical").addObject("resultado",
					"No se han podido almacenar todos los datos.");

	}

	@RequestMapping(value = "/guardarVotacion")
	public String configVoto(VotacionForm vot, Model model) {
		LOG.info("Add vote page access");
		return "/guardarVotacion";
	}

	@RequestMapping(value = "/guardarVotacion", method = RequestMethod.POST)
	public String guardarConfigVot(VotacionForm vot, Model model) {

		if (vot != null) {
			
			if (vot.getFechaInicio() == null 
					|| vot.getFechaInicio().isEmpty()
					|| vot.getFechaFin() == null
					|| vot.getFechaFin().isEmpty()
					|| vot.getTipoVotacion() == null 
					|| vot.getTipoVotacion().isEmpty()){

				return "/error";

			}else{	
			
				VotacionForm votacion = new VotacionForm(vot.getFechaInicio(),
						vot.getFechaFin(), vot.getTipoVotacion());

				new ConfigR(votacion)
						.addVotacion(new ConfigP(
								new es.uniovi.asw.electors.dbUpdate.WreportR(
						  new es.uniovi.asw.electors.reportWriter.WreportP())));

				return "/exitoGuardarVotacion";
			}
		} else {
			return "/error";
		}

	}

}