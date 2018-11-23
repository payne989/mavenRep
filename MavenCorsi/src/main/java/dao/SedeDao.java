package dao;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelJpa.Sede;

public class SedeDao {

	private EntityManager em;
	
	public SedeDao(EntityManager em) {
		super();
		this.em = em;
	}
    
	public SedeDao() {
		super();
	}

	public boolean insertSede(Sede sed) {

		try {
			em.persist(sed);
		} catch (Exception e) {
			
			e.printStackTrace();
			}

		return true;

	}

	public boolean deleteSedeByID(int id) {

		Sede sedRes = em.find(Sede.class, id);
		
		em.remove(sedRes);

		return true;
	}

	public boolean updateSede(Sede sed) {

		try {
			em.merge(sed);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;

	}

	public ArrayList<Sede> selectSedeByNome(String nomeSede) {

		TypedQuery<Sede> qry = em.createQuery("SELECT sed FROM SEDE sed WHERE sed.nome LIKE :nome", Sede.class);
		qry.setParameter("nome","%"+ nomeSede + "%");

		return new ArrayList<Sede>(qry.getResultList());

	}

	public Sede selectSedeById(int id) {
		
		try {
			return em.find(Sede.class, id);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<Sede> selectAllSede()  {

		TypedQuery<Sede> qry = em.createQuery("SELECT sed FROM SEDE sed ", Sede.class);
		

		return new ArrayList<Sede>(qry.getResultList());
	
	}
}
