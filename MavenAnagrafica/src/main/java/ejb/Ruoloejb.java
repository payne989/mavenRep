package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.RuoloDao;
import dto.RuoloDTO;
import ejbInterfaces.RuoloejbLocal;
import ejbInterfaces.RuoloejbRemote;
import modelJpa.Ruolo;
import utiliy.Converter;

@Stateless
@LocalBean
public class Ruoloejb implements RuoloejbRemote, RuoloejbLocal  {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;
	
	public Ruoloejb() {}

	public boolean insertRuolo(String nome, double stipendio) {

		Ruolo ru = new Ruolo();
		RuoloDao rdao = new RuoloDao(em);

		ru.setNomeruolo(nome);
		ru.setStipendio(stipendio);
		rdao.insertRuolo(ru);

		return true;
	}

	public boolean deleteRuoloByID(int id) {

		RuoloDao rdao = new RuoloDao(em);

		rdao.deleteRuolo(id);

		return true;

	}

	public boolean updateRuolo(RuoloDTO ruolo) {

		Ruolo ru = new Ruolo();
		RuoloDao rdao = new RuoloDao(em);

		ru.setId(ruolo.getId());
		ru.setNomeruolo(ruolo.getNomeRuolo());
		ru.setStipendio(ruolo.getStipendio());
		
		rdao.updateRuolo(ru);

		return false;

	}

	public ArrayList<RuoloDTO> selectRuoloByNome(String nome) {

		RuoloDao rdao = new RuoloDao(em);

		return Converter.convertRuoloJPAList(rdao.selectByNome(nome));

	}

	public RuoloDTO selectRuoloById(int id) {

		RuoloDao cdao = new RuoloDao(em);

		return Converter.convertRuoloJPA(cdao.selectById(id));
	}





























































}
