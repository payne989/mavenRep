package dto;

import java.io.Serializable;

public class FrequenzeDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	int id;
	int idImp;
	int idEdiz;

	public FrequenzeDTO(int id, int idImp, int idEdiz) {

		this.id = id;
		this.idImp = idImp;
		this.idEdiz = idEdiz;

	}

	public FrequenzeDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdImp() {
		return idImp;
	}

	public void setIdImp(int idImp) {
		this.idImp = idImp;
	}

	public int getIdEdiz() {
		return idEdiz;
	}

	public void setIdEdiz(int idEdiz) {
		this.idEdiz = idEdiz;
	}

}
