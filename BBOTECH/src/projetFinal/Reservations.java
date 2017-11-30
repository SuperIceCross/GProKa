package projetFinal;
import java.util.ArrayList;

import model.beans.*;

public class Reservations {

	public ArrayList <Borrow> aBorrow;

	public Reservations(ArrayList<Borrow> aBorrow) {
		super();
		this.aBorrow = aBorrow;
	}
	
	public Reservations() {
		this.aBorrow = new ArrayList<Borrow>();
	}

	@Override
	public String toString() {
		return "Reservations [aBorrow=" + aBorrow + "]";
	}

	public ArrayList<Borrow> getaBorrow() {
		return aBorrow;
	}

	public ArrayList<Borrow> getaBorrow(Borrow borrow) {
		
		for(int i = aBorrow.size() - 1 ; i >= 0 ; i--) {
		//for(int i=0; i< aBorrow.size(); i++) {
			if(borrow.getIdBook().equals(aBorrow.get(i).getIdBook()) && borrow.getUser().equals(aBorrow.get(i).getUser())) {
				aBorrow.remove(i);
				System.out.println("Vous avez bien supprimé votre réservation");
			}
		}
		
		return aBorrow;
	}
	
	public void setaBorrow(ArrayList<Borrow> aBorrow) {
		this.aBorrow = aBorrow;
	}
	public String isUserBorrow (String code, String user) {
		System.out.println(code);
		System.out.println(user);
		System.out.println("--------------");
		
		//ArrayList <Borrow> listClone = new ArrayList<Borrow>(); 
		
		if (!this.aBorrow.isEmpty()) {
			for (Borrow string : this.aBorrow) {
	            if(string.getUser().equals(user) && string.getIdBook().equals(code)) 
	            		/* Affichage ou non d'un livre sans exemplaire, 
	            		 * retirer le comentaire
	            		 * && (string.getNbrExemplaire() > 0)*/{
	                return "true";
	            }
	        }
		}
        return "false";
	}
}
