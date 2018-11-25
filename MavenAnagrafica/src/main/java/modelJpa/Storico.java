package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the storico database table.
 * 
 */
@Entity
@NamedQuery(name="Storico.findAll", query="SELECT s FROM Storico s")
public class Storico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datafin;

	@Temporal(TemporalType.DATE)
	private Date datain;

	//bi-directional many-to-one association to Impiegato
	@ManyToOne
	@JoinColumn(name="idimp")
	private Impiegato impiegato;

	//bi-directional many-to-one association to Ruolo
	@ManyToOne
	@JoinColumn(name="idruolo")
	private Ruolo ruolo;

	public Storico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatafin() {
		return this.datafin;
	}

	public void setDatafin(Date datafin) {
		this.datafin = datafin;
	}

	public Date getDatain() {
		return this.datain;
	}

	public void setDatain(Date datain) {
		this.datain = datain;
	}

	public Impiegato getImpiegato() {
		return this.impiegato;
	}

	public void setImpiegato(Impiegato impiegato) {
		this.impiegato = impiegato;
	}

	public Ruolo getRuolo() {
		return this.ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}