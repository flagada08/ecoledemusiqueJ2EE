<%@ include file="/WEB-INF/views/header.jsp" %>
	<h1>Musicien</h1>
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
<%@ include file="/WEB-INF/views/footer.jsp" %>