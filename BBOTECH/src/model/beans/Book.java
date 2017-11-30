package model.beans;

public class Book {

	public Book() {
		super();
	}
	private String title;
	private String author;
	private String code;
	private int nbrExemplaire;
	private int nbrReservation;   
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Book(String title, String author,String code,int nbrExemplaire, int nbrReservation) {
		super();
		this.title = title;
		this.author = author;
		this.code = code; 
		this.nbrExemplaire = nbrExemplaire;
		this.nbrReservation = nbrReservation;
	}

	public int getNbrExemplaire() {
		return nbrExemplaire;
	}

	public void setNbrExemplaire(int nbrExemplaire) {
		this.nbrExemplaire = nbrExemplaire;
	}

	public int getnbrReservation() {
		return nbrReservation;
	}

	public void setnbrReservation(int nbrReservation) {
		this.nbrReservation = nbrReservation;
		System.out.println(this.nbrReservation);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", code=" + code + ", nbrExemplaire=" + nbrExemplaire
				+ ", nbrReservation=" + nbrReservation + "]";
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
