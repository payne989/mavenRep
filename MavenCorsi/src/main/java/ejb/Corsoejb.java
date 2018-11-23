package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CorsoDao;
import dto.CorsoDTO;
import ejbInterfaces.CorsoejbLocal;
import ejbInterfaces.CorsoejbRemote;
import modelJpa.Corso;
import utility.Converter;

@Stateless
@LocalBean
public class Corsoejb implements CorsoejbRemote, CorsoejbLocal {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;

	public Corsoejb() {
	}

	public boolean insertCorso(String nome) {

		Corso co = new Corso();
		CorsoDao cdao = new CorsoDao(em);

		co.setNome(nome);

		cdao.insertCorso(co);

		return true;
	}

	public boolean deleteCorsoByID(int id) {

		CorsoDao cdao = new CorsoDao(em);

		cdao.deleteCorsoByID(id);

		return true;

	}

	public boolean updateCorso(CorsoDTO corso) {

		Corso co = new Corso();
		CorsoDao cdao = new CorsoDao(em);

		co.setId(corso.getId());
		co.setNome(corso.getNome());

		cdao.updateCorso(co);

		return false;

	}

	public ArrayList<CorsoDTO> selectCorsoByNome(String nome) {

		CorsoDao cdao = new CorsoDao(em);

		return Converter.convertCorsoJPAList(cdao.selectCorsoByNome(nome));

	}

	public CorsoDTO selectCorsoById(int id) {

		CorsoDao cdao = new CorsoDao(em);

		return Converter.convertCorsoJPA(cdao.selectCorsoById(id));
	}

	public ArrayList<CorsoDTO> selectAllCorso() {

		CorsoDao cdao = new CorsoDao(em);

		return Converter.convertCorsoJPAList(cdao.selectAllCorso());
	}

}
