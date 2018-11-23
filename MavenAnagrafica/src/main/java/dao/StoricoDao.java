package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import com.mysql.jdbc.PreparedStatement;
import model.Storico;

public class StoricoDao {

	public static ArrayList<Storico> researchByIdImp(int idImp) {

		ArrayList<Storico> stor = new ArrayList<Storico>();

		try {
			// metodo connection importato dalla classe DBconnection
			Connection con = DBconnection.createConnection();

			// Eseguiamo una query e immagazziniamone i risultati
			// in un oggetto ResultSet
			String qry = "SELECT * FROM storico WHERE idimpiegato = ?";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(qry);

			preparedStatement.setInt(1, idImp);

			ResultSet res = preparedStatement.executeQuery();

			int id;
			Date dataInizio;
			Date dataFine;
			int idRuolo;
			int idImpiegato;

			while (res.next()) {

				id = res.getInt("id");
				dataInizio = res.getDate("dataInizio");
				dataFine = res.getDate("dataFine");
				idRuolo = res.getInt("idRuolo");
				idImpiegato = res.getInt("idImpiegato");

				Storico storico = new Storico(id, dataInizio, dataFine, idRuolo, idImpiegato);

				stor.add(storico);

				for (int i = 0; i < stor.size(); i++) {
					System.out.println(stor.get(i));
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("errore");

			e.printStackTrace();
		}
		return stor;
	}

	public static void update(int id, Date dataInizio, Date dataFine, int idRuolo, int idImpiegato)
			throws SQLException {
		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "UPDATE storico SET dataInizio = ?, dataFine = ?, idRuolo = ?, idImpiegato = ? WHERE id = ? ";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setDate(1, dataInizio);
			preparedStatement.setDate(2, dataFine);
			preparedStatement.setInt(3, idRuolo);
			preparedStatement.setInt(4, idImpiegato);
			preparedStatement.setInt(5, id);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to storico table!");

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

	public static void insert(Storico stor) throws SQLException {

		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "INSERT INTO storico (dataInizio, dataFine, idRuolo, idImpiegato) VALUES (?,?,?,?)";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setDate(1, stor.getDataInizio());
			preparedStatement.setDate(2, stor.getDataFine());
			preparedStatement.setInt(3, stor.getIdRuolo());
			preparedStatement.setInt(4, stor.getIdImpiegato());

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is created into storico chart!");

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

	public static void delete(int idImp) throws SQLException {

		Connection dbConnection = null;

		java.sql.PreparedStatement preparedStatement = null;

		String updateTableSQL = "DELETE FROM storico WHERE idimpiegato = ?";

		try {

			// metodo connection importato dalla classe DBconnection
			dbConnection = DBconnection.createConnection();

			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			preparedStatement.setInt(1, idImp);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is deleted from storico chart!");

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
