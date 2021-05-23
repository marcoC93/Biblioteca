package Model;

import Login;

public class Amministratore  extends Login{

	private String code;

	public Amministratore() {}

	public Amministratore(String username, String password,String code) {
		
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	

}
