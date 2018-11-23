package modelJpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the frequenze database table.
 * 
 */
@Entity
@NamedQuery(name="Frequenze.findAll", query="SELECT f FROM Frequenze f")
public class Frequenze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int idimp;

	//bi-directional many-to-one association to Edizione
	@ManyToOne
	@JoinColumn(name="idedizione")
	private Edizione edizione;

	public Frequenze() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdimp() {
		return this.idimp;
	}

	public void setIdimp(int idimp) {
		this.idimp = idimp;
	}

	public Edizione getEdizione() {
		return this.edizione;
	}

	public void setEdizione(Edizione edizione) {
		this.edizione = edizione;
	}

}