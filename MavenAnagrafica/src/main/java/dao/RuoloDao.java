package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Ruolo;
import modelJpa.Impiegato;

public class RuoloDao {

	private EntityManager em;

	public RuoloDao() {
		super();
	}

	public RuoloDao(EntityManager em) {
		super();
		this.em = em;
	}

	public Ruolo selectById(int id) {
		try {
			return em.find(Ruolo.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Ruolo> selectByNome(String nomeRuolo) {

		TypedQuery<Ruolo> qry = em.createQuery("SELECT ruo FROM RUOLO ruo WHERE ruo.nomeruolo LIKE :nome", Ruolo.class);

		qry.setParameter("nome", "%" + nomeRuolo + "%");

		return new ArrayList<Ruolo>(qry.getResultList());
	}

	public boolean updateRuolo(Ruolo ruo) {

		try {
			em.merge(ruo);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public boolean insertRuolo(Ruolo ru) {
		try {
			em.persist(ru);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean deleteRuolo(int id) {

		Impiegato impRes = em.find(Impiegato.class, id);

		em.remove(impRes);

		return true;
	}

}
