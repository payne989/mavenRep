package dao;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Docente;

public class DocenteDao {

	private EntityManager em;

	public DocenteDao(EntityManager em) {
		super();
		this.em = em;
	}

	public DocenteDao() {
		super();
	}

	public boolean insertDocente(Docente doc) {

		try {
			em.persist(doc);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;
	}

	public boolean deleteDocenteByID(int id) {

		Docente docRes = em.find(Docente.class, id);
		
		em.remove(docRes);

		return true;

	}

	public boolean updateDocente(Docente doc) {

		try {
			em.merge(doc);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public Docente selectDocenteBycf(String cf) {

		TypedQuery<Docente> qry = em.createQuery("SELECT doc FROM DOCENTE doc WHERE doc.cf = :codfisc", Docente.class);
		qry.setParameter("codfisc", cf);

		Docente doc = (qry.getSingleResult());

		return doc;
	}

	public Docente selectDocenteById(int id) {

		try {
			return em.find(Docente.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Docente> selectAllDocente() {

		TypedQuery<Docente> qry = em.createQuery("SELECT doc FROM DOCENTE doc ", Docente.class);
		

		return new ArrayList<Docente>(qry.getResultList());
		
	}
}
