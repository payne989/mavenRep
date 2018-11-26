package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.RuoloDTO;

@Remote
public interface RuoloejbRemote {

	public boolean insertRuolo(String nome, double stipendio);
	
	public boolean deleteRuoloByID(int id);
	
	public boolean updateRuolo(RuoloDTO ruolo);
	
	public ArrayList<RuoloDTO> selectRuoloByNome(String nome);
	
	public RuoloDTO selectRuoloById(int id);
}
