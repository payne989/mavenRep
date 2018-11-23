package dao;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Corso;

public class CorsoDao {

	private EntityManager em;

	public CorsoDao() {
		super();
	}

	public CorsoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean insertCorso(Corso co) {

		try {
			em.persist(co);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;
	}

	public boolean deleteCorsoByID(int id) {

		Corso coRes = em.find(Corso.class, id);
		
		em.remove(coRes);

		return true;
	}

	public boolean updateCorso(Corso co) {

		try {
			em.merge(co);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Corso> selectCorsoByNome(String nome) {

		TypedQuery<Corso> qry = em.createQuery("SELECT cor FROM CORSO cor WHERE cor.nome LIKE :nome", Corso.class);

		qry.setParameter("nome", "%" + nome + "%");

		return new ArrayList<Corso>(qry.getResultList());
	}

	public ArrayList<Corso> selectAllCorso() {

		TypedQuery<Corso> qry = em.createQuery("SELECT cor FROM CORSO cor ", Corso.class);

		return new ArrayList<Corso>(qry.getResultList());

	}

	public Corso selectCorsoById(int id) {

		try {
			return em.find(modelJpa.Corso.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}
}
