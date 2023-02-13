<%@ include file="/WEB-INF/views/header.jsp" %>
<h1>Profil musicien</h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous �tes connect�(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
	<Strong>Cookie : </Strong><c:out value="${ token }"/>
</c:if>
<section>
	<h2>Identit�</h2>
	<c:out value="${ sessionScope.sessionMusicien.id }"/>
	<div>
		Nom : <c:out value="${ sessionScope.sessionMusicien.nom }"/>
	</div>
	<div>
		Pr�nom : ${ sessionScope.sessionMusicien.prenom }
	</div>	
   	<h2>Contact</h2>
	<div>
		${ sessionScope.sessionMusicien.numero } ${ sessionScope.sessionMusicien.rue }
		${ sessionScope.sessionMusicien.codePostal } ${ sessionScope.sessionMusicien.ville }
	</div>
	<div>
		T�l�phone : ${ sessionScope.sessionMusicien.telephone }
	</div>
	<div>
		e-mail : ${ sessionScope.sessionMusicien.email }
	</div>
	<h2>Instrument(s)</h2>
	<div>
		Instrument(s) jou�(s) : ${ sessionScope.sessionMusicien.instrument }
	</div>
</section>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
<%@ include file="/WEB-INF/views/footer.jsp" %>