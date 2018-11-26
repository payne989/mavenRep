package ejb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;
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

	public Contoejb() {
	}

	public ArrayList<ContoDTO> selectAllConto() {

		ContoDao cdao = new ContoDao(em);

		return Util.convertContoJPAList(cdao.SelectAllConti());
	}

	public ContoDTO selectContoById(int id) {

		ContoDao cdao = new ContoDao(em);

		return Util.convertContoJPA(cdao.selectById(id));
	}

	public boolean deleteContoByID(int id) {

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

		cdao.insertConto(co);

		return true;
	}

	public boolean aggiungiAlConto(int id, double importo) {

		ContoDao cdao = new ContoDao(em);

		try {
			cdao.aggiuntaConto(id, importo);
			return true;
		} catch (SQLException | NamingException e)

		{

			e.printStackTrace();
			return false;
		}

	}

	public boolean sottraiAlConto(int id, double importo) {

		ContoDao cdao = new ContoDao(em);

		try {
			cdao.sottraiConto(id, importo);
			return true;
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return false;
		}

	}

}
