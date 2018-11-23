package webservices;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.naming.NamingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;

import dao.MovimentoDao;

import model.Movimento;
import response.ResponseBase;
import response.ResponseConto;

import response.ResponseSelectMovimento;

@WebService
public class MovimentoWS {

	public ResponseBase createMovimento(int idTipo, int idConto, double importo, XMLGregorianCalendar data) {

		try {
			ResponseBase rb = new ResponseBase();
			MovimentoDao.creaMovimento(idTipo, idConto, importo, data);
			rb.setResult("OK");
			rb.setErrorCode(0);
			rb.setErrorDesc("tutto ok");

			return rb;

		} catch (SQLException e) {
			ResponseBase rb = new ResponseBase();
			rb.setResult("KO");
			rb.setErrorCode(4);
			rb.setErrorDesc("SQL Exception");
			e.printStackTrace();

		} catch (NamingException e) {
			ResponseBase rb = new ResponseBase();
			rb.setResult("KO");
			rb.setErrorCode(6);
			rb.setErrorDesc("SQL Exception");

			e.printStackTrace();

		}

		return null;

	}

	public ResponseSelectMovimento selectMovimento(int idConto) {

		try {

			ArrayList<Movimento> mov = MovimentoDao.selectAll(idConto);

			ResponseSelectMovimento rsm = new ResponseSelectMovimento();

			rsm.setResult("OK");
			rsm.setErrorCode(0);
			rsm.setErrorDesc("Tutto ok");
			rsm.setList(mov);
			return rsm;

		}

		catch (NamingException e) {
			ResponseSelectMovimento rsm = new ResponseSelectMovimento();
			rsm.setResult("KO");
			rsm.setErrorCode(6);
			rsm.setErrorDesc("naming exception");
			e.printStackTrace();

			return null;

		} catch (SQLException e) {
			ResponseSelectMovimento rsm = new ResponseSelectMovimento();
			rsm.setResult("KO");
			rsm.setErrorCode(4);
			rsm.setErrorDesc("sqlException");
			e.printStackTrace();

			return null;

		} catch (DatatypeConfigurationException e) {
			ResponseSelectMovimento rsm = new ResponseSelectMovimento();
			rsm.setResult("KO");
			rsm.setErrorCode(5);
			rsm.setErrorDesc("data type exception");
			e.printStackTrace();
			
			return null;
		}
		

	}

}
