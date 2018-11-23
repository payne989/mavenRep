package model;

public class Ruolo {

	private int id;
	private String nomeRuolo;
	private int stipendio;

	public Ruolo(int id, String nomeRuolo, int stipendio) {

		this.id = id;
		this.nomeRuolo = nomeRuolo;
		this.stipendio = stipendio;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRuolo() {
		return nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	@Override
	public String toString() {
		return " id " + id + "\n Ruolo " + nomeRuolo + "\n Stipendio " + stipendio;
	}
}