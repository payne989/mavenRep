package modelJpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the edizione database table.
 * 
 */
@Entity
@NamedQuery(name="Edizione.findAll", query="SELECT e FROM Edizione e")
public class Edizione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date datafin;

	@Temporal(TemporalType.DATE)
	private Date datain;

	//bi-directional many-to-one association to Corso
	@ManyToOne
	@JoinColumn(name="idcorso")
	private Corso corso;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="iddocente")
	private Docente docente;

	//bi-directional many-to-one association to Sede
	@ManyToOne
	@JoinColumn(name="idsede")
	private Sede sede;

	//bi-directional many-to-one association to Frequenze
	@OneToMany(mappedBy="edizione")
	private List<Frequenze> frequenzes;

	public Edizione() {
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

	public Corso getCorso() {
		return this.corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Sede getSede() {
		return this.sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Frequenze> getFrequenzes() {
		return this.frequenzes;
	}

	public void setFrequenzes(List<Frequenze> frequenzes) {
		this.frequenzes = frequenzes;
	}

	public Frequenze addFrequenze(Frequenze frequenze) {
		getFrequenzes().add(frequenze);
		frequenze.setEdizione(this);

		return frequenze;
	}

	public Frequenze removeFrequenze(Frequenze frequenze) {
		getFrequenzes().remove(frequenze);
		frequenze.setEdizione(null);

		return frequenze;
	}

}