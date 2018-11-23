package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import model.Ruolo;

public class RuoloDao {

	public static ArrayList<Ruolo> researchById(int id) {

		ArrayList<Ruolo> ruo = new ArrayList<Ruolo>();

		try {

			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM ruolo WHERE id = ?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			String nomeRuolo;
			int stipendio;

			while (res.next()) {

				id = res.getInt("id");
				nomeRuolo = res.getString("nomeRuolo");
				stipendio = res.getInt("stipendio");

				Ruolo ruoloOBJ = new Ruolo(id, nomeRuolo, stipendio);

				ruo.add(ruoloOBJ);

				for (int i = 0; i < ruo.size(); i++) {
					System.out.println(ruo.get(i));
					System.out.println("sono id");
				}
			}

		} catch (Exception e) {
			System.err.println("errore");

			e.printStackTrace();
		}
		return ruo;
	}

	public static ArrayList<Ruolo> researchByNome(String nomeRuolo) {

		ArrayList<Ruolo> ruo = new ArrayList<Ruolo>();

		try {

			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM ruolo WHERE nomeruolo LIKE ?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setString(1, "%"+ nomeRuolo +"%");

			ResultSet res = preparedStatement.executeQuery();

			int id;
			int stipendio;
			
			

			while (res.next()) {

				id = res.getInt("id");
				nomeRuolo = res.getString("nomeRuolo");
				stipendio = res.getInt("stipendio");

				Ruolo ruoloOBJ = new Ruolo(id, nomeRuolo, stipendio);

				ruo.add(ruoloOBJ);

				for (int i = 0; i < ruo.size(); i++) {
					System.out.println(ruo.get(i));
					System.out.println("sono qui");
				}
			}

		} catch (Exception e) {
			System.err.println("errore");

			e.printStackTrace();
		}
		return ruo;
	}
	
	public static void update(String nomeRuolo, int stipendio, int id) throws SQLException {

		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE ruolo SET nomeRuolo = ?, stipendio = ?" + "WHERE id = ? ";

		try {

			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, nomeRuolo);
			preparedStatement.setInt(2, stipendio);
			preparedStatement.setInt(3, id);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
	}

	public static void insert(Ruolo ruo) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "INSERT INTO ruolo (nomeruolo, stipendio) VALUES (?,?)";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, ruo.getNomeRuolo());
			preparedStatement.setInt(2, ruo.getStipendio());

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is created into ruolo chart!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public static void delete(int id) throws SQLException {

		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "DELETE FROM ruolo WHERE id = ?";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, id);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is deleted from ruolo chart!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

}
