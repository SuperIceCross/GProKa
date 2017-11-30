
<%@include file="header.jsp" %>

<div>
 <h1>
  Bonjour, 
  <small class="text-muted">  ${sessionScope.login} </small> 
  
</h1>

	<form class = "form-horizontal" action='Controller' method = 'POST'>
		<div class = 'form-group' >
		 <input type='hidden' name='form' value='disconnect' />
		 <input type='submit' value='Deconnexion' />
		</div>
	</form>
	
	
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
	
	<% if(session.getAttribute("role").equals("bibliothecaire")) {%>
		<form class = "form-horizontal" action='Controller' method = 'POST'>
		<div class = 'form-group' >
		Titre: <input type='text' name='title' />
		Auteur: <input type='text' name='author' />
		Nombre d'exemplaires: <input type='text' name='nbExempl' />
		 <input type='hidden' name='form' value='addBook' />
		 <input type='submit' value='Ajouter un livre' />
		</div>
	</form>
	
	<% }%>
	${messageLivre}
</div>

	
<%@include file="footer.jsp" %>