package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cf;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Edizione
	@OneToMany(mappedBy="docente")
	private List<Edizione> ediziones;

	public Docente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCf() {
		return this.cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Edizione> getEdiziones() {
		return this.ediziones;
	}

	public void setEdiziones(List<Edizione> ediziones) {
		this.ediziones = ediziones;
	}

	public Edizione addEdizione(Edizione edizione) {
		getEdiziones().add(edizione);
		edizione.setDocente(this);

		return edizione;
	}

	public Edizione removeEdizione(Edizione edizione) {
		getEdiziones().remove(edizione);
		edizione.setDocente(null);

		return edizione;
	}

}