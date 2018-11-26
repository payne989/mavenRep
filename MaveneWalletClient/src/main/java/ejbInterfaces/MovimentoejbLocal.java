package ejbInterfaces;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;

import dto.MovimentoDTO;

@Local
public interface MovimentoejbLocal {

public boolean versamento (double importo, int idConto, Date data);
	
	public boolean prelievo (double importo, int idConto, Date data);
	
	public ArrayList<MovimentoDTO> selectAllMovimento(int idConto);
}
