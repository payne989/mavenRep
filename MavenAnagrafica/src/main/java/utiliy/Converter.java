package utiliy;

import java.util.ArrayList;
import java.util.Iterator;

import dto.CorsoDTO;
import dto.DocenteDTO;
import dto.EdizioneDTO;
import dto.FrequenzeDTO;
import dto.ImpiegatoDTO;
import dto.RuoloDTO;
import dto.SedeDTO;
import dto.StoricoDTO;
import modelJpa.Corso;
import modelJpa.Docente;
import modelJpa.Edizione;
import modelJpa.Frequenze;
import modelJpa.Impiegato;
import modelJpa.Ruolo;
import modelJpa.Sede;
import modelJpa.Storico;

public class Converter {

//	// convertitori objects DTO to MODEL
//
//	public static EdizioneDTO convertEdizione(Edizione ed) {
//
//		EdizioneDTO edto = new EdizioneDTO();
//
//		edto.setId(ed.getId());
//		edto.setIdCorso(ed.getCorso()());
//		edto.setIdSede(ed.getIdSede());
//		edto.setIdDocente(ed.getIdDocente());
//		edto.setDataIn(ed.getDataIn());
//		edto.setDataFin(ed.getDataFin());
//
//		return edto;
//	}
//
//	public static CorsoDTO convertCorso(Corso cor) {
//
//		CorsoDTO cdto = new CorsoDTO();
//
//		cdto.setId(cor.getId());
//		cdto.setNome(cor.getNome());
//
//		return cdto;
//
//	}
//
//	public static DocenteDTO convertDocente(Docente doc) {
//
//		DocenteDTO ddto = new DocenteDTO();
//
//		ddto.setId(doc.getId());
//		ddto.setNome(doc.getNome());
//		ddto.setCognome(doc.getCognome());
//		ddto.setCf(doc.getCf());
//
//		return ddto;
//	}
//
//	public static FrequenzeDTO convertFrequenze(Frequenze freq) {
//
//		FrequenzeDTO fdto = new FrequenzeDTO();
//
//		fdto.setId(freq.getId());
//		fdto.setIdImp(freq.getIdImp());
//		fdto.setIdEdiz(freq.getIdEdiz());
//
//		return fdto;
//
//	}
//
//	public static SedeDTO convertSede(Sede sed) {
//
//		SedeDTO sdto = new SedeDTO();
//
//		sdto.setId(sed.getId());
//		sdto.setNomeSede(sed.getNomeSede());
//		sdto.setIndirizzo(sed.getIndirizzo());
//		sdto.setCitta(sed.getCitta());
//
//		return sdto;
//	}
//
//	// convertitori arrayList DTO to arrayList MODEL
//
//	public static ArrayList<EdizioneDTO> convertEdizioneList(ArrayList<Edizione> edList) {
//
//		ArrayList<EdizioneDTO> edListDto = new ArrayList<EdizioneDTO>();
//		Iterator<Edizione> a = edList.iterator();
//		while (a.hasNext()) {
//			edListDto.add(convertEdizione(a.next()));
//		}
//		return edListDto;
//
//	}
//
//	public static ArrayList<CorsoDTO> convertCorsoList(ArrayList<Corso> corList) {
//
//		ArrayList<CorsoDTO> corListDto = new ArrayList<CorsoDTO>();
//		Iterator<Corso> a = corList.iterator();
//		while (a.hasNext()) {
//			corListDto.add(convertCorso(a.next()));
//		}
//		return corListDto;
//
//	}
//
//	public static ArrayList<DocenteDTO> convertDocenteList(ArrayList<Docente> docList) {
//
//		ArrayList<DocenteDTO> docListDto = new ArrayList<DocenteDTO>();
//		Iterator<Docente> a = docList.iterator();
//		while (a.hasNext()) {
//			docListDto.add(convertDocente(a.next()));
//		}
//		return docListDto;
//
//	}
//
//	public static ArrayList<SedeDTO> convertSedeList(ArrayList<Sede> sedList) {
//
//		ArrayList<SedeDTO> sedListDto = new ArrayList<SedeDTO>();
//		Iterator<Sede> a = sedList.iterator();
//		while (a.hasNext()) {
//			sedListDto.add(convertSede(a.next()));
//		}
//		return sedListDto;
//
//	}
//
//	public static ArrayList<FrequenzeDTO> convertFrequenzeList(ArrayList<Frequenze> freqList) {
//
//		ArrayList<FrequenzeDTO> freqListDto = new ArrayList<FrequenzeDTO>();
//		Iterator<Frequenze> a = freqList.iterator();
//		while (a.hasNext()) {
//			freqListDto.add(convertFrequenze(a.next()));
//		}
//		return freqListDto;
//
//	}

	// convertitori objects jpa to dto

	public static EdizioneDTO convertEdizioneJPA(Edizione ed) {

		EdizioneDTO edto = new EdizioneDTO();

		edto.setId(ed.getId());
		edto.setIdCorso(ed.getCorso().getId());
		edto.setIdSede(ed.getSede().getId());
		edto.setIdDocente(ed.getSede().getId());
		edto.setDataIn(ed.getDatain());
		edto.setDataFin(ed.getDatafin());

		return edto;
	}

	public static CorsoDTO convertCorsoJPA(Corso cor) {

		CorsoDTO cdto = new CorsoDTO();

		cdto.setId(cor.getId());
		cdto.setNome(cor.getNome());

		return cdto;

	}

