package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the movimento database table.
 * 
 */
@Entity
@NamedQuery(name="Movimento.findAll", query="SELECT m FROM Movimento m")
public class Movimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private double importo;

	//bi-directional many-to-one association to Conto
	@ManyToOne
	@JoinColumn(name="idconto")
	private Conto conto;

	//bi-directional many-to-one association to Tipomov
	@ManyToOne
	@JoinColumn(name="idtipo")
	private Tipomov tipomov;

	public Movimento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getImporto() {
		return this.importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Conto getConto() {
		return this.conto;
	}

	public void setConto(Conto conto) {
		this.conto = conto;
	}

	public Tipomov getTipomov() {
		return this.tipomov;
	}

	public void setTipomov(Tipomov tipomov) {
		this.tipomov = tipomov;
	}

}