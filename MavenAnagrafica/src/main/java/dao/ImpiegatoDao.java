package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Impiegato;

public class ImpiegatoDao {

	private EntityManager em;

	public ImpiegatoDao() {
		super();
	}

	public ImpiegatoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Impiegato selectById(int id) {
		try {
			return em.find(modelJpa.Impiegato.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public Impiegato selectByCf(String cf) {
		TypedQuery<Impiegato> qry = em.createQuery("SELECT imp FROM impiegato imp WHERE imp.cf = :cf", Impiegato.class);

		qry.setParameter("cf", cf);

		Impiegato imp = (qry.getSingleResult());

		return imp;
	}

	public ArrayList<Impiegato> selectByNome(String nome) {

		TypedQuery<Impiegato> qry = em.createQuery("SELECT imp FROM IMPIEGATO imp WHERE imp.nome LIKE :nome",
				Impiegato.class);

		qry.setParameter("nome", "%" + nome + "%");

		return new ArrayList<Impiegato>(qry.getResultList());
	}

	public ArrayList<Impiegato> researchByCognome(String cognome) {

		TypedQuery<Impiegato> qry = em.createQuery("SELECT imp FROM IMPIEGATO imp WHERE imp.cognome LIKE :cognome",
				Impiegato.class);

		qry.setParameter("nome", "%" + cognome + "%");

		return new ArrayList<Impiegato>(qry.getResultList());
	}

	public ArrayList<Impiegato> SelectAllImp() {

		TypedQuery<Impiegato> qry = em.createQuery("SELECT imp FROM IMPIEGATO imp ", Impiegato.class);

		return new ArrayList<Impiegato>(qry.getResultList());
	}

	public boolean update(Impiegato imp) {

		try {
			em.merge(imp);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public boolean insertImp(Impiegato imp) {
		try {
			em.persist(imp);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean delete(int id) {

		Impiegato impRes = em.find(Impiegato.class, id);

		em.remove(impRes);

		return true;
	}

}
