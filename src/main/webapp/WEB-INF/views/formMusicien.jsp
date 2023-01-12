<%@ include file="/WEB-INF/views/header.jsp" %>
	<h1>Formulaire d'inscription</h1>
	<form action="form-musicien" method="post">
    <div class="form-group">
        <label for="nom">Nom</label>
        <input class="form-control" type="text" id="nom" name="nom_musicien" placeholder="Nom">
    </div>
    <div class="form-group">
        <label for="prenom">Prénom</label>
        <input class="form-control" type="text" id="prenom" name="prenom_musicien">
    </div>
    <fieldset>
    	<legend>Adresse</legend>
    	<div class="form-group">
	        <label for="numero">Numero</label>
	        <input class="form-control" type="text" id="numero" name="numero_musicien"></input>
	    </div>
	    <div class="form-group">
	        <label for="rue">Rue</label>
	        <input class="form-control" type="text" id="rue" name="rue_musicien"></input>
	    </div>
	    <div class="form-group">
	        <label for="code-postal">Code Postal</label>
	        <input class="form-control" type="text" id="rue" name="code-postal_musicien"></input>
	    </div>
	    <div class="form-group">
	        <label for="ville">Ville</label>
	        <input class="form-control" type="text" id="ville" name="ville_musicien"></input>
	    </div>
    </fieldset>
    <div class="form-group">
        <label for="telephone">Téléphone</label>
        <small>Format: 1234567890</small>
        <input class="form-control" type="tel" id="telephone" name="telephone_musicien"></input>
    </div>
    <div class="form-group">
        <label for="mail">e-mail&nbsp;</label>
        <input class="form-control" type="email" id="mail" name="mail_musicien">
    </div>
    <div class="form-group">
        <label for="instrument">Instrument joué</label>
        <input class="form-control" type="text" id="instrument" name="instrument_musicien"></input>
    </div>
    <div class="form-group">
    	<button type="submit" class="btn btn-primary">Enregistrer</button>
    </div>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>