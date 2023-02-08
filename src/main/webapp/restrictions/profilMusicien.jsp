<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Profil musicien</h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
</c:if>
<section>
	<div>
		Nom : <c:out value="${ musicien.nom }"/>
	</div>
	<div>
		Prénom : ${ musicien.prenom }
	</div>
	<fieldset>
    	<legend>Adresse</legend>
		<div>
			${ adresse.numero } ${ adresse.rue }
		</div>
		<div>
			${ adresse.codePostal } ${ adresse.ville }
		</div>
	</fieldset>
	<div>
		Téléphone : ${ musicien.telephone }
	</div>
	<div>
		e-mail : ${ musicien.email }
	</div>
	<div>
		Instrument joué : ${ musicien.instrument }
	</div>
</section>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
<%@ include file="/WEB-INF/views/footer.jsp" %>