<%@ include file="/WEB-INF/views/header.jsp" %>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/1.jpg" class="d-block w-100" alt="..." height="560px">
    </div>
    <div class="carousel-item">
      <img src="images/2.jpg" class="d-block w-100" alt="..." height="560px">
    </div>
    <div class="carousel-item">
      <img src="images/3.jpg" class="d-block w-100" alt="..." height="560px">
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
<h1><i class="fa-brands fa-java"></i> École de musique </h1>
    <c:if test="${!empty sessionScope.sessionMusicien}">
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
	    <div class="card text-white bg-secondary mb-3" style="max-width: 38rem;">
		  <div class="card-header">Accueil</div>
		  <div class="card-body">
		    <h2 class="card-title">Liste des derniers musiciens enregistrés</h2>
		    <ul class="list-group list-group-flush">
				<c:forEach var="musicien" items="${ musiciens }">
					<li class="list-group-item bg-secondary"><c:out value="${ musicien.nom }"/> <c:out value="${ musicien.prenom }"/> | instrument joué : <c:out value="${ musicien.instrument }" /></li>
				</c:forEach>    
	    	</ul>
		  </div>
		</div>
    </c:if>
<%@ include file="/WEB-INF/views/footer.jsp" %>