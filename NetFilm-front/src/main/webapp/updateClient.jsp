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
<title>Gestion des clients</title>
</head>
<body>
<main class="container">




	<h1>Modifier le client ${client.id}</h1>

	<form action="client" method="POST">
	<input type="hidden" name="id" value="${client.id}">
		Login : <input required="required" type="text" name="login" placeholder="Saisir login" value="${client.login}"/><br>
		Password : <input required="required" type="password" name="password" placeholder="Saisir password" value="${client.password}" /><br>
		Prenom : <input type="text" name="prenom" placeholder="Saisir prenom" value="${client.prenom}"/><br>
		Nom : <input type="text" name="nom" placeholder="Saisir nom" value="${client.nom}"/><br>
		Civilite : 
		<core:forEach items="${civilites}" var="civ">
			<core:choose>
				<core:when test="${civ==client.civilite}">
					<input  checked name="civilite" value="${civ}" type="radio"/>${civ} 
				</core:when>
				
				<core:otherwise>
					<input name="civilite" value="${civ}" type="radio"/>${civ} 
				</core:otherwise>
			</core:choose>
			
			<!--  <input <core:if test="${civ==client.civilite}">checked</core:if> name="civilite" value="${civ}" type="radio"/>${civ} -->
		</core:forEach>
		<br>
		Numero : <input required="required" type="text" name="adresse.numero" placeholder="Saisir numero" value="${client.adresse.numero}"/><br>
		Voie : <input required="required" type="text" name="adresse.voie" placeholder="Saisir voie" value="${client.adresse.voie}"/><br>
		Ville : <input required="required" type="text" name="adresse.ville" placeholder="Saisir ville" value="${client.adresse.ville}"/><br>
		CP : <input required="required" type="text" name="adresse.cp" placeholder="Saisir cp" value="${client.adresse.cp}" /><br>
		<input type="submit" class="btn btn-warning me-2" value="Modifier client"><a href="client" class="btn btn-info">Retour</a>
	</form>
	
	
</main>
</body>
</html>