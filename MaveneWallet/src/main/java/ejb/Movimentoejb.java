package ejb;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import dao.MovimentoDao;
import dto.MovimentoDTO;
import ejbInterfaces.MovimentoejbLocal;
import ejbInterfaces.MovimentoejbRemote;
import utility.Util;


@Stateless
@LocalBean
public class Movimentoejb implements MovimentoejbLocal, MovimentoejbRemote {

	
	private EntityManager em;
	
	public Movimentoejb() {}
	
	public boolean versamento (double importo, int idConto, Date data) {
	
	MovimentoDao mdao = new MovimentoDao(em);
	
	mdao.versamento(importo, idConto, data);
	
	return true;
	
}
	
	public boolean prelievo (double importo, int idConto, Date data) {
		
		MovimentoDao mdao = new MovimentoDao(em);
		
		mdao.prelievo(importo, idConto, data);
		
		return true;
		
	}

	public ArrayList<MovimentoDTO> selectAllMovimento(int idConto) {

		MovimentoDao mdao = new MovimentoDao(em);

		return Util.convertMovimentoJPAList(mdao.selectAll(idConto));
		
}
	
}