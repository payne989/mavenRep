package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.FrequenzeDao;
import dto.FrequenzeDTO;
import ejbInterfaces.FrequenzeejbLocal;
import ejbInterfaces.FrequenzeejbRemote;
import utility.Converter;


@Stateless
@LocalBean
public class Frequenzeejb implements FrequenzeejbRemote, FrequenzeejbLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
    public Frequenzeejb() {}

    public boolean insertFrequenze (FrequenzeDTO freq) {
    	
    	int idImp = freq.getIdImp();
    	int idEdiz = freq.getIdEdiz();
    	
    	FrequenzeDao fdao = new FrequenzeDao(em);
    	
    	return fdao.insertFrequenze(idImp, idEdiz);
    }
    
    public boolean deleteFrequenzeByID (int id) {
    	
    	FrequenzeDao freqdao = new FrequenzeDao(em);
    	
    	freqdao.deleteFrequenze(id);
    	
    	return true;
    }
    
    public FrequenzeDTO selectFrequenzeById (int id) {
    	
    	FrequenzeDao freqDao = new FrequenzeDao(em);
    	
    	return Converter.convertFrequenzeJPA(freqDao.selectFrequenzeById(id));
    }
    
    public ArrayList<FrequenzeDTO> selectAllFrequenze() {
    	
    	FrequenzeDao freqDao = new FrequenzeDao(em);
    	
    	return Converter.convertFrequenzeJPAList(freqDao.selectAllFrequenze());
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
