package ejbInterfaces;


import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import dto.EdizioneDTO;

@Local
public interface EdizioneejbLocal {

	public boolean insertEdizione(EdizioneDTO ed);
	
	public boolean deleteEdizioneByID(int id);
	
	public boolean updateEdizione(int id, int idSede, int idDocente, Date dataIn, Date dataFin);
	 
	 public EdizioneDTO selectEdizioneById (int id);
	 
	 public ArrayList<EdizioneDTO> selectAllEdizione ();
}
