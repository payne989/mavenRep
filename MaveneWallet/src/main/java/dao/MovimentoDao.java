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

import model.Movimento;
import utility.Util;

public class MovimentoDao {

	public static Movimento creaMovimento(int idTipo, int idConto, double importo, XMLGregorianCalendar data)
			throws SQLException, NamingException {

		Connection con = ((DataSource) new InitialContext().lookup("java:jboss/datasources/MYDSSQL")).getConnection();

		if (idTipo == 1) {

			String qry = "INSERT INTO movimento	(idtipo, idconto, importo, data) VALUES (?,?,?,?)";

			PreparedStatement preparedStatement = con.prepareStatement(qry);

			preparedStatement.setInt(1, idTipo);
			preparedStatement.setInt(2, idConto);
			preparedStatement.setDouble(3, importo);
			preparedStatement.setDate(4, Util.xmlToSqlDate(data));
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
			preparedStatement.setDate(4, Util.xmlToSqlDate(data));

			preparedStatement.executeUpdate();

			ContoDao.modificaConto(idConto, importo);

			System.out.println("Record is created into movimento chart!");
			System.out.println("Saldo Updated!");
		}
		return null;
		
	}

	public static ArrayList<Movimento> selectAll(int idConto) throws SQLException, NamingException, DatatypeConfigurationException {

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
			mov.setData(Util.sqlToXmlDate(res.getDate("data")));

			movList.add(mov);

			System.out.println(mov);

		}

		return movList;
	}
}
