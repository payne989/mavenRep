package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ruolo database table.
 * 
 */
@Entity
@NamedQuery(name="Ruolo.findAll", query="SELECT r FROM Ruolo r")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nomeruolo;

	private double stipendio;

	//bi-directional many-to-one association to Storico
	@OneToMany(mappedBy="ruolo")
	private List<Storico> storicos;

	public Ruolo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeruolo() {
		return this.nomeruolo;
	}

	public void setNomeruolo(String nomeruolo) {
		this.nomeruolo = nomeruolo;
	}

	public double getStipendio() {
		return this.stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public List<Storico> getStoricos() {
		return this.storicos;
	}

	public void setStoricos(List<Storico> storicos) {
		this.storicos = storicos;
	}

	public Storico addStorico(Storico storico) {
		getStoricos().add(storico);
		storico.setRuolo(this);

		return storico;
	}

	public Storico removeStorico(Storico storico) {
		getStoricos().remove(storico);
		storico.setRuolo(null);

		return storico;
	}

}