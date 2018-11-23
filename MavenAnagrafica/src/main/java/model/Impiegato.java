package model;

public class Impiegato {
	private Integer id;
	private String codFisc;
	private String nome;
	private String cognome;

	public Impiegato(Integer id, String codFisc, String nome, String cognome) {
		this.id = id;
		this.codFisc = codFisc;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Impiegato() {}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodFisc() {
		return codFisc;
	}

	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return " id " + id + "\n Nome " + nome + "\n Cognome " + cognome + "\n Codice Fiscale " + codFisc;
	}

}
