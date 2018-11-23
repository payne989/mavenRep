package response;

import java.util.ArrayList;
import model.Movimento;

public class ResponseSelectMovimento extends ResponseBase {

	private static final long serialVersionUID = 1L;

	ArrayList<Movimento> list = new ArrayList<Movimento>();

	public ArrayList<Movimento> getList() {
		return list;
	}

	public void setList(ArrayList<Movimento> list) {
		this.list = list;
	}

}
