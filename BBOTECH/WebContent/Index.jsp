
<%@include file="header.jsp" %>

<!--  <form action='execforms.jsp' method='POST' >        Previous exercice-->
	<!--<form class = "form-horizontal" action='Controller' method='POST'>
		<div class = 'form-group' >
		Login: <input type='text' name='login' />
		Password: <input type='password' name='password' />
		 <input type='hidden' name='form' value='login' />
		 <input type='submit' value='Connect' />
		</div>
	</form> -->


	<div class="container">
		<div class="row login_box">
		    <div class="col-md-12 col-xs-12" align="center">
	            <div class="line"><h3>12 : 30 AM</h3></div>
	            <div class="outter" ><img src="tcbr-round-fb.png" class="image-circle"/></div>   
	            <h1>Bienvenue</h1>
	            <span>Merci de rentrer vos identifiants</span>
		    </div>
	        <div class="col-md-6 col-xs-6 follow line" align="center">
	            <h3>
	                 Adherent <br/> <span>Chercher/Reserver un livre</span>
	            </h3>
	        </div>
	        <div class="col-md-6 col-xs-6 follow line" align="center">
	            <h3>
	                 Anonyme <br/> <span>Chercher un livre</span>
	            </h3>
	        </div>
	        
	        <div class="col-md-12 col-xs-12 login_control">
	        <form class = "form-horizontal" action='Controller' method='POST'>
	                <div class="control">
	                    <div class="label">Login</div>
	                    <input type='text' name='login' />
	                </div>
	                
	                <div class="control">
	                     <div class="label">Mot de passe</div>
	                     <input type='password' name='password' />
	                </div>
	                <div align="center">
	                 <input type='hidden' name='form' value='login' />
	                 <!--  <input type='submit' value='Connect' /> -->
	                     <button class="btn btn-orange">Connexion</button>
	                </div>
	                </form>
	                <form id="searchAnonymous" class = "form-horizontal" action='Controller' method='POST'>
					 <input type='hidden' name='form' value='anonymous' />
	                		Rechercher un livre : <input type='submit' value='Recherche anonyme' />
	                </form>
	                
	        			<p> ${message} </p>
	        </div> 
	        
	    </div>
	</div>
<%@include file="footer.jsp" %>