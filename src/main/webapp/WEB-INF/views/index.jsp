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
<h1>École de musique</h1>
    <c:if test="${!empty sessionScope.sessionMusicien}">
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionMusicien.email}</p>
	    <h2>Liste des derniers musiciens enregistrés</h2>
	    <ul>
			<c:forEach var="musicien" items="${ musiciens }">
				<li><c:out value="${ musicien.nom }"/> <c:out value="${ musicien.prenom }"/> | instrument joué : <c:out value="${ musicien.instrument }" /></li>
			</c:forEach>    
	    </ul>
    </c:if>
<%@ include file="/WEB-INF/views/footer.jsp" %>