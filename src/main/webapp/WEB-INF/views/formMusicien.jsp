<%@ include file="/WEB-INF/views/header.jsp" %>
	<h1>Formulaire d'inscription</h1>
	<form action="form-musicien" method="post">
	<div class="form-row">
	    <div class="form-group col-md-3">
	        <label for="nom">Nom</label>
	        <input class="form-control" type="text" id="nom" name="nom_musicien" placeholder="Nom">
	        <span class="erreur">${erreurs['nom']}</span>
	    </div>
	    <div class="form-group col-md-3">
	        <label for="prenom">Prénom</label>
	        <input class="form-control" type="text" id="prenom" name="prenom_musicien" placeholder="Prénom">
	    </div>	
	</div>
	<div class="form-row">
	    <div class="form-group col-md-3">
		    <label for="password">Mot de passe</label>
		    <input  class="form-control" type="password" id="password" name="password_musicien" placeholder="Mot de passe">
	  	</div>
	  	<div class="form-group col-md-3">
		    <label for="confirmation">Confirmer le mot de passe</label>
		    <input  class="form-control" type="password" id="confirmation" name="confirmation_password_musicien" placeholder="Mot de passe">
	  	</div>
  	</div>
	<div class="form-row">
		<div class="form-group col-md-1">
	        <label for="numero">Numero</label>
	        <input class="form-control" type="text" id="numero" name="numero_musicien" placeholder="1234B"></input>
	    </div>
	    <div class="form-group col-md-5">
	        <label for="rue">Rue</label>
	        <input class="form-control" type="text" id="rue" name="rue_musicien" placeholder="Rue"></input>
		</div>
	</div>
	    <div class="form-row">
	    	<div class="form-group col-md-2">
		        <label for="code-postal">Code Postal</label>
		        <input class="form-control" type="text" id="code-postal" name="code-postal_musicien" placeholder="12345"></input>
		    </div>
		    <div class="form-group col-md-4">
		        <label for="ville">Ville</label>
		        <input class="form-control" type="text" id="ville" name="ville_musicien" placeholder="Ville"></input>
		    </div>
	    </div>
	<div class="form-row">
	    <div class="form-group col-md-2">
	        <label for="telephone">Téléphone</label>
	        <input class="form-control" type="tel" id="telephone" name="telephone_musicien" placeholder="1234567890"></input>
	    </div>
	    <div class="form-group col-md-4">
	        <label for="mail">e-mail&nbsp;</label>
	        <input class="form-control" type="email" id="mail" name="mail_musicien" placeholder="azerty@mail.com">
	    </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-6">
	        <label for="instrument">Instrument joué</label>
	        <input class="form-control" type="text" id="instrument" name="instrument_musicien" placeholder="Instrument"></input>
	    </div>
	</div>
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">S'enregistrer</button>
    </div>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>