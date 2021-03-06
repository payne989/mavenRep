package dto;

public class ImpiegatoDTO {
	private Integer id;
	private String cf;
	private String nome;
	private String cognome;

	public ImpiegatoDTO(Integer id, String codFisc, String nome, String cognome) {
		this.id = id;
		this.cf = codFisc;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public ImpiegatoDTO() {}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodFisc() {
		return cf;
	}

	public void setCodFisc(String codFisc) {
		this.cf = codFisc;
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
		return " id " + id + "\n Nome " + nome + "\n Cognome " + cognome + "\n Codice Fiscale " + cf;
	}

}
