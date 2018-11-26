package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Conto;

public class ContoDao {

	private EntityManager em;

	public ContoDao() {
		super();
	}

	public ContoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean aggiuntaConto(int id, double importo) throws SQLException, NamingException {

		Conto co = selectById(id);

		double saldo = co.getSaldo();

		saldo = saldo + importo;

		co.setSaldo(saldo);

		try {
			em.merge(co);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	public boolean sottraiConto(int id, double importo) throws SQLException, NamingException {

		Conto co = selectById(id);

		double saldo = co.getSaldo();

		saldo = saldo - importo;

		co.setSaldo(saldo);

		try {
			em.merge(co);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Conto> SelectAllConti() {

		TypedQuery<Conto> qry = em.createQuery("SELECT con FROM CONTO con", Conto.class);

		return new ArrayList<Conto>(qry.getResultList());
	}

	public Conto selectById(int id) {
		try {
			return em.find(Conto.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(int id) {

		Conto conRes = em.find(Conto.class, id);

		em.remove(conRes);

		return true;
	}

	public boolean insertConto(Conto co) {
		try {
			em.persist(co);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}

}
