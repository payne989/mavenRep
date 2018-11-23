package dto;

import java.io.Serializable;
import java.util.Date;

public class EdizioneDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int idCorso;
	private int idSede;
	private int idDocente;
	private Date dataIn;
	private Date dataFin;

	public EdizioneDTO(int id, int idCorso, int idSede, int idDocente, Date dataIn,Date dataFin) {

		this.id = id;
		this.idCorso = idCorso;
		this.idSede = idSede;
		this.idDocente = idDocente;
		this.dataIn = dataIn;
		this.dataFin = dataFin;
	}

	public EdizioneDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public Date getDataIn() {
		return dataIn;
	}

	public void setDataIn(Date dataIn) {
		this.dataIn = dataIn;
	}

	public Date getDataFin() {
		return dataFin;
	}

	public void setDataFin(Date dataFin) {
		this.dataFin = dataFin;
	}

}
