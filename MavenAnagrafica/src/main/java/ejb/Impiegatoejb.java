package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejbInterfaces.CorsoejbLocal;
import ejbInterfaces.CorsoejbRemote;
import ejbInterfaces.ImpiegatoejbLocal;
import ejbInterfaces.ImpiegatoejbRemote;

@Stateless
@LocalBean
public class Impiegatoejb implements ImpiegatoejbRemote, ImpiegatoejbLocal {

	@PersistenceContext(unitName = "Hib4PU")
	private EntityManager em;
	
	public Impiegatoejb() {}
}
