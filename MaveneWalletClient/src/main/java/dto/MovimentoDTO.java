package dto;

import java.util.Date;


public class MovimentoDTO {

	private int idMov;
	private int idTtipo;
	private int idConto;
	private double importo;
	private Date data;

	public MovimentoDTO(int idMov, int idTipo, int idConto, double importo, Date data) {

		this.idMov = idMov;
		this.idTtipo = idTipo;
		this.idConto = idConto;
		this.importo = importo;
		this.data = data;
	}

	public MovimentoDTO() {
	}

	public int getIdmov() {
		return idMov;
	}

	public void setIdmov(int idMov) {
		this.idMov = idMov;
	}

	public int getIdtipo() {
		return idTtipo;
	}

	public void setIdtipo(int idTipo) {
		this.idTtipo = idTipo;
	}

	public int getIdconto() {
		return idConto;
	}

	public void setIdconto(int idConto) {
		this.idConto = idConto;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
