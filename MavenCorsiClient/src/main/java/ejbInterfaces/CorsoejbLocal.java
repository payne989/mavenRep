package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Local;

import dto.CorsoDTO;


@Local
public interface CorsoejbLocal {
	
	public boolean insertCorso (String nome);
	
	public boolean deleteCorsoByID(int id);
	
	public boolean updateCorso(CorsoDTO corso);
	 
	public ArrayList<CorsoDTO> selectCorsoByNome (String nome);
	 
	public CorsoDTO selectCorsoById (int id);
	 
	public ArrayList<CorsoDTO> selectAllCorso ();
}
