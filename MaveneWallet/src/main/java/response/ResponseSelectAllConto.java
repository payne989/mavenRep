package response;

import java.util.ArrayList;

import model.Conto;

public class ResponseSelectAllConto extends ResponseBase {

	private static final long serialVersionUID = 1L;

	ArrayList<Conto> list = new ArrayList<Conto>();

	public ArrayList<Conto> getList() {
		return list;
	}

	public void setList(ArrayList<Conto> list) {
		this.list = list;
	}

}
