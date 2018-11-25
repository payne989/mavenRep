package ejb;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import dao.ContoDao;
import dto.ContoDTO;
import ejbInterfaces.ContoejbLocal;
import ejbInterfaces.ContoejbRemote;
import modelJpa.Conto;
import utility.Util;

@Stateless
@LocalBean
public class Contoejb implements ContoejbRemote, ContoejbLocal {

	private EntityManager em;

	public Contoejb() {}
	
	public ArrayList<ContoDTO> selectAllConto() {

	ContoDao cdao = new ContoDao(em);

		return Util.convertContoJPAList(cdao.SelectAllConti());
	}

	public ContoDTO selectContoById(int id) {

	ContoDao cdao = new ContoDao(em);

		return Util.convertContoJPA(cdao.selectById(id));
	}

	public boolean deleteCorsoByID(int id) {

		ContoDao cdao = new ContoDao(em);

		cdao.delete(id);
		
		return true;

	}

	public boolean insertConto(double saldo, Date dataIn, int idImp) {

		Conto co = new Conto();
		ContoDao cdao = new ContoDao(em);

		co.setSaldo(saldo);
		co.setDatain(dataIn);
		co.setIdimp(idImp);

		cdao.insertImp(co);

		return true;
	}

	//updateconto missing
}
