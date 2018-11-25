package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.datatype.DatatypeConfigurationException;

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

	public static Movimento creaMovimento(int idTipo, int idConto, double importo, Date data)
			throws SQLException, NamingException {

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		if (idTipo == 1) {

			String qry = "INSERT INTO movimento	(idtipo, idconto, importo, data) VALUES (?,?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(qry);

			preparedStatement.setInt(1, idTipo);
			preparedStatement.setInt(2, idConto);
			preparedStatement.setDouble(3, importo);
			preparedStatement.setDate(4, data);
			preparedStatement.executeUpdate();

			ContoDao.modificaConto(idConto, importo);

			System.out.println("Record is created into movimento chart!");
			System.out.println("Saldo Updated!");
		}

		else if (idTipo == 2) {

			String qry = "INSERT INTO movimento	(idtipo, idconto, importo, data) VALUES (?,?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(qry);

			preparedStatement.setInt(1, idTipo);
			preparedStatement.setInt(2, idConto);
			preparedStatement.setDouble(3, importo);
			preparedStatement.setDate(4, data);

			preparedStatement.executeUpdate();

			ContoDao.modificaConto(idConto, importo);

			System.out.println("Record is created into movimento chart!");
			System.out.println("Saldo Updated!");
		}
		return null;

	}

	public static ArrayList<Movimento> selectAll(int idConto)
			throws SQLException, NamingException, DatatypeConfigurationException {

		ArrayList<Movimento> movList = new ArrayList<Movimento>();

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		String qry = "SELECT * from movimento WHERE idconto = ?";

		PreparedStatement preparedStatement = con.prepareStatement(qry);

		preparedStatement.setInt(1, idConto);

		ResultSet res = preparedStatement.executeQuery();

		while (res.next()) {

			Movimento mov = new Movimento();

			mov.setIdmov(res.getInt("idmov"));
			mov.setIdtipo(res.getInt("idtipo"));
			mov.setIdconto(idConto);
			mov.setImporto(res.getDouble("importo"));
			mov.setData(res.getDate("data"));

			movList.add(mov);

			System.out.println(mov);

		}

		return movList;
	}

	


}
