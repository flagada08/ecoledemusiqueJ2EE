<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Connexion</h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
</c:if>
<form action="<c:url value="login"/>" method="post">
  <div class="form-group row">
    <div class="col-md-4">
	    <label for="email">Adresse e-mail<span class="requis">*</span></label>
	    <input type="email" class="form-control" id="email" name="email_connexion" aria-describedby="emailHelp" placeholder="Entrer votre adresse mail" value="<c:out value="${musicien.email}"/>">
	    <span class="erreur">${form.erreurs['email_connexion']}</span>
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	</div>
  </div>
  <div class="form-group row">
    <div class="col-md-4">
	    <label for="password">Mot de passe<span class="requis">*</span></label>
	    <input type="password" class="form-control" id="password" name="password_connexion" placeholder="Entrer votre mot de passe" value="">
	    <span class="erreur">${form.erreurs['password_connexion']}</span>
  	</div>
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="keep" name="keep_connexion">
    <label class="form-check-label" for="keep">Rester connecté</label>
  </div>
  <button type="submit" class="btn btn-primary">Se connecter</button>
  <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>