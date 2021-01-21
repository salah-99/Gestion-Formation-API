package application;

public class employe {
	String matricule, ville, flname, username;
	
	public employe(String matricule, String ville, String flname, String username) {
		super();
		this.matricule = matricule;
		this.ville = ville;
		this.flname = flname;
		this.username = username;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getFlname() {
		return flname;
	}

	public void setFlname(String flname) {
		this.flname = flname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
