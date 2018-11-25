package dao;


import javax.persistence.EntityManager;
import java.util.Date;

import modelJpa.Impiegato;
import modelJpa.Ruolo;
import modelJpa.Storico;


public class StoricoDao {

	private EntityManager em;

	public StoricoDao() {
		super();
	}

	public StoricoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Storico selectStoricoById(int id) {

		try {
			return em.find(Storico.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	//public static ArrayList<Storico> researchByIdImp(int idImp) 
	
	public boolean updateStorico(int id, int idImp, int idRuo, Date dataIn, Date dataFin) {

		Storico stor= em.find(Storico.class,id);
    	
		stor.setDatain(dataIn);
		stor.setDatafin(dataFin);
		
		Impiegato i = em.find(Impiegato.class, idImp);
		stor.setImpiegato(i);
		
		Ruolo r = em.find(Ruolo.class, idRuo);
		stor.setRuolo(r);
		
		
		try {
			em.merge(stor);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return true;
	} 

	public boolean insertStorico(int idImpiegato, int idRuolo, Date dataInizio, Date dataFine) {

		Storico stor = new Storico();

		stor.setDatain(dataInizio);
		stor.setDatain(dataFine);

		Impiegato imp = em.find(Impiegato.class, idImpiegato);
		stor.setImpiegato(imp);
		
		Ruolo ruo = em.find(Ruolo.class, idRuolo);
		stor.setRuolo(ruo);
		try {
			em.persist(ruo);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean deleteStorico (int id) {
		
		Storico stoRes = em.find(Storico.class, id);
		em.remove(stoRes);

		return true;
	} 
}
