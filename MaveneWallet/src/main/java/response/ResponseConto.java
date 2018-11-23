package response;

import model.Conto;

public class ResponseConto extends ResponseBase {

	private static final long serialVersionUID = 1L;
	private Conto co;

	public Conto getCo() {
		return co;
	}

	public void setCo(Conto co) {
		this.co = co;
	}

}
