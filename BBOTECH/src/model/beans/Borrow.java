package model.beans;

public class Borrow {
	
	private String User;
	private String idBook;
	private String isBorrow;
	
	public String getIsBorrow() {
		return isBorrow;
	}

	public void setIsBorrow(String isBorrow) {
		this.isBorrow = isBorrow;
	}

	public Borrow(String user, String idBook) {
		super();
		User = user;
		this.idBook = idBook;
		this.isBorrow = "false";
	}

	/*public Borrow(String user, String idBook) {
		super();
		this.User = user;
		this.idBook = idBook;
	} */
	
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	
	@Override
	public String toString() {
		return "Borrow [User=" + User + ", idBook=" + idBook + ", isBorrow=" + isBorrow + "]";
	}
}
