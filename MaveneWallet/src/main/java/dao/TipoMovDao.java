package dao;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Tipomov;

public class TipoMovDao {
	
	private EntityManager em;

	public TipoMovDao(EntityManager em) {
		super();
		this.em = em;
	}

	
	public TipoMovDao() {
		super();
	}
	
	public ArrayList<Tipomov> SelectAllTipoMov() {

		TypedQuery<Tipomov> qry = em.createQuery("SELECT tm FROM TIPOMOV tm ", Tipomov.class);

		return new ArrayList<Tipomov>(qry.getResultList());
	}

	public boolean insertImp(Tipomov tm) {
		try {
			em.persist(tm);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}






































}
