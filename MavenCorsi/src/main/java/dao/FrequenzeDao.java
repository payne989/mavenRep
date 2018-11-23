package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Frequenze;
import modelJpa.Edizione;

public class FrequenzeDao {

	private EntityManager em;

	public FrequenzeDao() {
		super();
	}

	public FrequenzeDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean insertFrequenze(int idImp, int idEdiz) {

		modelJpa.Frequenze fr = new modelJpa.Frequenze();

		fr.setIdimp(idImp);

		Edizione ed = em.find(Edizione.class, idEdiz);
		fr.setEdizione(ed);

		try {
			em.persist(fr);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean deleteFrequenze(int id) {

		Frequenze freqRes = em.find(Frequenze.class, id);

		em.remove(freqRes);

		return true;
	}

	public ArrayList<Frequenze> selectAllFrequenze() {

		TypedQuery<Frequenze> qry = em.createQuery("SELECT freq FROM FREQUENZE freq ", Frequenze.class);

		return new ArrayList<Frequenze>(qry.getResultList());
	}

	public Frequenze selectFrequenzeById(int id) {

		try {
			return em.find(Frequenze.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

}
