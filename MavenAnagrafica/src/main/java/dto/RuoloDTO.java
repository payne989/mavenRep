package dto;

public class RuoloDTO {

	private int id;
	private String nomeRuolo;
	private double stipendio;

	public RuoloDTO(int id, String nomeRuolo, double stipendio) {

		this.id = id;
		this.nomeRuolo = nomeRuolo;
		this.stipendio = stipendio;

	}

	public RuoloDTO() {
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


	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double d) {
		this.stipendio = d;
	}
	@Override
	public String toString() {
		return " id " + id + "\n Ruolo " + nomeRuolo + "\n Stipendio " + stipendio;
	}
}