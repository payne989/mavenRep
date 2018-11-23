package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.DocenteDTO;
import ejbInterfaces.DocenteejbRemote;

@WebServlet("/DocenteServlet")
public class DocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/MavenCorsi-0.0.1-SNAPSHOT/Docenteejb!ejbInterfaces.DocenteejbRemote")
	private DocenteejbRemote docenteejb;

	public DocenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String cf = request.getParameter("cf");
			if (nome != null && cognome != null && cf != null)
				docenteejb.insertDocente(nome, cognome, cf);
		
		} else if (funzione.equals("modifica")) {

			DocenteDTO doc = new DocenteDTO();
			doc.setId(3);
			doc.setNome("Hibernate");
			doc.setCognome("angela");
			doc.setCf("hfhdhehf");
			docenteejb.updateDocente(doc);

		} else if (funzione.equals("cercaid")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			DocenteDTO doc = docenteejb.selectDocenteById(id);
			
			request.setAttribute("docente", doc);
			
		} else if (funzione.equals("cercaall")) {
			
			ArrayList<DocenteDTO> docList = docenteejb.selectAllDocente(); 
			
			request.setAttribute("docente", docList);
			
		} else if (funzione.equals("cercacf")) {
			
			String cf = request.getParameter("cf");
			
			DocenteDTO doc = docenteejb.selectDocenteByCf(cf);
			
			request.setAttribute("docente", doc);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
