package ejb;


import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.EdizioneDao;
import dto.EdizioneDTO;
import ejbInterfaces.EdizioneejbLocal;
import ejbInterfaces.EdizioneejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Edizioneejb implements EdizioneejbRemote, EdizioneejbLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
    public Edizioneejb() {}

    public boolean insertEdizione(EdizioneDTO ed) {
    	
    	int idCorso = ed.getIdCorso();
    	int idDocente = ed.getIdDocente();
    	int idSede = ed.getIdSede();
    	Date dataIn = ed.getDataIn();
    	Date dataFin = ed.getDataFin();
    	
    	EdizioneDao edao = new EdizioneDao();
		
		edao.insertEdizione(idCorso, idDocente, idSede, dataIn, dataFin);
		
		return true;
    	
    }
    
    public boolean deleteEdizioneByID(int id) {
    	
    	EdizioneDao eddao = new EdizioneDao(em);
    	
    	eddao.deleteEdizioneByID(id);
    	
    	return true;
    	
    }
   
    public boolean updateEdizione(int id, int idSede, int idDocente, Date dataIn, Date dataFin) {
		
    	EdizioneDao eddao = new EdizioneDao(em);
    	
    	return eddao.updateEdizione(id, idSede, idDocente, dataIn, dataFin);
    	
    	
    	
    }

    public EdizioneDTO selectEdizioneById (int id) {
    	
    	EdizioneDao eddao =new EdizioneDao (em);
    	
    	return Converter.convertEdizioneJPA( eddao.selectEdizioneById(id));
    }

    public ArrayList<EdizioneDTO> selectAllEdizione() {
    	
    	EdizioneDao eddao =new EdizioneDao (em);
    	
    	return Converter.convertEdizioneJPAList(eddao.selectAllEdizione());
    }
}
