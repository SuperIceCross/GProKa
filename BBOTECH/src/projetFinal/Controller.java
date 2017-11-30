package projetFinal;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.beans.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public static Bibliotheque lib;
	public static Book livre1;
	public static Book livre2;
	public static Borrow userBorrow;
	public static Reservations reservations;
	public static ArrayList<String> userDemand;

    public Controller() {
        super();
        
      ///Recuperer la liste des livres dans la BDD
      		livre1 = new Book("La vie","Yacine","1",1,0);
      		livre2 = new Book("La mort","Simon","0",0,0);
      		userDemand = new ArrayList<String>();
      		lib = new Bibliotheque();
      		lib.addBook(livre2);
      		lib.addBook(livre1);
      		reservations = new Reservations();
  		//Fin de la recuperation 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String bookTitle = "";
		String bookAuthor = "";
		String bookCode = ""; */
		
		///Recuperer la liste des livres dans la BDD
		/*Book livre1 = new Book("La vie","Yacine","1",1,0);
		Book livre2 = new Book("La mort","Simon","0",0,0);
		Bibliotheque lib = new Bibliotheque();
		lib.addBook(livre2);
		lib.addBook(livre1); */
		//Fin de la recuperation 
		//System.out.println(lib.theBooks.size());

		System.out.println(reservations.getaBorrow().toString()); 
		String infoBook = request.getParameter("infoBook").toString();
		ArrayList<Borrow> aBorrow = reservations.getaBorrow();
		for (int a=0;a<aBorrow.size();a++) {
			if (aBorrow.get(a).getIdBook().equals(infoBook) && aBorrow.get(a).getUser().equals(request.getSession().getAttribute("login"))) {
				request.getSession().setAttribute("isBorrow",true);
			}
		}
		userDemand.removeAll(userDemand);
		for(int a=0; a<reservations.getaBorrow().size();a++) {
			System.out.println(reservations.getaBorrow().size());
			System.out.println("Nombre de demande");
			//if(aBorrow.get(a).getIdBook().equals(infoBook) && aBorrow.get(a).getUser().equals(request.getSession().getAttribute("login"))){
			if(aBorrow.get(a).getIdBook().equals(infoBook) ){
				userDemand.add(aBorrow.get(a).getUser());
				System.out.println("Ajout de :");
			}
		}
		request.getSession().setAttribute("userDemand", userDemand);
		
		for(int index = 0; index < lib.theBooks.size(); index++) {	
			String code = lib.theBooks.get(index).getCode().toString();
			if (code.equals(infoBook)) {
				// Essaye de mettre l'objet et de recuperer les attribut dans le JSP Stp 
				request.setAttribute("bookTitle", lib.theBooks.get(index).getTitle());
				request.setAttribute("bookAuthor", lib.theBooks.get(index).getAuthor());
				request.setAttribute("nbrExemplaire", lib.theBooks.get(index).getNbrExemplaire());
				request.setAttribute("bookCode", lib.theBooks.get(index).getCode());
				request.getRequestDispatcher("bookPage.jsp").forward(request, response);
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		// Check reservation, si elle est deja faite ou pas pour instancier session.setAttribute("isBorrow","false");
		if (reservations.getaBorrow().equals("true")) {
			session.setAttribute("isBorrow", true);
		}else {
			session.setAttribute("isBorrow", false);
		}
		String formulaire = request.getParameter("form");
		System.out.println(formulaire);
		
		
		if ( formulaire.equals("login")) {	
			
			// connection BDD recuperer les inscrits 
			Users aUser = new Users();
		
			User User1 = new User("Yacine", "adherent", "test123");
			User User3 = new User("test", "adherent", "test");
			User User2 = new User("Simon", "bibliothecaire", "123test");
			aUser.addUser(User3);
			aUser.addUser(User1);
			aUser.addUser(User2);
			//Fin de la recuperation 
			
			
			ArrayList<User> allUser = new ArrayList<User>();
			allUser = aUser.getUsers();
			String login = request.getParameter( "login" );
			String password = request.getParameter( "password" );
			
			if (login.equals("") && password.equals("")) {
				String message = "Veuillez remplir les champs.";
				request.setAttribute("message", message);
				request.setAttribute("userDemand", "");
				request.getRequestDispatcher("Index.jsp").forward(request, response);
			}
			
			//If login est une personne de la BDD alors 
			
			for(User x: allUser) {
				System.out.println(x.getLogin());
			   if (x.getLogin().equals(login) && x.getMdp().equals(password)) {
				   request.getSession().removeAttribute("role");
				   
				   session.setAttribute("login", login);
				   session.setAttribute("password",password );
				   session.setAttribute("role",x.getRole().toString());
				   System.out.println(session.getAttribute("role"));
				   System.out.println(x.getRole().toString());
				   request.getRequestDispatcher("content.jsp").forward(request, response);
			   }	
			}
			
			String message = "Ce compte n'est pas connu par la bibliothèque.";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
			// fin du IF 
		}
		
		if ( formulaire.equals("search")) {
			// connection BDD récuperer les livres 
			String title = request.getParameter( "title" );
			String author = request.getParameter( "author" );
			
			ArrayList<Book> resultSearch = lib.searchBook(title,author);
			// Si il y a un resultat, ou si le resultat est nul 
			if (!resultSearch.isEmpty()) {
				session.setAttribute("resultSearch",resultSearch);
				request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
			}else {
				session.setAttribute("resultSearch","false");
				request.getRequestDispatcher("content.jsp").forward(request, response);
			}
		}
		
		if (formulaire.equals("borrowBook")) {
			
			userBorrow = new Borrow(session.getAttribute("login").toString(), request.getParameter("idBook"));
			reservations.aBorrow.add(userBorrow);
			System.out.println(request.getParameter("idBook"));
			
			
			ArrayList<Book> resultSearch = lib.searchBook(request.getParameter("idBook"));
			String isBorrow = reservations.isUserBorrow(request.getParameter("idBook").toString(),session.getAttribute("login").toString());
			System.out.println(isBorrow);
			System.out.println("__________");
			//session.setAttribute("isBorrow", isBorrow);
			// Si il y a un resultat, ou si le resultat est nul 
			
			if (!resultSearch.isEmpty()) {
				resultSearch.get(0).setnbrReservation(resultSearch.get(0).getnbrReservation()+1);
				request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
			}else {
				session.setAttribute("resultSearch","false");
				request.getRequestDispatcher("content.jsp").forward(request, response);
			}
			request.getRequestDispatcher("bookPage.jsp?infoBook="+request.getParameter("infoBook")).forward(request, response);
		}
		
		if (formulaire.equals("unBorrowBook")) {
			Borrow temp = new Borrow( session.getAttribute("login").toString(),request.getParameter("idBook"));
			reservations.getaBorrow(temp);
			ArrayList<Book> resultSearch = lib.searchBook(request.getParameter("idBook"));
			resultSearch.get(0).setnbrReservation(resultSearch.get(0).getnbrReservation()-1);
			request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
		}
		if (formulaire.equals("addBook")) {
			session.setAttribute("messageLivre","");
			String title = request.getParameter( "title" ).toString();
			String author = request.getParameter( "author" ).toString();
			String nbExempl = request.getParameter( "nbExempl" ).toString();
			
			if (!title.equals("") && !author.equals("") && !nbExempl.equals("")) {
				lib.addBook(new Book(title,author,String.valueOf(lib.theBooks.size()+1),Integer.valueOf(nbExempl),0));
			} else {
				session.setAttribute("messageLivre", "Vous devez entrez toute les informations pour ajouter un livre.");
			}
			request.getRequestDispatcher("content.jsp").forward(request, response);
		}
		
		if (formulaire.equals("addBookExemplaire")) {
			
			for (int k=0; k<lib.theBooks.size();k++) {
				if (lib.theBooks.get(k).getCode().toString().equals(request.getParameter("idBook"))) {
					lib.theBooks.get(k).setNbrExemplaire(lib.theBooks.get(k).getNbrExemplaire()+1);
					request.setAttribute("nbrExemplaire", lib.theBooks.get(k).getNbrExemplaire());
					System.out.println("Exemplaire ajouter");
				}
			}
			
			request.setAttribute("bookTitle", request.getParameter("bookTitle"));
			request.setAttribute("bookAuthor", request.getParameter("bookAuthor"));
			request.setAttribute("bookCode", request.getParameter("idBook"));
			request.getRequestDispatcher("bookPage.jsp?infoBook="+request.getParameter("idBook")).forward(request, response);
		}
		
		if (formulaire.equals("deleteBookExemplaire")) {
			int newExemplaire = 0;
			for (int k=0; k<lib.theBooks.size();k++) {
				if (lib.theBooks.get(k).getCode().toString().equals(request.getParameter("idBook")) && (lib.theBooks.get(k).getNbrExemplaire()>0)) {
					lib.theBooks.get(k).setNbrExemplaire(lib.theBooks.get(k).getNbrExemplaire()-1);
					request.setAttribute("nbrExemplaire", lib.theBooks.get(k).getNbrExemplaire());
					System.out.println("Exemplaire supprimer");
				}else if (lib.theBooks.get(k).getCode().toString().equals(request.getParameter("idBook")) && (lib.theBooks.get(k).getNbrExemplaire()==0)){
					lib.theBooks.get(k).setNbrExemplaire(0);
					request.setAttribute("nbrExemplaire", 0);
					System.out.println("Exemplaire supprimer");
				}
			}
			
			request.setAttribute("bookTitle", request.getParameter("bookTitle"));
			request.setAttribute("bookAuthor", request.getParameter("bookAuthor"));
			request.setAttribute("bookCode", request.getParameter("idBook"));
			request.getRequestDispatcher("bookPage.jsp?infoBook="+request.getParameter("idBook")).forward(request, response);
		} 
		
		
		if (formulaire.equals("disconnect")) {
			session.invalidate();
			request.getRequestDispatcher("Index.jsp").forward(request, response);
		}
		if (formulaire.equals("anonymous")) {
			System.out.println("test");
			session.setAttribute("role","anonymous");
			request.getRequestDispatcher("content.jsp").forward(request, response);
		}

		if (formulaire.equals("borrowUser")) {
			
			request.getRequestDispatcher("content.jsp").forward(request, response);
		}
		
		
		
	}
}
