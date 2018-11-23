package model;



import javax.xml.datatype.XMLGregorianCalendar;

public class Conto {

	private int idConto;
	private double saldo;
	private XMLGregorianCalendar datain;
	private int idImp;

	public Conto(int idConto, int saldo, XMLGregorianCalendar dataIn, int idImp) {

		this.idConto = idConto;
		this.saldo = saldo;
		this.datain = dataIn;
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

	public XMLGregorianCalendar getDatain() {
		return datain;
	}

	public void setDatain(XMLGregorianCalendar date) {
		this.datain = date;
	}

	public int getIdimp() {
		return idImp;
	}

	public void setIdimp(int idImp) {
		this.idImp = idImp;
	}

}
