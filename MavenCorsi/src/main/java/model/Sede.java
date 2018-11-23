package model;

public class Sede {

	private int id;
	private String nomeSede;
	private String indirizzo;
	private String citta;

	public Sede(int id, String nomeSede, String indirizzo, String citta) {
		super();
		this.id = id;
		this.nomeSede = nomeSede;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}

	public Sede() {
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
