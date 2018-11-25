package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ejbInterfaces.ImpiegatoejbRemote;
import dto.ImpiegatoDTO;

@WebServlet("/ImpiegatoServlet")
public class ImpiegatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/MavenAnagrafica-0.0.1-SNAPSHOT/Impiegatoejb!ejbInterfaces.ImpiegatoejbRemote")
	private ImpiegatoejbRemote impiegatoejb;

	public ImpiegatoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");

		try {
			if (funzione.equals("inserisci")) {

				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String cf = request.getParameter("codicefiscale");

				impiegatoejb.insertImpiegato(nome, cognome, cf);

				request.getRequestDispatcher("risultatoInserimentoImp.jsp").forward(request, response);

			}

			else if (funzione.equals("cercaid")) {

				int id = Integer.parseInt(request.getParameter("id"));
				ImpiegatoDTO imp = impiegatoejb.selectImpiegatoById(id);

				request.setAttribute("impiegato", imp);

				request.getRequestDispatcher("risultatoCercaImpiegato.jsp").forward(request, response);

			} else if (funzione.equals("cercacf")) {

				String cf = (request.getParameter("codicefiscale"));

				ImpiegatoDTO imp = impiegatoejb.selectImpiegatoByCf(cf);

				request.setAttribute("impiegato", imp);

				request.getRequestDispatcher("risultatoCercaImpiegato.jsp").forward(request, response);

			} else if (funzione.equals("cercanome")) {

				String nome = (request.getParameter("nome"));

				ArrayList<ImpiegatoDTO> impList = impiegatoejb.selectImpiegatoByNome(nome);

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("risultatoCercaMultipla.jsp").forward(request, response);

			} else if (funzione.equals("cercacognome")) {

				String cognome = (request.getParameter("cognome"));

				ArrayList<ImpiegatoDTO> impList = impiegatoejb.selectImpiegatoByCognome(cognome);

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("risultatoCercaMultipla.jsp").forward(request, response);

			} else if (funzione.equals("cercaall")) {

				ArrayList<ImpiegatoDTO> impList = impiegatoejb.selectAllImpiegato();

				request.setAttribute("impiegato", impList);

				request.getRequestDispatcher("listaImpiegati.jsp").forward(request, response);
			}

			else if (funzione.equals("cancella")) {

				String id_str = request.getParameter("id");
				if (id_str != null) {

					try {
						int id = Integer.parseInt(id_str);
						impiegatoejb.deleteImpByID(id);
						request.getRequestDispatcher("risultatoCancellazione.jsp").forward(request, response);

					} catch (NumberFormatException nfe) {
						System.err.println("Formato ID non corretto");
						nfe.printStackTrace();

					}

				}
			}

			else if (funzione.equals("aggiorna"))

			{

				try {

					Integer id = Integer.parseInt(request.getParameter("id"));
					String nome = request.getParameter("nome");
					String cognome = request.getParameter("cognome");
					String cf = request.getParameter("codfisc");

					ImpiegatoDTO imp = new ImpiegatoDTO(id, nome, cognome, cf);

					impiegatoejb.updateImpiegato(imp);

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
