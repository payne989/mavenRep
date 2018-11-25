package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ejbInterfaces.MovimentoejbLocal;
import ejbInterfaces.MovimentoejbRemote;

@Stateless
@LocalBean
public class Movimentoejb implements MovimentoejbLocal, MovimentoejbRemote {

	
	private EntityManager em;
	
	public Movimentoejb() {}
	
	//Metodo Lista movimenti missing

	//metodo crea movimento ??
	
	//metodo bonifico/prelievo ??

	//copiare all firme
}
