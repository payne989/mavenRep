package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.DocenteDTO;

@Remote
public interface DocenteejbRemote {

	public boolean insertDocente (String nome, String cognome, String cf);
	
	public boolean deleteDocenteByID (int id);
	
	public boolean updateDocente(DocenteDTO docente);
	
	public DocenteDTO selectDocenteById(int id);
	
	public DocenteDTO selectDocenteByCf(String cf);
	
	public ArrayList<DocenteDTO> selectAllDocente();
}
