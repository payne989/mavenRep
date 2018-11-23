package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import model.Conto;
import utility.Util;


public class ContoDao {

	public static boolean modificaConto(int idConto, double importo) throws SQLException, NamingException {

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		String qry = "UPDATE conto SET saldo = saldo + ? WHERE idconto = ? ";

		PreparedStatement preparedStatement = con.prepareStatement(qry);

		preparedStatement.setDouble(1, importo);
		preparedStatement.setInt(2, idConto);

		preparedStatement.executeUpdate();

		return true;

	}

	public static ArrayList<Conto> selectAll() throws SQLException, NamingException, DatatypeConfigurationException {

		ArrayList<Conto> contoList = new ArrayList<Conto>();

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		String qry = "SELECT * from conto";

		PreparedStatement preparedStatement = con.prepareStatement(qry);

		ResultSet res = preparedStatement.executeQuery();
		
		Conto co;
		

		while (res.next()) {

			co = new Conto();

			co.setIdconto(res.getInt("idconto"));
			co.setSaldo(res.getInt("saldo"));
			co.setDatain(Util.sqlToXmlDate(res.getDate("datain")));
			co.setSaldo(res.getInt("saldo"));
			co.setIdimp(res.getInt("idimp"));

			contoList.add(co);

			System.out.println(co);

		}

		return contoList;

	}

	public static Conto selectById(int idConto) throws SQLException, NamingException, DatatypeConfigurationException {

		Conto co = new Conto();

	//	try {

			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL"))
					.getConnection();

			String qry = "SELECT * FROM conto WHERE idconto=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, idConto);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				co.setIdconto(idConto);
				co.setSaldo(res.getDouble("saldo"));
				co.setDatain(Util.sqlToXmlDate(res.getDate("datain")));
				co.setIdimp(res.getInt("idimp"));

				System.out.println(co);

			}


		return co;
	}

	public static void cancellaConto(int idConto) {

		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL"))
					.getConnection();

			String qry = "DELETE FROM conto WHERE idconto = ?";

			PreparedStatement preparedStatement = con.prepareStatement(qry);

			preparedStatement.setDouble(1, idConto);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void inserisciConto(double saldo, Date dataIn, int idImp) {
		
		if (saldo<=0) {
			return ;
		}
		if (idImp<=0) {
			return;
		}
		
		try {
			Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL"))
					.getConnection();

			java.sql.PreparedStatement preparedStatement = null;

			String insertTableSQL = "INSERT INTO conto (saldo, datain, idimp) VALUES (?,?,?)";

			preparedStatement = con.prepareStatement(insertTableSQL);

			preparedStatement.setDouble(1, saldo);
			preparedStatement.setDate(2, dataIn);
			preparedStatement.setInt(3, idImp);

			// execute update SQL stetement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (NamingException e) {

			e.printStackTrace();
		}

	}

}
