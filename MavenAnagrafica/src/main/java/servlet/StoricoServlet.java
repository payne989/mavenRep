package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StoricoDao;
import model.Storico;
import utiliy.Util;

/**
 * Servlet implementation class ImpiegatoServlet
 */
@WebServlet("/StoricoServlet")
public class StoricoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StoricoServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			String stringDataInizio = request.getParameter("datainizio");
			String stringDataFine = request.getParameter("datafine");
			int idRuolo = Integer.parseInt(request.getParameter("idruolo"));
			int idImpiegato = Integer.parseInt(request.getParameter("idimpiegato"));

			java.sql.Date dataInizio = Util.stringToDate(stringDataInizio);
			java.sql.Date dataFine = Util.stringToDate(stringDataFine);

			Storico stor = new Storico(0, dataInizio, dataFine, idRuolo, idImpiegato);

			try {
				StoricoDao.insert(stor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (funzione.equals("cerca")) {

			int id = Integer.parseInt(request.getParameter("id"));
			StoricoDao.researchByIdImp(id);
		}

		else if (funzione.equals("cancella")) {

			int id = Integer.parseInt(request.getParameter("id"));
			try {
				StoricoDao.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (funzione.equals("aggiorna"))

		{

			try {
				int id = Integer.parseInt(request.getParameter("id"));
				String stringDataInizio = request.getParameter("datainizio");
				String stringDataFine = request.getParameter("datafine");
				int idRuolo = Integer.parseInt(request.getParameter("idruolo"));
				int idImpiegato = Integer.parseInt(request.getParameter("idimpiegato"));

				java.sql.Date dataInizio = Util.stringToDate(stringDataInizio);
				java.sql.Date dataFine = Util.stringToDate(stringDataFine);

				StoricoDao.update(id, dataInizio, dataFine, idRuolo, idImpiegato);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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