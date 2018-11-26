package ejbInterfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import dto.ContoDTO;

@Local
public interface ContoejbLocal {

public ArrayList<ContoDTO> selectAllConto();
	
	public ContoDTO selectContoById(int id);
	
	public boolean deleteContoByID(int id);
	
	public boolean insertConto(double saldo, Date dataIn, int idImp);
	
	public boolean aggiungiAlConto(int id, double importo);
	
	public boolean sottraiAlConto(int id, double importo);
}
