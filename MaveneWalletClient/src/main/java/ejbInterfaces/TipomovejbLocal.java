package ejbInterfaces;

import java.util.ArrayList;
import javax.ejb.Local;
import dto.TipomovDTO;

@Local
public interface TipomovejbLocal {

public ArrayList<TipomovDTO> selectAllTipoMov();
	
	public boolean insertTipoMov(String tipo);
}
