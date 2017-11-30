<%@include file="header.jsp" %>

<div> 

  <%
    		//@SuppressWarnings("unchecked");
    		ArrayList<String> searchResult = (ArrayList<String>) request.getSession().getAttribute("userDemand");
    		System.out.println(searchResult.isEmpty());
    		%>
    		
    		
<table class="table table-hover">
    	    <thead>
    	      <tr>
    	        <th>Couverture</th>
    	        <th>Titre</th>
    	        <th>Auteur</th>
    	        <th>Nbr Exemplaire</th>
    	        <th>Action</th>
    	      </tr>
    	    </thead>
    	    <tbody> 
	    	    	<tr> ${sessionScope.role}
	    	    		<td> <img alt="cover" src="img/lifeanimated-216x300.jpg" > </td>
	  	        <td style="vertical-align: center;"> ${bookTitle}</td>
	  	        <td style="vertical-align: center;"> ${bookAuthor}</td>
	  	        <td style="vertical-align: center;"> ${nbrExemplaire}</td>
	  	        
	  	        <% if (session.getAttribute("role").equals("bibliothecaire")) { %>
	    	        <td style="vertical-align: center;"> 
	    	        		<form action= "Controller" method="POST">  
	    	        			<input type='hidden' name='form' value="addBookExemplaire" />	
	    	        			<input type='hidden' name='bookTitle' value="${bookTitle}" />
	    	        			<input type='hidden' name='bookAuthor' value="${bookAuthor}" />
	    	        			<input type='hidden' name='nbrExemplaire' value="${nbrExemplaire}" />
	  	        			<input type='hidden' name='idBook' value="${bookCode}" />
			 			<input type='submit' value='Ajouter exemplaire' />
  	        			</form>
  	        			<form action= "Controller" method="POST">  
	    	        			<input type='hidden' name='form' value="deleteBookExemplaire" />	
	    	        			<input type='hidden' name='bookTitle' value="${bookTitle}" />
	    	        			<input type='hidden' name='bookAuthor' value="${bookAuthor}" />
	    	        			<input type='hidden' name='nbrExemplaire' value="${nbrExemplaire}" />
	  	        			<input type='hidden' name='idBook' value="${bookCode}" />
			 			<input type='submit' value='Supprimer exemplaire' />
  	        			</form>
  	        			</br>
  	        			 <% if (!searchResult.isEmpty()) {  
  	        			 		for(int a=0; a<searchResult.size();a++) { %>
  	        			<form action= "Controller" method="POST">  
	    	        			<input type='hidden' name='form' value="borrowUser" />
	    	        			<p> <% out.println(searchResult.get(a) + "<br/>");%> 
	    	        			<input type='hidden' name='login' value= "<%=searchResult.get(a)%>" />
	  	        			<input type='hidden' name='idBook' value="${bookCode}" />
			 			<input type='submit' value="Valider l'emprunt" />
	  	        			 </p>
	    	        			
  	        			</form>
  	        			 <% 		}
	        			 	}%>
        			</td>
	    	        <% } %>
	    	        <% if (session.getAttribute("role").equals("adherent") && session.getAttribute("isBorrow").toString().equals("false") ) { %>
	    	        <td style="vertical-align: center;"> 
	    	        		<form action= "Controller" method="POST">  	
	    	        			<input type='hidden' name='form' value="borrowBook" />
	  	        			<input type='hidden' name="idBook" value="${bookCode}" />
			 			<input type='submit' value='Reserver' />
  	        			</form>
        			</td>
	    	        <% }else if(session.getAttribute("role").equals("adherent") && session.getAttribute("isBorrow").toString().equals("true") ) { %>
	    	        <td style="vertical-align: center;"> 
	    	        		<form action= "Controller" method="POST">  	
	    	        			<input type='hidden' name='form' value="unBorrowBook" />
	  	        			<input type='hidden' name="idBook" value="${bookCode}" />
			 			<input type='submit' value='De-Reserver' />
  	        			</form>
        			</td>
        			<%} %>
	  		</tr>
    	    </tbody>
    	    
    	    </table>



</div>


<%@include file="footer.jsp" %>
