package ejbInterfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import dto.StoricoDTO;

@Local
public interface StoricoejbLocal {

public boolean insertStorico(StoricoDTO sto);
	
	public boolean deleteStoricoByID(int id);
	
	public boolean updateStorico(int id, int idImp, int idRuo, Date dataIn, Date dataFin);
	
	public StoricoDTO selectStoricobyId (int id);
	
	public ArrayList<StoricoDTO> selectAllStorico (int idImp);
}
