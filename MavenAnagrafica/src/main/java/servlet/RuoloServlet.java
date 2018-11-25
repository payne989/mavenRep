package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.RuoloDTO;
import ejbInterfaces.RuoloejbRemote;


@WebServlet("/RuoloServlet")
public class RuoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/MavenAnagrafica-0.0.1-SNAPSHOT/Ruoloejb!ejbInterfaces.RuoloejbRemote")
	private RuoloejbRemote ruoloejb;

	public RuoloServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");
		
		
		try {
			if (funzione.equals("inserisci")) {

				String nomeruolo = request.getParameter("nomeruolo");
				Double stipendio = Double.parseDouble(request.getParameter("stipendio"));

				ruoloejb.insertRuolo(nomeruolo, stipendio);

				request.getRequestDispatcher("risultatoInserimentoRuo.jsp").forward(request, response);
			}

			else if (funzione.equals("cercanome")) {

				String nomeRuolo = request.getParameter("nomeRuolo");

				ArrayList<RuoloDTO> ruo = ruoloejb.selectRuoloByNome(nomeRuolo);

				request.setAttribute("ruolo", ruo);

				request.getRequestDispatcher("risultatoRicercaRuo.jsp").forward(request, response);
			}

			else if (funzione.equals("cerca")) {

				int id = Integer.parseInt(request.getParameter("id"));

				RuoloDTO ruo = ruoloejb.selectRuoloById(id);

				request.setAttribute("ruolo", ruo);

				request.getRequestDispatcher("risultatoRicercaRuo.jsp").forward(request, response);
			}

			else if (funzione.equals("cancella")) {

				int id = Integer.parseInt(request.getParameter("id"));

				ruoloejb.deleteRuoloByID(id);

				request.getRequestDispatcher("risultatoCancellazioneRuo.jsp").forward(request, response);
			}

			else if (funzione.equals("aggiorna")) {

				int id = Integer.parseInt(request.getParameter("id"));
				String nomeRuolo = request.getParameter("nomeruolo");
				Double stipendio = Double.parseDouble(request.getParameter("stipendio"));

				RuoloDTO ruo = new RuoloDTO(id, nomeRuolo, stipendio);

				ruoloejb.updateRuolo(ruo);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}