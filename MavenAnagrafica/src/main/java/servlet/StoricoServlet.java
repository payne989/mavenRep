package servlet;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.StoricoDTO;
import ejbInterfaces.StoricoejbRemote;
import utiliy.Util;

/**
 * Servlet implementation class ImpiegatoServlet
 */
@WebServlet("/StoricoServlet")
public class StoricoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/MavenAnagrafica-0.0.1-SNAPSHOT/Storicoejb!ejbInterfaces.StoricoejbRemote")
	private StoricoejbRemote storicoejb;
	
	public StoricoServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			
			int idRuo = Integer.parseInt(request.getParameter("idruolo"));
			int idImp = Integer.parseInt(request.getParameter("idimpiegato"));
			String stringDataInizio = request.getParameter("datainizio");
			String stringDataFine = request.getParameter("datafine");
			
			java.util.Date dataIn = Util.stringToUtilDate(stringDataInizio);
			java.util.Date dataFin = Util.stringToUtilDate(stringDataFine);

			
			StoricoDTO stor = new StoricoDTO();
			stor.setIdImpiegato(idImp);
			stor.setIdRuolo(idRuo);
			stor.setDataInizio(dataIn);
			stor.setDataFine(dataFin);
			
			storicoejb.insertStorico(stor);

		}

		else if (funzione.equals("cerca")) {

			
		}

		else if (funzione.equals("cancella")) {

			int id = Integer.parseInt(request.getParameter("id"));
			
				storicoejb.deleteStoricoByID(id);
		}

		else if (funzione.equals("aggiorna"))

		{

			try {
				
				int id = Integer.parseInt(request.getParameter("id"));
				String stringDataIn = request.getParameter("datainizio");
				String stringDataFin= request.getParameter("datafine");
				int idRuo = Integer.parseInt(request.getParameter("idruolo"));
				int idImp = Integer.parseInt(request.getParameter("idimpiegato"));

				java.util.Date dataInizio = Util.stringToUtilDate(stringDataIn);
				java.util.Date dataFine = Util.stringToUtilDate(stringDataFin);

				storicoejb.updateStorico(id, idImp, idRuo, dataInizio, dataFine);
			
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} 

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}