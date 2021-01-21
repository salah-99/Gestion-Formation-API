package application;

public class users {
	
	int id_f ;
	String code, libellé ,description;
	
	public users(int id_f, String code, String libellé, String description) {
		super();
		this.id_f = id_f;
		this.code = code;
		this.libellé = libellé;
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

	public String getLibellé() {
		return libellé;
	}

	public void setLibellé(String libellé) {
		this.libellé = libellé;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
