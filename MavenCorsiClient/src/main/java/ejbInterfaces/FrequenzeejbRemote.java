package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.FrequenzeDTO;

@Remote
public interface FrequenzeejbRemote {

	public boolean insertFrequenze (FrequenzeDTO freq);
	
	public boolean deleteFrequenzeByID (int id);
	
	public FrequenzeDTO selectFrequenzeById (int id);
	
	public ArrayList<FrequenzeDTO> selectAllFrequenze();
}
