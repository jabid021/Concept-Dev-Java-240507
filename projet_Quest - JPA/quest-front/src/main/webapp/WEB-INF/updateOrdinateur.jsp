<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un ordinateur</title>
</head>
<body>

	<main class="container">
		<h1>Modifier l'ordinateur ${ordinateur.id}</h1>

		<form action="ordinateur" method="POST">
			<input type="hidden" name="id" value="${ordinateur.id}"> 
			
			Marque : <input required="required" value="${ordinateur.marque}" type="text" name="marque" placeholder="Saisir marque" /><br>
			RAM : <input type="number" name="ram" value ="${ordinateur.ram}"/><br> 
			Stagiaire : 
			<select required="required" name="stagiaire.id">
				<option value="">Choisir un Stagiaire</option>
				<core:forEach items="${stagiaires}" var="stagiaire">
					<core:choose>
						<core:when test="${ordinateur.stagiaire.id==stagiaire.id}">
							<option selected value="${stagiaire.id}">${stagiaire.id}-
								${stagiaire.prenom} ${stagiaire.nom}</option>
						</core:when>
						<core:otherwise>
							<option value="${stagiaire.id}">${stagiaire.id}-
								${stagiaire.prenom} ${stagiaire.nom}</option>
						</core:otherwise>
					</core:choose>
				</core:forEach>
			</select> <br> 
			<input type="submit" class="btn btn-warning me-2" value="Modifier ordinateur"><a href="ordinateur" class="btn btn-info">Retour</a>
		</form>
	</main>
</body>
</html>