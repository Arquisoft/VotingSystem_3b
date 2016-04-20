package es.uniovi.asw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.uniovi.asw.model.TipoVoto;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.VotoForm;
import es.uniovi.asw.model.Votos;
import es.uniovi.asw.virtualVotes.dBUpdate.InsertVirtualVotesP;
import es.uniovi.asw.virtualVotes.virtualVotesConfig.InsertVirtualR;

@Controller
@SessionAttributes("votacion")
public class VotosController {

	// private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@RequestMapping(value = "/guardarVoto", method = RequestMethod.POST)
	public String GetVoteInfo(VotoForm votacion, Model model) {

		if (votacion != null) {
			// OBTENER LOS DATOS DEL FORMULARIO
			System.out.println("OPCION : " + votacion.getOpcion());
			
			
			
			

			// EJEMPLO-----------------------------
			String tipoVoto = TipoVoto.FISICO.toString();
			Long opcionEscogida = new Long(1);
			int totalVotos = 4;
			Long idVotacion = new Long(1);
			String colegioElectoral = "12";
			// ------------------------------------

			Votos votos = new Votos(tipoVoto, opcionEscogida, totalVotos, idVotacion, colegioElectoral);

			// OBTENER LOS DATOS DEL FORMULARIO
			// EJEMPLO-----------------------------
			String NIF = "456";
			String tipovoto = TipoVoto.WEB.toString();
			boolean estado = false;
			// ------------------------------------
			Votante votante = new Votante(NIF, tipovoto, estado, idVotacion);

			new InsertVirtualR(votante, votos).setTypeVote(new InsertVirtualVotesP());

			return "exitoGuardarVotacion"; // ?????
		} else {
			return "/error";
		}
	}

}
