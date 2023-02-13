<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Profil musicien</h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous êtes connecté(e) avec l'adresse : <c:out value="${sessionScope.sessionMusicien.email}"/></p>
	<Strong>Cookie : </Strong><c:out value="${ token }"/>
</c:if>
<section>
	<h2>Identité</h2>
	<Strong>ID : </Strong><c:out value="${ sessionScope.sessionMusicien.id }"/>
	<div>
		<Strong>Nom : </Strong><c:out value="${ sessionScope.sessionMusicien.nom }"/>
	</div>
	<div>
		<Strong>Prénom : </Strong><c:out value="${ sessionScope.sessionMusicien.prenom }"/>
	</div>	
   	<h2>Contact</h2>
	<div>
		<Strong>Adresse : </Strong><c:out value="${ sessionScope.sessionMusicien.numero } 
		${ sessionScope.sessionMusicien.rue }
		${ sessionScope.sessionMusicien.codePostal } 
		${ sessionScope.sessionMusicien.ville }"/>
	</div>
	<div>
		<Strong>Téléphone : </Strong><c:out value="${ sessionScope.sessionMusicien.telephone }"/>
	</div>
	<div>
		<Strong>e-mail : </Strong><c:out value="${ sessionScope.sessionMusicien.email }"/>
	</div>
	<h2>Instrument(s)</h2>
	<div>
		<Strong>Instrument(s) joué(s) : </Strong><c:out value="${ sessionScope.sessionMusicien.instrument }"/>
	</div>
</section>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
<%@ include file="/WEB-INF/views/footer.jsp" %>