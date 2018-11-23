package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.FrequenzeDTO;
import ejbInterfaces.FrequenzeejbRemote;



@WebServlet("/FrequenzeServlet")
public class FrequenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(mappedName = "java:jboss/exported/MavenCorsi-0.0.1-SNAPSHOT/Frequenzeejb!ejbInterfaces.FrequenzeejbRemote")
	private FrequenzeejbRemote freqejb;
   
    public FrequenzeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			String idImp_str = request.getParameter("idimp");
			String idEdiz_str = request.getParameter("idedizione");
			

			if (idImp_str != null && idEdiz_str != null )
					 {
				try {
					int idImp = Integer.parseInt(idImp_str);
					int idEdiz = Integer.parseInt(idEdiz_str);
					
					FrequenzeDTO fr = new FrequenzeDTO();

					fr.setIdImp(idImp);
					fr.setIdEdiz(idEdiz);
					
					freqejb.insertFrequenze(fr);
				} catch (NumberFormatException e) {

				}
			}
		} else if (funzione.equals("cercaall")) {
			
			ArrayList<FrequenzeDTO> freqList =freqejb.selectAllFrequenze();
			
			request.setAttribute("frequenze", freqList);
			
		} else if (funzione.equals("cercaid")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			FrequenzeDTO freq = freqejb.selectFrequenzeById(id);
			
			request.setAttribute("frequenze", freq);
		}
		
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
