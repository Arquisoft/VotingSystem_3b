package es.uniovi.asw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.physicalVotes.dBUpdate.InsertVotesP;
import es.uniovi.asw.physicalVotes.dBUpdate.WreportR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.Insert;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.InsertPhysicalR;
import es.uniovi.asw.physicalVotes.physicalVotesConfig.RVotes;
import es.uniovi.asw.physicalVotes.reportWriter.WreportP;

@Controller
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@RequestMapping("/")
	public ModelAndView landing(Model model) {
		LOG.info("Landing page access");
		return new ModelAndView("landing");

	}

	@RequestMapping("/user")
	public ModelAndView Usuarios() {
		LOG.info("Pagina de usuario");
		return new ModelAndView("voter");

	}

	@RequestMapping("/admin")
	public ModelAndView Admin() {
		LOG.info("Pagina de admin");
		return new ModelAndView("config");

	}

	@RequestMapping("/physical")
	public ModelAndView cargarVotosFisicos() throws Exception {
		
		WreportR report1 = new WreportR(new WreportP());
		Insert r1 = new InsertPhysicalR(new RVotes(), "src/test/resources/votacionesFisicas.xlsx");
		r1.addVoto(new InsertVotesP(report1));

		
		return new ModelAndView("physical");
	}
	

}