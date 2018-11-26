package utility;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import dto.ContoDTO;
import dto.MovimentoDTO;
import dto.TipomovDTO;
import modelJpa.Conto;
import modelJpa.Movimento;
import modelJpa.Tipomov;


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

		cdto.setIdconto(co.getId());
		cdto.setSaldo(co.getSaldo());
		cdto.setDatain(co.getDatain());
		cdto.setIdimp(co.getIdimp());
	
		return cdto;
	
	
	}

	public static ArrayList<ContoDTO> convertContoJPAList(ArrayList<Conto> co) {

		ArrayList<ContoDTO> coListDto = new ArrayList<ContoDTO>();
		Iterator<Conto> a = co.iterator();
		while (a.hasNext()) {
			coListDto.add(convertContoJPA(a.next()));
		}
		return coListDto;

	}

	public static MovimentoDTO convertMovimentoJPA (Movimento mov) {

	MovimentoDTO mdto = new MovimentoDTO();

		mdto.setIdmov(mov.getId());
		mdto.setIdtipo(mov.getTipomov().getId());
		mdto.setIdconto(mov.getConto().getId());
		mdto.setImporto(mov.getImporto());
		mdto.setData(mov.getData());
		
		return mdto;
	
	
	}

	public static ArrayList<MovimentoDTO> convertMovimentoJPAList(ArrayList<Movimento> mov) {

		ArrayList<MovimentoDTO> moListDto = new ArrayList<MovimentoDTO>();
		Iterator<Movimento> a = mov.iterator();
		while (a.hasNext()) {
			moListDto.add(convertMovimentoJPA(a.next()));
		}
		return moListDto;

	}

	public static TipomovDTO convertTipomovJPA(Tipomov tm) {

		TipomovDTO tdto = new TipomovDTO();

		tdto.setIdtipo(tm.getId());
		tdto.setTipo(tm.getTipo());
		
		
	
		return tdto;
	
	
	}

	public static ArrayList<TipomovDTO> convertTipomovJPAList(ArrayList<Tipomov> tm) {

		ArrayList<TipomovDTO> tmListDto = new ArrayList<TipomovDTO>();
		Iterator<Tipomov> a = tm.iterator();
		while (a.hasNext()) {
			tmListDto.add(convertTipomovJPA(a.next()));
		}
		return tmListDto;
	

	}



}
