<%@ include file="/WEB-INF/views/header.jsp" %>
	<h1>Musicien</h1>
	<section>
		<div>
			Nom : <c:out value="${ sessionScope.sessionMusicien.nom }"/>
		</div>
		<div>
			Pr�nom : ${ sessionScope.sessionMusicien.prenom }
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
			T�l�phone : ${ sessionScope.sessionMusicien.telephone }
		</div>
		<div>
			e-mail : ${ sessionScope.sessionMusicien.email }
		</div>
		<div>
			Instrument jou� : ${ sessionScope.sessionMusicien.instrument }
		</div>
	</section>
		<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
		<c:if test="${!empty sessionScope.sessionMusicien}">
  			<p class="succes">Vous �tes connect�(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
		</c:if>
<%@ include file="/WEB-INF/views/footer.jsp" %>