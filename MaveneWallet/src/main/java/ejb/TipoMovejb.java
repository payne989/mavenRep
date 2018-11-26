package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import dao.TipoMovDao;
import dto.TipomovDTO;
import ejbInterfaces.TipomovejbLocal;
import ejbInterfaces.TipomovejbRemote;
import modelJpa.Tipomov;
import utility.Util;

@Stateless
@LocalBean
public class TipoMovejb implements TipomovejbLocal, TipomovejbRemote  {

	private EntityManager em;
	
	public TipoMovejb() {}
	
	public ArrayList<TipomovDTO> selectAllTipoMov() {

		TipoMovDao tmdao = new TipoMovDao(em);

		return Util.convertTipomovJPAList(tmdao.SelectAllTipoMov()); 	
				
	
	}

	public boolean insertTipoMov(String tipo) {

		Tipomov tm = new Tipomov();
		TipoMovDao tmdao = new TipoMovDao(em);

		tm.setTipo(tipo);

		tmdao.insertTipoMov(tm);

		return true;
	}

}
