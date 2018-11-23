package model;

public class Docente {

	private int id;
	private String nome;
	private String cognome;
	private String cf;

	public Docente(int id, String nome, String cognome, String cf) {

		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;

	}

	public Docente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

}
