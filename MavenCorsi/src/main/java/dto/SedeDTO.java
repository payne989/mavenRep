package dto;

import java.io.Serializable;

public class SedeDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nomeSede;
	private String indirizzo;
	private String citta;

	public SedeDTO(int id, String nomeSede, String indirizzo, String citta) {
		super();
		this.id = id;
		this.nomeSede = nomeSede;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public SedeDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeSede() {
		return nomeSede;
	}

	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

}
