package ejbInterfaces;

import java.util.ArrayList;

import javax.ejb.Remote;

import dto.ImpiegatoDTO;

@Remote
public interface ImpiegatoejbRemote {

public boolean insertImpiegato(String nome, String cognome, String cf);
	
	public boolean updateImpiegato(ImpiegatoDTO impiegato);
	
	public boolean deleteImpByID(int id);
	
	public ArrayList<ImpiegatoDTO> selectImpiegatoByNome(String nome);
	
	public ArrayList<ImpiegatoDTO> selectImpiegatoByCognome(String cognome);
	
	public ImpiegatoDTO selectImpiegatoByCf(String cf);
	
	public ImpiegatoDTO selectImpiegatoById(int id);
	
	public ArrayList<ImpiegatoDTO> selectAllImpiegato();
}
