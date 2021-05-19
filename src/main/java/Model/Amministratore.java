package Model;

public class Amministratore  extends Utente{

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
