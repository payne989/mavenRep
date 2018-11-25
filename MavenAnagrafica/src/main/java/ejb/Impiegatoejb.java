package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.ImpiegatoDao;
import dto.ImpiegatoDTO;
import ejbInterfaces.ImpiegatoejbLocal;
import ejbInterfaces.ImpiegatoejbRemote;
import modelJpa.Impiegato;
import utiliy.Converter;


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

	public boolean deleteImpByID(int id) {

		ImpiegatoDao idao = new ImpiegatoDao(em);

		idao.delete(id);

		return true;
	}

	public ArrayList<ImpiegatoDTO> selectImpiegatoByNome(String nome) {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		return Converter.convertImpiegatoJPAList(cdao.selectByNome(nome));
	}
	
	public ArrayList<ImpiegatoDTO> selectImpiegatoByCognome(String cognome) {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		return Converter.convertImpiegatoJPAList(cdao.selectByCognome(cognome));
	}

	public ImpiegatoDTO selectImpiegatoByCf(String cf) {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		return Converter.convertImpiegatoJPA(cdao.selectByCf(cf));

	}

	public ImpiegatoDTO selectImpiegatoById(int id) {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		return Converter.convertImpiegatoJPA(cdao.selectById(id));
	}

	public ArrayList<ImpiegatoDTO> selectAllImpiegato() {

		ImpiegatoDao cdao = new ImpiegatoDao(em);

		return Converter.convertImpiegatoJPAList(cdao.SelectAllImp());
	}




}


