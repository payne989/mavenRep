package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejbInterfaces.RuoloejbLocal;
import ejbInterfaces.RuoloejbRemote;

@Stateless
@LocalBean
public class Ruoloejb implements RuoloejbRemote, RuoloejbLocal  {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;
	
	public Ruoloejb() {}
}
