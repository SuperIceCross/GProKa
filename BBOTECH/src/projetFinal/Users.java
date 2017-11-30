package projetFinal;

import java.util.ArrayList;

import model.beans.User;

public class Users {

	private ArrayList<User> aUser;
	
	public Users() {
		aUser = new ArrayList<User>();
	}

	public Users(ArrayList<User> users) {
		super();
		aUser = users;
	}

	public void addUser(User user) {
		aUser.add(user);
	}
	public ArrayList<User> getUsers() {
		return aUser;
	}

	public void setUsers(ArrayList<User> users) {
		aUser = users;
	}

	@Override
	public String toString() {
		return "Users [Users=" + aUser + "]";
	}
}
