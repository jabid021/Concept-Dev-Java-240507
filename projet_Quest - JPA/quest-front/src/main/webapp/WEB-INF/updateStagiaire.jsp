<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main class="container">
	<form action="stagiaire" method="POST">
		<input type="hidden" name="id" value="${stagiaire.id}" />
		Nom : <input required="required" type="text" name="nom" placeholder="Saisir nom" value="${stagiaire.nom}"/><br>
		Prénom : <input required="required" type="text" name="prenom" placeholder="Saisir prenom" value="${stagiaire.prenom}"/><br>
		Email : <input required="required" type="email" name="email" placeholder="Saisir email" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${stagiaire.email}"/><br>
		<select required="required" name="filiere.id">
			<option value="">Choisir une filière</option>
			<core:forEach items="${filieres}" var="filiere">
			<core:choose>
					<core:when test="${facture.client.id==client.id}">
						<option selected value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
					</core:when>
				
					<core:otherwise>
						<option value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
					</core:otherwise>
				</core:choose>
			</core:forEach>
		</select><br>
		<input type="submit" class="btn btn-success" value="Modifier stagiaire"><a href="stagiaire" class="btn btn-info">Retour</a>
	</form>
</main>
</body>
</html>