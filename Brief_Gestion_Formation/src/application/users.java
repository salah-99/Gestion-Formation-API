package application;

public class users {
	
	int id_f ;
	String code, libell� ,description;
	
	public users(int id_f, String code, String libell�, String description) {
		super();
		this.id_f = id_f;
		this.code = code;
		this.libell� = libell�;
		this.description = description;
	}

	public int getId_f() {
		return id_f;
	}

	public void setId_f(int id_f) {
		this.id_f = id_f;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
