 package dao;


import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Edizione;
import modelJpa.Corso;
import modelJpa.Docente;
import modelJpa.Sede;

public class EdizioneDao {
	
	private EntityManager em;
	
	public EdizioneDao(EntityManager em) {
		super();
		this.em = em;
	}

	public EdizioneDao() {
		super();
	}

	public boolean deleteEdizioneByID (int id) {
		
		Edizione edRes = em.find(Edizione.class, id);
		em.remove(edRes);

		return true;
	} 
	
	public boolean updateEdizione(int id, int idSede, int idDocente, Date dataIn, Date dataFin) {

		modelJpa.Edizione ed = em.find(modelJpa.Edizione.class,id);
    	
		ed.setDatain(dataIn);
		ed.setDatafin(dataFin);
		
		Docente d = em.find(Docente.class, idDocente);
		ed.setDocente(d);
		
		Sede s = em.find(Sede.class, idSede);
		ed.setSede(s);
		
		try {
			em.merge(ed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return true;
	} 
	
	public boolean insertEdizione (int idCorso,int idSede, int idDocente, Date dataIn, Date dataFin) {
		
		modelJpa.Edizione ed = new modelJpa.Edizione();
    	
		ed.setDatain(dataIn);
		ed.setDatafin(dataFin);
		
		Corso c = em.find(Corso.class, idCorso);		
		ed.setCorso(c);
		
		Docente d = em.find(Docente.class, idDocente);
		ed.setDocente(d);
		
		Sede s = em.find(Sede.class, idSede);
		ed.setSede(s);
		try {
			em.persist(ed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return true;
	} 

	public Edizione selectEdizioneById(int id) {

		try {
			return em.find(Edizione.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Edizione> selectAllEdizione()  {

		TypedQuery<Edizione> qry = em.createQuery("SELECT ed FROM EDIZIONE ed ", Edizione.class);
		

		return new ArrayList<Edizione>(qry.getResultList());

	}


}
