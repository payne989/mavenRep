package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

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

	public static boolean modificaConto(int idConto, double importo) throws SQLException, NamingException {

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		String qry = "UPDATE conto SET saldo = saldo + ? WHERE idconto = ? ";

		PreparedStatement preparedStatement = con.prepareStatement(qry);

		preparedStatement.setDouble(1, importo);
		preparedStatement.setInt(2, idConto);

		preparedStatement.executeUpdate();

		return true;

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

	public boolean insertImp(Conto co) {
		try {
			em.persist(co);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return true;

	}


}
