package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Impiegato;

public class ImpiegatoDao {

	public static Impiegato researchById(int id) {

		Impiegato imp = new Impiegato();

		try {
			
			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM impiegato WHERE id=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				imp.setId(id);
				imp.setCodFisc(res.getString("codfisc"));
				imp.setNome(res.getString("nome"));
				imp.setCognome(res.getString("cognome"));

				System.out.println(imp);

			}

		} catch (Exception e) {
			System.err.println("errore");

			e.printStackTrace();
		}
		return imp;
	}

	public static Impiegato researchByCf(String codfisc) {

		Impiegato imp = new Impiegato();

		try {
			
			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM impiegato WHERE codfisc=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setString(1, codfisc);

			ResultSet res = preparedStatement.executeQuery();

			if (res.next()) {
				imp.setId(res.getInt("id"));
				imp.setCodFisc(codfisc);
				imp.setNome(res.getString("nome"));
				imp.setCognome(res.getString("cognome"));

				System.out.println(imp);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("errore");

			e.printStackTrace();
		}
		return imp;
	}

	public static ArrayList<Impiegato> researchByNome(String nome) {

		ArrayList<Impiegato> impList = new ArrayList<Impiegato>();

		try {
			// metodo connection importato dalla classe DBconnection
			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM impiegato WHERE nome=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setString(1, nome);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Impiegato impie = new Impiegato();

				impie.setId(res.getInt("id"));
				impie.setCodFisc(res.getString("codfisc"));
				impie.setNome(res.getString("nome"));
				impie.setCognome(res.getString("cognome"));

				impList.add(impie);

				System.out.println(impie);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("errore");

			e.printStackTrace();
		}
		return impList;
	}
	
	public static ArrayList<Impiegato> researchByCognome(String cognome) {

		ArrayList<Impiegato> impList = new ArrayList<Impiegato>();

		try {
			// metodo connection importato dalla classe DBconnection
			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM impiegato WHERE cognome=?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setString(1, cognome);

			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Impiegato impie = new Impiegato();

				impie.setId(res.getInt("id"));
				impie.setCodFisc(res.getString("codfisc"));
				impie.setNome(res.getString("nome"));
				impie.setCognome(res.getString("cognome"));

				impList.add(impie);
				System.out.println(impie);
				
			}
			
		} catch (Exception e) {
			
			System.err.println("errore");

			e.printStackTrace();
		}
		return impList;
	}

	public static ArrayList<Impiegato> researchAll() {

		ArrayList<Impiegato> impList = new ArrayList<Impiegato>();

		try {
			// metodo connection importato dalla classe DBconnection
			Connection con = DBconnection.createConnection();

			String qry = "SELECT * FROM impiegato";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);


			ResultSet res = preparedStatement.executeQuery();

			while (res.next()) {

				Impiegato impie = new Impiegato();

				impie.setId(res.getInt("id"));
				impie.setCodFisc(res.getString("codfisc"));
				impie.setNome(res.getString("nome"));
				impie.setCognome(res.getString("cognome"));

				impList.add(impie);
				System.out.println(impie);
				
			}
			
		} catch (Exception e) {
			
			System.err.println("errore");

			e.printStackTrace();
		}
		return impList;
	}
	
	public static void update(int idImpiegato, String codfisc, String nome, String cognome) throws SQLException {

		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE impiegato SET codfisc = ?, nome = ?, cognome = ? WHERE id = ? ";

		try {

			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, codfisc);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, cognome);
			preparedStatement.setInt(4, idImpiegato);

			
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

	public static void insert(Impiegato imp) throws SQLException {
		Connection dbConnection = null;
		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "INSERT INTO impiegato (codFisc, nome, cognome) VALUES (?,?,?)";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, imp.getCodFisc());
			preparedStatement.setString(2, imp.getNome());
			preparedStatement.setString(3, imp.getCognome());

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is created into impiegato chart!");

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

		String updateTableSQL = "DELETE FROM impiegato WHERE id = ?";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, id);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is deleted from impiegato chart!");

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
