package ejb;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.StoricoDao;
import dto.StoricoDTO;
import ejbInterfaces.RuoloejbLocal;
import ejbInterfaces.RuoloejbRemote;

@Stateless
@LocalBean
public class Storicoejb implements RuoloejbRemote, RuoloejbLocal {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;
	
	public Storicoejb() {}
	
	 public boolean insertStorico(StoricoDTO sto) {
	    	
	    	int idImp = sto.getIdImpiegato();
	    	int idRuo = sto.getIdRuolo();
	    	Date dataIn = sto.getDataInizio();
	    	Date dataFin = sto.getDataFine();
	    	
	    	StoricoDao sdao = new StoricoDao(em);
			
			sdao.insertStorico(idImp, idRuo, dataIn, dataFin);
			
			return true;
	    	
	    }
	    
	 public boolean deleteEdizioneByID(int id) {
	    	
		 StoricoDao sdao = new StoricoDao(em);
	    	
	    sdao.deleteStorico(id);
	    	
	    	return true;
	    	
	    }

	 public boolean updateStorico(int id, int idImp, int idRuo, Date dataIn, Date dataFin) {
			
	    	StoricoDao eddao = new StoricoDao(em);
	    	
	    	return eddao.updateStorico(id, idImp, idRuo, dataIn, dataFin);

	 }























}
