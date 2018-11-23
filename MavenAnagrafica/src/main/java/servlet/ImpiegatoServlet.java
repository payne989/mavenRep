package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImpiegatoDao;
import model.Impiegato;

@WebServlet("/ImpiegatoServlet")
public class ImpiegatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImpiegatoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");
		System.out.println("funzione="+funzione);
		try {
			if (funzione.equals("inserisci")) {

				String cf = request.getParameter("codicefiscale");
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");

				Impiegato imp = new Impiegato(0, cf, nome, cognome);

				ImpiegatoDao.insert(imp);

				request.getRequestDispatcher("risultatoInserimentoImp.jsp").forward(request, response);

			}

			else if (funzione.equals("cercaid")) {

				int id = Integer.parseInt(request.getParameter("id"));
				Impiegato imp = ImpiegatoDao.researchById(id);

				request.setAttribute("impiegato", imp);

				request.getRequestDispatcher("risultatoCercaImpiegato.jsp").forward(request, response);

			} else if (funzione.equals("cercacf")) {

				String cf = (request.getParameter("codicefiscale"));
				Impiegato imp = ImpiegatoDao.researchByCf(cf);

				request.setAttribute("impiegato", imp);

				request.getRequestDispatcher("risultatoCercaImpiegato.jsp").forward(request, response);

			} else if (funzione.equals("cercanome")) {

				String nome = (request.getParameter("nome"));
				
				ArrayList<Impiegato> impList = ImpiegatoDao.researchByNome(nome);

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("risultatoCercaMultipla.jsp").forward(request, response);

			} else if (funzione.equals("cercacognome")) {

				String cognome = (request.getParameter("cognome"));
				ArrayList<Impiegato> impList = ImpiegatoDao.researchByCognome(cognome);

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("risultatoCercaMultipla.jsp").forward(request, response);

			}else if (funzione.equals("cercaall")) {
								
				ArrayList<Impiegato> impList = ImpiegatoDao.researchAll();

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("listaImpiegati.jsp").forward(request, response);
			}

			else if (funzione.equals("cancella")) {

				String id_str = request.getParameter("id");
				if (id_str != null) {
				
					try {
						int id = Integer.parseInt(id_str);
						ImpiegatoDao.delete(id);
						request.getRequestDispatcher("risultatoCancellazione.jsp").forward(request, response);

					} catch (NumberFormatException nfe) {
						System.err.println("Formato ID non corretto");
						nfe.printStackTrace();
					} catch (SQLException se) {
						System.err.println("Cancellazione fallita");
						se.printStackTrace();
					}
					

				}
			}

			else if (funzione.equals("aggiorna"))

			{

				try {

					Integer id = Integer.parseInt(request.getParameter("id"));
					String cf = request.getParameter("codfisc");
					String nome = request.getParameter("nome");
					String cognome = request.getParameter("cognome");
					ImpiegatoDao.update(id, cf, nome, cognome);

				} catch (Exception e) {

					e.printStackTrace();
				}
				request.getRequestDispatcher("risultatoModificaImp.jsp").forward(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
