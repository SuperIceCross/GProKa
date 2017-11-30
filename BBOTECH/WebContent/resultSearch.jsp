<%@include file="header.jsp" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.beans.Book"%>

<div>
 <h1>
  Bonjour, 
  <small class="text-muted">  ${sessionScope.login}</small>
</h1>

</div>
<div> 
<h5> Vous pouvez lancer une recherche : </br> </h5>

	<form class = "form-horizontal" action='Controller' method = 'POST'>
		<div class = 'form-group' >
		Titre: <input type='text' name='title' />
		Auteur: <input type='text' name='author' />
		 <input type='hidden' name='form' value='search' />
		 <input type='submit' value='Rechercher' />
		</div>
	</form>
</div>  
    <p> Voici le résultat de votre recherche : </p>
    
    <%
    		//@SuppressWarnings("unchecked");
    		ArrayList<Book> searchResult = (ArrayList<Book>) session.getAttribute( "resultSearch" ); %>
    
    		<table class="table table-hover">
    	    <thead>
    	      <tr>
    	        <th>Auteur</th>
    	        <th>Titre</th>
    	        <th>nbr Exemplaire</th>
    	        <th>nbr Réservation</th>
    	        <th>Action</th>
    	      </tr>
    	    </thead>
    	    <tbody>
<% 		for(int index = 0; index < searchResult.size() ; index ++){  %>
  	      <tr>
  	        <td><% out.println(searchResult.get(index).getAuthor()  + "<br/>");%></td>
  	        <td><% out.println(searchResult.get(index).getTitle()  + "<br/>"); %></td>
  	        <td><% out.println(searchResult.get(index).getNbrExemplaire()  + "<br/>"); %></td>
  	        <td><% out.println(searchResult.get(index).getnbrReservation()  + "<br/>"); %></td>
  	        
  	        <td> 
  	        		<form action= "Controller" method="GET">  	
  	        			<input type='hidden' name='infoBook' value="<%=searchResult.get(index).getCode()%>" />
		 			<input type='submit' value='Voir la fiche' />
  	        		</form>
  	      </tr>
	<% 	} %>
		</tbody>
	    </table> 

<%@include file="footer.jsp" %>

