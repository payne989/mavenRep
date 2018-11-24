package dto;

public class ImpiegatoDTO {
	private Integer id;
	private String codFisc;
	private String nome;
	private String cognome;

	public ImpiegatoDTO(Integer id, String codFisc, String nome, String cognome) {
		this.id = id;
		this.codFisc = codFisc;
		this.nome = nome;
		this.cognome = cognome;
	}//porcaccio quel lurido

	public ImpiegatoDTO() {
	}

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
}