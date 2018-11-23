package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Local;

import dto.FrequenzeDTO;

@Local
public interface FrequenzeejbLocal {

	public boolean insertFrequenze (FrequenzeDTO freq);
	
	public boolean deleteFrequenzeByID (int id);

	public FrequenzeDTO selectFrequenzeById (int id);
	
	public ArrayList<FrequenzeDTO> selectAllFrequenze();
}
