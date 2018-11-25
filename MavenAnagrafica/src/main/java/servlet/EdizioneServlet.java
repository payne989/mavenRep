package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EdizioneDTO;

import ejbInterfaces.EdizioneejbRemote;
import utiliy.Util;

@WebServlet("/EdizioneServlet")
public class EdizioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/MavenCorsi-0.0.1-SNAPSHOT/Edizioneejb!ejbInterfaces.EdizioneejbRemote")
	private EdizioneejbRemote edizejb;

	public EdizioneServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			String idCorso_str = request.getParameter("idcorso");
			String idDocente_str = request.getParameter("iddocente");
			String idSede_str = request.getParameter("idsede");
			java.sql.Date dataIn = Util.stringToSQLDate(request.getParameter("datain"));
			java.sql.Date dataFin = Util.stringToSQLDate(request.getParameter("datafin"));

			if (idCorso_str != null && idDocente_str != null && idSede_str != null && dataIn != null
					&& dataFin != null) {
				try {
					int idCorso = Integer.parseInt(idCorso_str);
					int idDocente = Integer.parseInt(idDocente_str);
					int idSede = Integer.parseInt(idSede_str);

					EdizioneDTO ed = new EdizioneDTO();

					ed.setIdCorso(idCorso);
					ed.setIdDocente(idDocente);
					ed.setIdSede(idSede);
					ed.setDataIn(dataIn);
					ed.setDataFin(dataFin);

					edizejb.insertEdizione(ed);
				} catch (NumberFormatException e) {

				}
			}
		} else if (funzione.equals("modifica")) {

			String id_str = request.getParameter("id");
			String idDocente_str = request.getParameter("iddocente");
			String idSede_str = request.getParameter("idsede");
			java.sql.Date dataIn = Util.stringToSQLDate(request.getParameter("datain"));
			java.sql.Date dataFin = Util.stringToSQLDate(request.getParameter("datafin"));

			if (id_str != null && idDocente_str != null && idSede_str != null && dataIn != null && dataFin != null) {
				try {
					int id = Integer.parseInt(id_str);
					int idDocente = Integer.parseInt(idDocente_str);
					int idSede = Integer.parseInt(idSede_str);

					edizejb.updateEdizione(id, idSede, idDocente, dataIn, dataFin);

				} catch (NumberFormatException e) {

				}

			}
		} else if (funzione.equals("cercaall")) {
			
			ArrayList<EdizioneDTO> edList = edizejb.selectAllEdizione();
			
			request.setAttribute("edizione", edList);
			
		} else if (funzione.equals("cercaid")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			EdizioneDTO ed = edizejb.selectEdizioneById(id);
			
			request.setAttribute("edizione", ed);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
