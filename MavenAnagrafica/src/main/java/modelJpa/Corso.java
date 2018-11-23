package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the corso database table.
 * 
 */
@Entity
@NamedQuery(name="Corso.findAll", query="SELECT c FROM Corso c")
public class Corso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	//bi-directional many-to-one association to Edizione
	@OneToMany(mappedBy="corso")
	private List<Edizione> ediziones;

	public Corso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
		edizione.setCorso(this);

		return edizione;
	}

	public Edizione removeEdizione(Edizione edizione) {
		getEdiziones().remove(edizione);
		edizione.setCorso(null);

		return edizione;
	}

}