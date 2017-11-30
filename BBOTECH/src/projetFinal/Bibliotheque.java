package projetFinal;
import java.util.ArrayList;

import model.beans.Book;

public class Bibliotheque {

	public ArrayList<Book> theBooks;

	public Bibliotheque() 
	{
		super();
		theBooks = new ArrayList<Book>();
	}
	
	public void addBook(Book book) 
	{
		theBooks.add(book);
	}

	@Override
	public String toString() {
		return "Bibliotheque [theBooks=" + theBooks + "]";
	}
	
	public ArrayList<Book> searchBook(String title, String author) {
		ArrayList <Book> listClone = new ArrayList<Book>(); 
        for (Book book : this.theBooks) {
            if((book.getTitle().equals(title) || book.getAuthor().equals(author)) && (!title.equals("") || !author.equals("")) 
            		/* Affichage ou non d'un livre sans exemplaire, 
            		 * retirer le comentaire
            		 * && (string.getNbrExemplaire() > 0)*/){
                listClone.add(book);
            }
        }
        System.out.println(listClone);
        return listClone;
	}
	
	public ArrayList<Book> searchBook(String code) {
		ArrayList <Book> listClone = new ArrayList<Book>(); 
        for (Book string : this.theBooks) {
            if((string.getCode().equals(code)) 
            		/* Affichage ou non d'un livre sans exemplaire, 
            		 * retirer le comentaire
            		 * && (string.getNbrExemplaire() > 0)*/){
                listClone.add(string);
            }
        }
        System.out.println(listClone);
        return listClone;
	}
	
}
