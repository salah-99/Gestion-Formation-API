package application;

public class session {

	int id_s ;
	String code, libell� ;
	
	public session(int id_s, String code, String libell�) {
		this.id_s = id_s;
		this.code = code;
		this.libell� = libell�;
		
	}

	public int getId_s() {
		return id_s;
	}

	public void setId_s(int id_s) {
		this.id_s = id_s;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibell�() {
		return libell�;
	}

	public void setLibell�(String libell�) {
		this.libell� = libell�;
	}

	
}
