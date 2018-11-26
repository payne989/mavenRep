package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the conto database table.
 * 
 */
@Entity
@NamedQuery(name="Conto.findAll", query="SELECT c FROM Conto c")
public class Conto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datain;

	private int idimp;

	private double saldo;

	//bi-directional many-to-one association to Movimento
	@OneToMany(mappedBy="conto")
	private List<Movimento> movimentos;

	public Conto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatain() {
		return this.datain;
	}

	public void setDatain(Date datain) {
		this.datain = datain;
	}

	public int getIdimp() {
		return this.idimp;
	}

	public void setIdimp(int idimp) {
		this.idimp = idimp;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Movimento> getMovimentos() {
		return this.movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento addMovimento(Movimento movimento) {
		getMovimentos().add(movimento);
		movimento.setConto(this);

		return movimento;
	}

	public Movimento removeMovimento(Movimento movimento) {
		getMovimentos().remove(movimento);
		movimento.setConto(null);

		return movimento;
	}

}