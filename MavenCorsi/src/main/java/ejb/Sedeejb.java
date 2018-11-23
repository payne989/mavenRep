package ejb;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.SedeDao;
import dto.SedeDTO;
import ejbInterfaces.SedeejbLocal;
import ejbInterfaces.SedeejbRemote;
import modelJpa.Sede;
import utility.Converter;

@Stateless
@LocalBean
	public class Sedeejb implements SedeejbRemote, SedeejbLocal {

	@PersistenceContext(unitName="Hib4PU")
	private EntityManager em;
	
	public Sedeejb() {
	}

	public boolean insertSede(String nomeSede, String indirizzo, String citta) {

		Sede sed = new Sede();
		SedeDao sdao = new SedeDao();

		sed.setNomesede(nomeSede);
		sed.setIndirizzo(indirizzo);
		sed.setCitta(citta);

		sdao.insertSede(sed);

		return true;
	}

	public boolean deleteSedeByID(int id) {

		SedeDao sdao = new SedeDao(em);
		
		return sdao.deleteSedeByID(id);
	}

	public boolean updateSede(SedeDTO sede) {
    	
    	Sede sed = new Sede();
    	SedeDao sdao = new SedeDao(em);
    	
    	sed.setId(sede.getId());
    	sed.setIndirizzo(sede.getIndirizzo());
    	sed.setCitta(sede.getCitta());
    	
    	sdao.updateSede(sed);
    	
		return false;
}

	public ArrayList<SedeDTO> selectAllSede() {

		SedeDao sdao = new SedeDao(em);
		
		return Converter.convertSedeJPAList(sdao.selectAllSede());
	}

	public ArrayList<SedeDTO> selectSedeByNome(String nomeSede) {
		
		SedeDao sdao = new SedeDao(em);
		
		return Converter.convertSedeJPAList(sdao.selectSedeByNome(nomeSede));
	}

	public SedeDTO selectSedeById(int id) {
		
		SedeDao sdao = new SedeDao(em);
		
		return Converter.convertSedeJPA(sdao.selectSedeById(id));
	}
}
