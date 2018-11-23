package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.SedeDTO;
import ejbInterfaces.SedeejbRemote;


@WebServlet("/SedeServlet")
public class SedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(mappedName = "java:jboss/exported/MavenCorsi-0.0.1-SNAPSHOT/Sedeejb!ejbInterfaces.SedeejbRemote")
	private SedeejbRemote sedeejb;
    
    public SedeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String funzione = request.getParameter("funzione");
		
		if (funzione.equals("inserisci")) {
			
			String nomeSede = request.getParameter("nomesede");
			String indirizzo = request.getParameter("indirizzo");
			String citta = request.getParameter("citta");
			
		if (nomeSede!= null && indirizzo!= null && citta!= null) sedeejb.insertSede(nomeSede, indirizzo, citta);
		}
		else if (funzione.equals("modifica")) {
			
			SedeDTO sed = new SedeDTO();
			sed.setId(Integer.parseInt(request.getParameter("id")));
			sed.setNomeSede(request.getParameter("nomesede"));
			sed.setIndirizzo(request.getParameter("indirizzo"));
			sed.setCitta(request.getParameter("citta"));
			sedeejb.updateSede(sed);
			
		}	else if (funzione.equals("cercaall")) {
			
			ArrayList<SedeDTO> sedList = sedeejb.selectAllSede();	
			
			request.setAttribute("sedeList", sedList);
			
		}  else if (funzione.equals("cercanome")) {
			
			String nome = request.getParameter("nome");
		
			ArrayList<SedeDTO> sedList = sedeejb.selectSedeByNome(nome);
			
			request.setAttribute("sedeList", sedList);
			
		} else if (funzione.equals("cercaid")) {
			
			int id = Integer.parseInt(request.getParameter("nome"));
			
			SedeDTO sed = sedeejb.selectSedeById(id);
			
			request.setAttribute("sede", sed);
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
