package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sede database table.
 * 
 */
@Entity
@NamedQuery(name="Sede.findAll", query="SELECT s FROM Sede s")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String citta;

	private String indirizzo;

	private String nomesede;

	//bi-directional many-to-one association to Edizione
	@OneToMany(mappedBy="sede")
	private List<Edizione> ediziones;

	public Sede() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNomesede() {
		return this.nomesede;
	}

	public void setNomesede(String nomesede) {
		this.nomesede = nomesede;
	}

	public List<Edizione> getEdiziones() {
		return this.ediziones;
	}

	public void setEdiziones(List<Edizione> ediziones) {
		this.ediziones = ediziones;
	}

	public Edizione addEdizione(Edizione edizione) {
		getEdiziones().add(edizione);
		edizione.setSede(this);

		return edizione;
	}

	public Edizione removeEdizione(Edizione edizione) {
		getEdiziones().remove(edizione);
		edizione.setSede(null);

		return edizione;
	}

}