	public static DocenteDTO convertDocenteJPA(Docente doc) {

		DocenteDTO ddto = new DocenteDTO();

		ddto.setId(doc.getId());
		ddto.setNome(doc.getNome());
		ddto.setCognome(doc.getCognome());
		ddto.setCf(doc.getCf());

		return ddto;
	}

	public static FrequenzeDTO convertFrequenzeJPA(Frequenze freq) {

		FrequenzeDTO fdto = new FrequenzeDTO();

		fdto.setId(freq.getId());
		fdto.setIdImp(freq.getIdimp());
		fdto.setIdEdiz(freq.getEdizione().getId());

		return fdto;

	}

	public static SedeDTO convertSedeJPA(Sede sed) {

		SedeDTO sdto = new SedeDTO();

		sdto.setId(sed.getId());
		sdto.setNomeSede(sed.getNomesede());
		sdto.setIndirizzo(sed.getIndirizzo());
		sdto.setCitta(sed.getCitta());

		return sdto;
	}

	public static ImpiegatoDTO convertImpiegatoJPA(Impiegato imp){
		
		ImpiegatoDTO idto = new ImpiegatoDTO();

		idto.setId(imp.getId());
		idto.setNome(imp.getNome());
		idto.setCognome(imp.getCognome());
		idto.setCodFisc(imp.getCf()); 
		
		return idto;
		
		
	}
	
	public static RuoloDTO convertRuoloJPA(Ruolo ruo){
		
		RuoloDTO rdto = new RuoloDTO();

		rdto.setId(ruo.getId());
		rdto.setNomeRuolo(ruo.getNomeruolo());
		rdto.setStipendio(ruo.getStipendio()); 
		
		return rdto;
		
		
	}	
	
	public static StoricoDTO convertStoricoJPA(Storico stor) {

		StoricoDTO stdto = new StoricoDTO();

		stdto.setId(stor.getId());
		stdto.setIdImpiegato(stor.getImpiegato().getId());
		stdto.setIdRuolo(stor.getRuolo().getId());
		stdto.setDataInizio(stor.getDatain());
		stdto.setDataFine(stor.getDatafin());

		return stdto;
	}

	
	
	
	// convertitori arrayList DTO to arrayList MODELJPA
	
	public static ArrayList<EdizioneDTO> convertEdizioneJPAList(ArrayList<Edizione> edList) {

		ArrayList<EdizioneDTO> edListDto = new ArrayList<EdizioneDTO>();
		Iterator<Edizione> a = edList.iterator();
		while (a.hasNext()) {
			edListDto.add(convertEdizioneJPA(a.next()));
		}
		return edListDto;

	}

	public static ArrayList<CorsoDTO> convertCorsoJPAList(ArrayList<Corso> corList) {

		ArrayList<CorsoDTO> corListDto = new ArrayList<CorsoDTO>();
		Iterator<modelJpa.Corso> a = corList.iterator();
		while (a.hasNext()) {
			corListDto.add(convertCorsoJPA(a.next()));
		}
		return corListDto;

	}

	public static ArrayList<DocenteDTO> convertDocenteJPAList(ArrayList<Docente> docList) {

		ArrayList<DocenteDTO> docListDto = new ArrayList<DocenteDTO>();
		Iterator<modelJpa.Docente> a = docList.iterator();
		while (a.hasNext()) {
			docListDto.add(convertDocenteJPA(a.next()));
		}
		return docListDto;

	}

	public static ArrayList<SedeDTO> convertSedeJPAList(ArrayList<Sede> sedList) {

		ArrayList<SedeDTO> sedListDto = new ArrayList<SedeDTO>();
		Iterator<modelJpa.Sede> a = sedList.iterator();
		while (a.hasNext()) {
			sedListDto.add(convertSedeJPA(a.next()));
		}
		return sedListDto;

	}

	public static ArrayList<FrequenzeDTO> convertFrequenzeJPAList(ArrayList<Frequenze> freqList) {

		ArrayList<FrequenzeDTO> freqListDto = new ArrayList<FrequenzeDTO>();
		Iterator<modelJpa.Frequenze> a = freqList.iterator();
		while (a.hasNext()) {
			freqListDto.add(convertFrequenzeJPA(a.next()));
		}
		return freqListDto;

	}

	public static ArrayList<ImpiegatoDTO> convertImpiegatoJPAList(ArrayList<Impiegato> impList) {

		ArrayList<ImpiegatoDTO> impListDto = new ArrayList<ImpiegatoDTO>();
		Iterator<Impiegato> a = impList.iterator();
		while (a.hasNext()) {
			impListDto.add(convertImpiegatoJPA(a.next()));
		}
		return impListDto;

	}
	
	public static ArrayList<RuoloDTO> convertRuoloJPAList(ArrayList<Ruolo> ruoList) {

		ArrayList<RuoloDTO> ruoListDto = new ArrayList<RuoloDTO>();
		Iterator<Ruolo> a = ruoList.iterator();
		while (a.hasNext()) {
			ruoListDto.add(convertRuoloJPA(a.next()));
		}
		return ruoListDto;

	}
	
	public static ArrayList<StoricoDTO> convertStoricoJPAList(ArrayList<Storico> stoList) {

		ArrayList<StoricoDTO> stoListDto = new ArrayList<StoricoDTO>();
		Iterator<Storico> a = stoList.iterator();
		while (a.hasNext()) {
			stoListDto.add(convertStoricoJPA(a.next()));
		}
		return stoListDto;

	}









}
