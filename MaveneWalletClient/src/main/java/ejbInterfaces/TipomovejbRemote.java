package ejbInterfaces;

import java.util.ArrayList;
import javax.ejb.Remote;
import dto.TipomovDTO;

@Remote
public interface TipomovejbRemote {

	public ArrayList<TipomovDTO> selectAllTipoMov();
	
	public boolean insertTipoMov(String tipo);
}
