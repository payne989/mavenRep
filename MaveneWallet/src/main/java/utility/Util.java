package utility;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import dto.ContoDTO;
import modelJpa.Conto;


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


	public static ContoDTO convertContoJPA(Conto co) {

		ContoDTO cdto = new ContoDTO();

		cdto.setIdconto(co.getIdconto());
		cdto.setSaldo(co.getSaldo());
		cdto.setDatain(co.getDatain());
		cdto.setIdimp(co.getIdimp());
	
		return cdto;
	
	
	}

	public static ArrayList<ContoDTO> convertContoJPAList(ArrayList<Conto> arrayList) {

		ArrayList<ContoDTO> coListDto = new ArrayList<ContoDTO>();
		Iterator<Conto> a = arrayList.iterator();
		while (a.hasNext()) {
			coListDto.add(convertContoJPA(a.next()));
		}
		return coListDto;

	}

















}
