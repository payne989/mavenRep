package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import dao.ContoDao;
import dto.ContoDTO;
import ejbInterfaces.ContoejbLocal;
import ejbInterfaces.ContoejbRemote;
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

	
}
