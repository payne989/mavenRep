package model;



import java.util.Date;



public class Conto {

	private int idConto;
	private double saldo;
	private Date dataIn;
	private int idImp;

	public Conto(int idConto, int saldo, Date dataIn, int idImp) {

		this.idConto = idConto;
		this.saldo = saldo;
		this.dataIn = dataIn;
		this.idImp = idImp;

	}

	public Conto() {
	}

	public int getIdconto() {
		return idConto;
	}

	public void setIdconto(int idConto) {
		this.idConto = idConto;
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
