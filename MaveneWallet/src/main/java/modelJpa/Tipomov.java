package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipomov database table.
 * 
 */
@Entity
@NamedQuery(name="Tipomov.findAll", query="SELECT t FROM Tipomov t")
public class Tipomov implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="tipomov")
	private List<Movimento> movimentos;

	public Tipomov() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setTipomov(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setTipomov(null);

		return movimento;
	}

}