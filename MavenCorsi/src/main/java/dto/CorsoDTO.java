package dto;

import java.io.Serializable;

public class CorsoDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;

	public CorsoDTO(int id, String nome) {

		this.id = id;
		this.nome = nome;
	}

	public CorsoDTO() {
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

}
