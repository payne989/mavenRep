package utility;

import java.util.ArrayList;
import java.util.Iterator;

import dto.CorsoDTO;
import dto.DocenteDTO;
import dto.EdizioneDTO;
import dto.FrequenzeDTO;
import dto.SedeDTO;
import model.Corso;
import model.Docente;
import model.Edizione;
import model.Frequenze;
import model.Sede;

public class Converter {

	// convertitori objects DTO to MODEL

	public static EdizioneDTO convertEdizione(Edizione ed) {

		EdizioneDTO edto = new EdizioneDTO();

		edto.setId(ed.getId());
		edto.setIdCorso(ed.getIdCorso());
		edto.setIdSede(ed.getIdSede());
		edto.setIdDocente(ed.getIdDocente());
		edto.setDataIn(ed.getDataIn());
		edto.setDataFin(ed.getDataFin());

		return edto;
	}

	public static CorsoDTO convertCorso(Corso cor) {

		CorsoDTO cdto = new CorsoDTO();

		cdto.setId(cor.getId());
		cdto.setNome(cor.getNome());

		return cdto;

	}

	public static DocenteDTO convertDocente(Docente doc) {

		DocenteDTO ddto = new DocenteDTO();

		ddto.setId(doc.getId());
		ddto.setNome(doc.getNome());
		ddto.setCognome(doc.getCognome());
		ddto.setCf(doc.getCf());

		return ddto;
	}

	public static FrequenzeDTO convertFrequenze(Frequenze freq) {

		FrequenzeDTO fdto = new FrequenzeDTO();

		fdto.setId(freq.getId());
		fdto.setIdImp(freq.getIdImp());
		fdto.setIdEdiz(freq.getIdEdiz());

		return fdto;

	}

	public static SedeDTO convertSede(Sede sed) {

		SedeDTO sdto = new SedeDTO();

		sdto.setId(sed.getId());
		sdto.setNomeSede(sed.getNomeSede());
		sdto.setIndirizzo(sed.getIndirizzo());
		sdto.setCitta(sed.getCitta());

		return sdto;
	}

	// convertitori arrayList DTO to arrayList MODEL

	public static ArrayList<EdizioneDTO> convertEdizioneList(ArrayList<Edizione> edList) {

		ArrayList<EdizioneDTO> edListDto = new ArrayList<EdizioneDTO>();
		Iterator<Edizione> a = edList.iterator();
		while (a.hasNext()) {
			edListDto.add(convertEdizione(a.next()));
		}
		return edListDto;

	}

	public static ArrayList<CorsoDTO> convertCorsoList(ArrayList<Corso> corList) {

		ArrayList<CorsoDTO> corListDto = new ArrayList<CorsoDTO>();
		Iterator<Corso> a = corList.iterator();
		while (a.hasNext()) {
			corListDto.add(convertCorso(a.next()));
		}
		return corListDto;

	}

	public static ArrayList<DocenteDTO> convertDocenteList(ArrayList<Docente> docList) {

		ArrayList<DocenteDTO> docListDto = new ArrayList<DocenteDTO>();
		Iterator<Docente> a = docList.iterator();
		while (a.hasNext()) {
			docListDto.add(convertDocente(a.next()));
		}
		return docListDto;

	}

	public static ArrayList<SedeDTO> convertSedeList(ArrayList<Sede> sedList) {

		ArrayList<SedeDTO> sedListDto = new ArrayList<SedeDTO>();
		Iterator<Sede> a = sedList.iterator();
		while (a.hasNext()) {
			sedListDto.add(convertSede(a.next()));
		}
		return sedListDto;

	}

	public static ArrayList<FrequenzeDTO> convertFrequenzeList(ArrayList<Frequenze> freqList) {

		ArrayList<FrequenzeDTO> freqListDto = new ArrayList<FrequenzeDTO>();
		Iterator<Frequenze> a = freqList.iterator();
		while (a.hasNext()) {
			freqListDto.add(convertFrequenze(a.next()));
		}
		return freqListDto;

	}

