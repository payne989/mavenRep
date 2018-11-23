package model;

import java.sql.Date;

public class Storico {

	private int id;
	private Date dataInizio;
	private Date dataFine;
	private int idRuolo;
	private int idImpiegato;
	
	public Storico(int id, Date dataInizio, Date dataFine, int idRuolo, int idImpiegato) {
		
		this.id = id;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.idRuolo = idRuolo;
		this.idImpiegato = idImpiegato;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public int getIdRuolo() {
		return idRuolo;
	}
	public void setIdRuolo(int idRuolo) {
		this.idRuolo = idRuolo;
	}
	public int getIdImpiegato() {
		return idImpiegato;
	}
	public void setIdImpiegato(int idImpiegato) {
		this.idImpiegato = idImpiegato;
	}
	
	
	
	
}
