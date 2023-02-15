<%@ include file="/WEB-INF/views/header.jsp" %>
<h1><i class="fa-brands fa-java"></i> Profil musicien </h1>
<c:if test="${!empty sessionScope.sessionMusicien}">
	<p class="succes">Vous êtes connecté(e) avec l'adresse : <c:out value="${sessionScope.sessionMusicien.email}"/></p>
	<p><Strong>Cookie : </Strong><c:out value="${ token }"/></p>
</c:if>
<div class="card text-white bg-secondary mb-3" style="max-width: 28rem;">
	<div class="card-header">Profil</div>
  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/1.jpg" class="d-block" alt="..." height="300">
    </div>
    <div class="carousel-item">
      <img src="images/2.jpg" class="d-block" alt="..." height="300">
    </div>
    <div class="carousel-item">
      <img src="images/3.jpg" class="d-block" alt="..." height="300">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  <div class="card-body">
	  <section>
		<h2>Identité</h2>
		<p>
			<Strong>ID : </Strong><c:out value="${ sessionScope.sessionMusicien.id }"/>
			<Strong>Nom : </Strong><c:out value="${ sessionScope.sessionMusicien.nom }"/>
			<Strong>Prénom : </Strong><c:out value="${ sessionScope.sessionMusicien.prenom }"/>
		</p>			
	   	<h2>Contact</h2>
		<p>
			<Strong>Adresse : </Strong><c:out value="${ sessionScope.sessionMusicien.numero } 
			${ sessionScope.sessionMusicien.rue }
			${ sessionScope.sessionMusicien.codePostal } 
			${ sessionScope.sessionMusicien.ville }"/>
		</p>
		<p>
			<Strong>Téléphone : </Strong><c:out value="${ sessionScope.sessionMusicien.telephone }"/>
		</p>
		<p>
			<Strong>e-mail : </Strong><c:out value="${ sessionScope.sessionMusicien.email }"/>
		</p>
		<h2>Instrument(s)</h2>
		<p>
			<Strong>Instrument(s) joué(s) : </Strong><c:out value="${ sessionScope.sessionMusicien.instrument }"/>
		</p>
	</section>
  </div>
</div>
<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
<%@ include file="/WEB-INF/views/footer.jsp" %>