package utility;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Util {

	public static XMLGregorianCalendar sqlToXmlDate(java.sql.Date data) throws DatatypeConfigurationException {

		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(data);
		XMLGregorianCalendar gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

		return gc;

	}

	
	public static java.sql.Date xmlToSqlDate(XMLGregorianCalendar xmlDate) {


		java.sql.Date sqlDate = null;

		if(null!=xmlDate){

		sqlDate = java.sql.Date.valueOf( 
				xmlDate.getYear() + "-" + 
				xmlDate.getMonth() + "-" + 
				xmlDate.getDay() );

		}
		return sqlDate;
		}
}
