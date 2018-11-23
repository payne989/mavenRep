package ejbInterfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import dto.SedeDTO;


@Local
public interface SedeejbLocal {

	public boolean insertSede(String nomeSede, String indirizzo, String citta);
	
	public boolean deleteSedeByID (int id);
	
	public boolean updateSede(SedeDTO sede);;
	
	public ArrayList<SedeDTO> selectAllSede ();
	
    public ArrayList<SedeDTO> selectSedeByNome (String nomeSede);
	
	public SedeDTO selectSedeById (int id);
    

}
