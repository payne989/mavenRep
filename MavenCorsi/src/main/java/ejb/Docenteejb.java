package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.DocenteDao;
import dto.DocenteDTO;
import ejbInterfaces.DocenteejbLocal;
import ejbInterfaces.DocenteejbRemote;
import modelJpa.Docente;
import utility.Converter;


	@Stateless
	@LocalBean
	public class Docenteejb implements DocenteejbRemote, DocenteejbLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
    public Docenteejb() {}

    public boolean insertDocente (String nome, String cognome, String cf) {
    	
    	
    	Docente doc = new Docente();
    	DocenteDao ddao = new DocenteDao(em);
    	
    	doc.setNome(nome);
    	doc.setCognome(cognome);
    	doc.setCf(cf);
    	
    	ddao.insertDocente(doc);
    
    	return true;
    }

    public boolean deleteDocenteByID (int id) {
    	
    	DocenteDao ddao = new DocenteDao (em);
    	
    	return ddao.deleteDocenteByID(id);
    }
    
    public boolean updateDocente(DocenteDTO docente) {
    	
    	Docente doc = new Docente();
    	DocenteDao docdao = new DocenteDao(em);
    	
    	doc.setId(docente.getId());
    	doc.setNome(docente.getNome());
    	doc.setCognome(docente.getCognome());
    	doc.setCf(docente.getCf());
    	
    	docdao.updateDocente(doc);
    	
		return false;
}

    public DocenteDTO selectDocenteById(int id) {
    	
    	DocenteDao ddao = new DocenteDao (em);
    	
    	return Converter.convertDocenteJPA(ddao.selectDocenteById(id));
    }

    public DocenteDTO selectDocenteByCf(String cf) {
    	
    	DocenteDao ddao = new DocenteDao (em);
    	
    	return Converter.convertDocenteJPA(ddao.selectDocenteBycf(cf)); 
    }

    public ArrayList<DocenteDTO> selectAllDocente() {
    	
    	DocenteDao ddao = new DocenteDao (em);
    	
    	return Converter.convertDocenteJPAList(ddao.selectAllDocente());
    }
}