	// convertitori objects DTO to MODELJPA

	public static EdizioneDTO convertEdizioneJPA(modelJpa.Edizione ed) {

		EdizioneDTO edto = new EdizioneDTO();

		edto.setId(ed.getId());
		edto.setIdCorso(ed.getCorso().getId());
		edto.setIdSede(ed.getSede().getId());
		edto.setIdDocente(ed.getSede().getId());
		edto.setDataIn(ed.getDatain());
		edto.setDataFin(ed.getDatafin());

		return edto;
	}

	public static CorsoDTO convertCorsoJPA(modelJpa.Corso cor) {

		CorsoDTO cdto = new CorsoDTO();

		cdto.setId(cor.getId());
		cdto.setNome(cor.getNome());

		return cdto;

	}

	public static DocenteDTO convertDocenteJPA(modelJpa.Docente doc) {

		DocenteDTO ddto = new DocenteDTO();

		ddto.setId(doc.getId());
		ddto.setNome(doc.getNome());
		ddto.setCognome(doc.getCognome());
		ddto.setCf(doc.getCf());

		return ddto;
	}

	public static FrequenzeDTO convertFrequenzeJPA(modelJpa.Frequenze freq) {

		FrequenzeDTO fdto = new FrequenzeDTO();

		fdto.setId(freq.getId());
		fdto.setIdImp(freq.getIdimp());
		fdto.setIdEdiz(freq.getEdizione().getId());

		return fdto;

	}

	public static SedeDTO convertSedeJPA(modelJpa.Sede sed) {

		SedeDTO sdto = new SedeDTO();

		sdto.setId(sed.getId());
		sdto.setNomeSede(sed.getNomesede());
		sdto.setIndirizzo(sed.getIndirizzo());
		sdto.setCitta(sed.getCitta());

		return sdto;
	}

	// convertitori arrayList DTO to arrayList MODELJPA

	public static ArrayList<EdizioneDTO> convertEdizioneJPAList(ArrayList<modelJpa.Edizione> edList) {

		ArrayList<EdizioneDTO> edListDto = new ArrayList<EdizioneDTO>();
		Iterator<modelJpa.Edizione> a = edList.iterator();
		while (a.hasNext()) {
			edListDto.add(convertEdizioneJPA(a.next()));
		}
		return edListDto;

	}

	public static ArrayList<CorsoDTO> convertCorsoJPAList(ArrayList<modelJpa.Corso> corList) {

		ArrayList<CorsoDTO> corListDto = new ArrayList<CorsoDTO>();
		Iterator<modelJpa.Corso> a = corList.iterator();
		while (a.hasNext()) {
			corListDto.add(convertCorsoJPA(a.next()));
		}
		return corListDto;

	}

	public static ArrayList<DocenteDTO> convertDocenteJPAList(ArrayList<modelJpa.Docente> docList) {

		ArrayList<DocenteDTO> docListDto = new ArrayList<DocenteDTO>();
		Iterator<modelJpa.Docente> a = docList.iterator();
		while (a.hasNext()) {
			docListDto.add(convertDocenteJPA(a.next()));
		}
		return docListDto;

	}

	public static ArrayList<SedeDTO> convertSedeJPAList(ArrayList<modelJpa.Sede> sedList) {

		ArrayList<SedeDTO> sedListDto = new ArrayList<SedeDTO>();
		Iterator<modelJpa.Sede> a = sedList.iterator();
		while (a.hasNext()) {
			sedListDto.add(convertSedeJPA(a.next()));
		}
		return sedListDto;

	}

	public static ArrayList<FrequenzeDTO> convertFrequenzeJPAList(ArrayList<modelJpa.Frequenze> freqList) {

		ArrayList<FrequenzeDTO> freqListDto = new ArrayList<FrequenzeDTO>();
		Iterator<modelJpa.Frequenze> a = freqList.iterator();
		while (a.hasNext()) {
			freqListDto.add(convertFrequenzeJPA(a.next()));
		}
		return freqListDto;

	}

	//
}
