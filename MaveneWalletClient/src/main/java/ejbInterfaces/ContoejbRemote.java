package ejbInterfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Remote;

import dto.ContoDTO;

@Remote
public interface ContoejbRemote {

public ArrayList<ContoDTO> selectAllConto();
	
	public ContoDTO selectContoById(int id);
	
	public boolean deleteContoByID(int id);
	
	public boolean insertConto(double saldo, Date dataIn, int idImp);
	
	public boolean aggiungiAlConto(int id, double importo);
	
	public boolean sottraiAlConto(int id, double importo);
}
