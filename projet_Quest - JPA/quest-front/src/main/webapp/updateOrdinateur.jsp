<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>


<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>

body
{
background-color : #F0F0F0
}
</style>
<meta charset="UTF-8">
<title>Gestion des stagiaires</title>
</head>
<body>
<main class="container">




	<h1>Modifier un ordinateur ${ordinateur.id}</h1>

	<form action="ordinateur" method="POST">
		<input type="hidden" name="id" value="${ordinateur.id}">
	
		Prix : <input required="required" value="${ordinateur.marque}" type="text" name="marque" placeholder="Saisir la marque" /><br>
		Ram : <input required="required"  step="1" value="${ordinateur.ram}" type="number" name="marque" placeholder="Saisir la taille de votre ram" /><br>
		Stagiaire : 
		<select required="required" name="stagiaire.id">
			<option value="">Choisir un stagiaire</option>
			<core:forEach items="${stagiaires}" var="stagiaire">
				<core:choose>
					<core:when test="${ordinateur.stagiaire.id==stagiaire.id}">
						<option selected value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom} ${stagiaire.email} </option>
					</core:when>
				
					<core:otherwise>
						<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.nom} ${stagiaire.prenom} ${stagiaire.email} </option>
					</core:otherwise>
				</core:choose>
			</core:forEach>
		</select>
		<br>
		<input type="submit" class="btn btn-warning me-2" value="Modifier Ordinateur"><a href="ordinateur" class="btn btn-info">Retour</a>
	</form>
	
	

	
</main>
</body>
</html>