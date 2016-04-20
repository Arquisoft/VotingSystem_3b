package es.uniovi.asw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import es.uniovi.asw.model.Censos;
import es.uniovi.asw.model.TipoVoto;
import es.uniovi.asw.model.Votante;
import es.uniovi.asw.model.VotoForm;
import es.uniovi.asw.model.Votos;
import es.uniovi.asw.virtualVotes.dBUpdate.InsertVirtualVotesP;
import es.uniovi.asw.virtualVotes.virtualVotesConfig.InsertVirtual;
import es.uniovi.asw.virtualVotes.virtualVotesConfig.InsertVirtualR;

@Controller
@SessionAttributes("votacion")
public class VotosController {

	// private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@RequestMapping(value = "/guardarVoto", method = RequestMethod.POST)
	public String GetVoteInfo(VotoForm votacion, Model model) {

		if (votacion != null) {
			// OBTENER LOS DATOS DEL FORMULARIO
			Long idVotacion = new Long(1);

			// DATOS VOTANTE
			String NIF = votacion.getNif();
			String tipovoto = TipoVoto.WEB.toString();
			boolean estado = true;
			Votante votante = new Votante(NIF, tipovoto, estado, idVotacion);

			//Comprobamos que el usuario puede votar
			InsertVirtual ins = new InsertVirtualR(votante);
			Votante vot = ins.getTipoVoto(new InsertVirtualVotesP());

			if (vot != null && !vot.isEstado() && vot.getTipovoto().equals(TipoVoto.WEB.toString())) {
				// Obtenemos el censo del votante
				Censos censo = ins.getCenso(new InsertVirtualVotesP());

				// Datos de la votacion
				String tipoVoto = TipoVoto.WEB.toString();
				Long opcionEscogida = (long) (Double.parseDouble(votacion.getOpcion()));
				String colegioElectoral = String.valueOf(censo.getCofColegioElectoral());

				int totalVotos = 4;
				Votos votos = new Votos(tipoVoto, opcionEscogida, totalVotos, idVotacion, colegioElectoral);

				// Marcamos que el votante ya realizó su voto
				ins = new InsertVirtualR(votante, votos);
				ins.setTypeVote(new InsertVirtualVotesP());
				ins.setVote(new InsertVirtualVotesP());

				return "exitoGuardarVotacion"; // ?????
			}
		}
		return "/error";

	}

}
