package webservices;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.naming.NamingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import dao.ContoDao;
import model.Conto;
import response.ResponseBase;
import response.ResponseConto;
import response.ResponseSelectAllConto;
import utility.Util;

@WebService
public class ContoWS {

	public ResponseConto selectIdConto(int idConto)
			throws SQLException, NamingException, DatatypeConfigurationException {

		Conto co = ContoDao.selectById(idConto);

		ResponseConto rc = new ResponseConto();

		if (co.getIdconto() != 0) {
			rc.setResult("OK");
			rc.setCo(co);
			System.out.println("Tutto ok");
		}

		else if (co.getIdconto() == 0) {
			rc.setResult("KO");
			rc.setErrorCode(1);
			rc.setErrorDesc("IdConto deve essere diverso da 0");
			System.out.println("Qualcosa è andato storto");
		} else if (co.getIdconto() < 0) {
			rc.setResult("KO");
			rc.setErrorCode(2);
			rc.setErrorDesc("IdConto deve essere positivo");
			System.out.println("Qualcosa è andato storto");

		}
		return rc;

	}

	public ResponseSelectAllConto selectAllConto() {
	
			try {
				ArrayList<Conto> co = ContoDao.selectAll();
	
				ResponseSelectAllConto rsa = new ResponseSelectAllConto();
	
				rsa.setResult("OK");
				rsa.setErrorCode(0);
				rsa.setErrorDesc("Tutto ok");
				rsa.setList(co);
				return rsa;
	
			}
	
			catch (NamingException e) {
				ResponseConto rc = new ResponseConto();
				rc.setResult("KO");
				rc.setErrorCode(3);
				rc.setErrorDesc("errore creazione datasource");
				e.printStackTrace();
	
				return null;
	
			} catch (SQLException e) {
				ResponseConto rc = new ResponseConto();
				rc.setResult("KO");
				rc.setErrorCode(4);
				rc.setErrorDesc("SQL exception");
				e.printStackTrace();
	
				return null;
	
			} catch (DatatypeConfigurationException e) {
				ResponseConto rc = new ResponseConto();
				rc.setResult("KO");
				rc.setErrorCode(5);
				rc.setErrorDesc("data type config exception");
				e.printStackTrace();
	
				return null;
			}
	
		}

	public ResponseBase insertConto(double saldo, XMLGregorianCalendar dataIn, int idImp) {

		try {
			ContoDao.inserisciConto(saldo, Util.xmlToSqlDate(dataIn), idImp);
			ResponseBase rb = new ResponseBase();
			rb.setResult("OK");
			rb.setErrorCode(0);
			rb.setErrorDesc("Conto Corrente salvato nel DB!");
			System.out.println("Tutto ok");

		} catch (Exception e) {
			ResponseBase rb = new ResponseBase();
			rb.setResult("KO");
			rb.setErrorCode(404);
			rb.setErrorDesc("eccezione generica");
			e.printStackTrace();
			return null;
		}

		return null;

	}

	public ResponseBase deleteConto(int idConto) {

		ContoDao.cancellaConto(idConto);

		ResponseBase rb = new ResponseBase();

		rb.setResult("OK");
		rb.setErrorCode(0);
		rb.setErrorDesc("Conto eliminato con successo dal database");

		return null;

	}
}
