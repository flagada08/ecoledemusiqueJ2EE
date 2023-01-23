<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Connexion</h1>
<form action="ServletLogin">
  <div class="form-group row">
    <div class="col-md-4">
	    <label for="email">Adresse e-mail</label>
	    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Entrer votre adresse mail">
	    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
	</div>
  </div>
  <div class="form-group row">
    <div class="col-md-4">
	    <label for="password">Mot de passe</label>
	    <input type="password" class="form-control" id="password" placeholder="Entrer votre mot de passe">
  	</div>
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="check">
    <label class="form-check-label" for="check">Rester connecté</label>
  </div>
  <button type="submit" class="btn btn-primary">Se connecter</button>
</form>
<%@ include file="/WEB-INF/views/footer.jsp" %>