<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Formulaire d'inscription musicien</h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
</c:if>
<form action="form-musicien" method="post">
<div class="form-row">
    <div class="form-group col-md-3">
        <label for="nom">Nom</label>
        <input class="form-control" type="text" id="nom" name="nom_musicien" placeholder="Nom" value="<c:out value="${musicien.nom}"/>"/>
        <span class="erreur">${form.erreurs['nom_musicien']}</span>
    </div>
    <div class="form-group col-md-3">
        <label for="prenom">Prénom</label>
        <input class="form-control" type="text" id="prenom" name="prenom_musicien" placeholder="Prénom" value="<c:out value="${musicien.prenom}"/>"/>
        <span class="erreur">${form.erreurs['prenom_musicien']}</span>
    </div>	
</div>
<div class="form-row">
    <div class="form-group col-md-3">
	    <label for="password">Mot de passe</label>
	    <input  class="form-control" type="password" id="password" name="password_musicien" placeholder="Mot de passe">
	    <span class="erreur">${form.erreurs['password_musicien']}</span>
  	</div>
  	<div class="form-group col-md-3">
	    <label for="confirmation">Confirmer le mot de passe</label>
	    <input  class="form-control" type="password" id="confirmation" name="confirmation_password_musicien" placeholder="Mot de passe">
	    <span class="erreur">${form.erreurs['confirmation_password_musicien']}</span>
  	</div>
</div>
<div class="form-row">
	<div class="form-group col-md-1">
        <label for="numero">Numero</label>
        <input class="form-control" type="text" id="numero" name="numero_musicien" placeholder="1234B" value="<c:out value="${adresse.numero}"/>"/>
        
    </div>
    <div class="form-group col-md-5">
        <label for="rue">Rue</label>
        <input class="form-control" type="text" id="rue" name="rue_musicien" placeholder="Rue" value="<c:out value="${adresse.rue}"/>"/>
        
	</div>
</div>
<div class="form-row">
	<div class="form-group col-md-2">
     <label for="code-postal">Code Postal</label>
     <input class="form-control" type="text" id="code-postal" name="code-postal_musicien" placeholder="12345" value="<c:out value="${adresse.codePostal}"/>"/>
     
 </div>
 <div class="form-group col-md-4">
     <label for="ville">Ville</label>
     <input class="form-control" type="text" id="ville" name="ville_musicien" placeholder="Ville" value="<c:out value="${adresse.ville}"/>"/>
     
 </div>
</div>
<div class="form-row">
    <div class="form-group col-md-2">
        <label for="telephone">Téléphone</label>
        <input class="form-control" type="tel" id="telephone" name="telephone_musicien" placeholder="1234567890" value="<c:out value="${musicien.telephone}"/>"/>
        
    </div>
    <div class="form-group col-md-4">
        <label for="mail">e-mail&nbsp;</label>
        <input class="form-control" type="email" id="mail" name="mail_musicien" placeholder="azerty@mail.com" value="<c:out value="${musicien.email}"/>"/>
        <span class="erreur">${form.erreurs['mail_musicien']}</span>
    </div>
</div>
<div class="form-row">
    <div class="form-group col-md-6">
        <label for="instrument">Instrument joué</label>
        <input class="form-control" type="text" id="instrument" name="instrument_musicien" placeholder="Instrument" value="<c:out value="${musicien.instrument}"/>"/>
    </div>
</div>
<div class="form-group">
	<button type="submit" class="btn btn-primary">S'enregistrer</button>
</div>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>