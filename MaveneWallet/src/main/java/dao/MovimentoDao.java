package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Movimento;

public class MovimentoDao {

	private EntityManager em;

	public MovimentoDao() {
		super();
	}

	public MovimentoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public boolean versamento(double importo, int idConto, Date data) {

		Movimento mov = new Movimento();

		mov.setIdtipo(2);
		mov.setIdconto(idConto);
		mov.setImporto(importo);
		mov.setData(data);

		em.persist(mov);

		ContoDao co = new ContoDao();

		try {
			co.aggiuntaConto(idConto, importo);
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

		return true;

	}

	public boolean prelievo(double importo, int idConto, Date data) {

		Movimento mov = new Movimento();

		mov.setIdtipo(1);
		mov.setIdconto(idConto);
		mov.setImporto(importo);
		mov.setData(data);

		em.persist(mov);

		ContoDao co = new ContoDao();

		try {
			co.sottraiConto(idConto, importo);
			return true;
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Movimento> selectAll(int idConto) {

		TypedQuery<Movimento> qry = em.createQuery("SELECT mov FROM MOVIMENTO mov WHERE mov.idconto = :idconto",
				Movimento.class);

		qry.setParameter("idconto", idConto);

		return new ArrayList<Movimento>(qry.getResultList());
	}
}