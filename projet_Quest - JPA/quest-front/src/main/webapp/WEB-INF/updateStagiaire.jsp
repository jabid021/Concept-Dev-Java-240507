<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<main class="container">




	<h1>Modifier le stagiaire ${stagiaire.id}</h1>

	<form action="stagiaire" method="POST">
	<input type="hidden" name="id" value="${stagiaire.id}">
		Nom : <input required="required" type="text" name="nom" placeholder="Saisir nom" value="${stagiaire.nom}"/><br>
		Prenom : <input required="required" type="text" name="prenom" placeholder="Saisir prenom" value="${stagiaire.prenom}" /><br>
		Email : <input required="required" type="email" name="email" placeholder="Saisir email" value="${stagiaire.email}" /><br>
		Filiere :<select name="filiere" id="filiere-select">
		          <core:forEach items="${filieres}" var="filiere">
		            <core:choose>
			            <core:when test="${stagiaire.filiere.libelle == filiere.libelle}">
							<option selected value="${filiere.id}">${filiere.libelle}</option>
						</core:when>
						<core:otherwise>
							<option value="${filiere.id}">${filiere.libelle}</option>
						</core:otherwise>
					  </core:choose>
					</core:forEach>
				</select><br>
		
		<input type="submit" class="btn btn-warning me-2" value="Modifier stagiaire"><a href="stagiaire" class="btn btn-info">Retour</a>
	</form>
	
	
</main>
</body>
</html>