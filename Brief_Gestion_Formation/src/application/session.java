package application;

public class session {

	int id_s ;
	String code, libellé ;
	
	public session(int id_s, String code, String libellé) {
		this.id_s = id_s;
		this.code = code;
		this.libellé = libellé;
		
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

	public String getLibellé() {
		return libellé;
	}

	public void setLibellé(String libellé) {
		this.libellé = libellé;
	}

	
}
