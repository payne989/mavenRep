package dto;



import java.util.Date;



public class ContoDTO {

	private int id;
	private double saldo;
	private Date dataIn;
	private int idImp;

	public ContoDTO(int id, int saldo, Date dataIn, int idImp) {

		this.id = id;
		this.saldo = saldo;
		this.dataIn = dataIn;
		this.idImp = idImp;

	}

	public ContoDTO() {
	}

	public int getIdconto() {
		return id;
	}

	public void setIdconto(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getDatain() {
		return dataIn;
	}

	public void setDatain(Date date) {
		this.dataIn = date;
	}

	public int getIdimp() {
		return idImp;
	}

	public void setIdimp(int idImp) {
		this.idImp = idImp;
	}

}
