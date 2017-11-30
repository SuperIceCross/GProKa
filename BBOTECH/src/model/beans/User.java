package model.beans;

public class User {

	private String Login;
	private String Role;
	private String Mdp;
	
	
	
	public User(String login, String role, String mdp) {
		super();
		Login = login;
		Role = role;
		Mdp = mdp;
	}

	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
}
