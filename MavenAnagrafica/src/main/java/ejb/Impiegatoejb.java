package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.CorsoDao;
import dao.ImpiegatoDao;
import dto.CorsoDTO;
import dto.ImpiegatoDTO;
import ejbInterfaces.ImpiegatoejbLocal;
import ejbInterfaces.ImpiegatoejbRemote;
import modelJpa.Corso;
import modelJpa.Impiegato;
import utility.Converter;

@Stateless
@LocalBean
public class Impiegatoejb implements ImpiegatoejbRemote, ImpiegatoejbLocal {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;

	public Impiegatoejb() {
	}

	public boolean insertImpiegato(String nome, String cognome, String cf) {

		Impiegato imp = new Impiegato();
		ImpiegatoDao idao = new ImpiegatoDao(em);

		imp.setNome(nome);
		imp.setCognome(cognome);
		imp.setCf(cf);

		idao.insertImp(imp);

		return true;
	}

	public boolean updateImpiegato(ImpiegatoDTO impiegato) {

		Impiegato imp = new Impiegato();
		ImpiegatoDao idao = new ImpiegatoDao(em);

		imp.setId(impiegato.getId());
		imp.setNome(impiegato.getNome());
		imp.setCognome(impiegato.getCognome());
		imp.setCf(impiegato.getCodFisc());

		idao.update(imp);

		return false;

	}

	public boolean deleteCorsoByID(int id) {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		cdao.delete(id);

		return true;
	}

	
	}






















}
