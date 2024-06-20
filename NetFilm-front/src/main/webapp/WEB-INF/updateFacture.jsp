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




	<h1>Modifier la facture ${facture.id}</h1>

	<form action="facture" method="POST">
		<input type="hidden" name="id" value="${facture.id}">
	
		Prix : <input required="required"  step="0.01" value="${facture.prix}" type="number" name="prix" placeholder="Saisir prix" /><br>
		Valide ? : <input  <core:if test="${facture.valide==true}">checked</core:if> type="checkbox" name="valide"/><br>
		Client : 
		<select required="required" name="client.id">
			<option value="">Choisir un client</option>
			<core:forEach items="${clients}" var="client">
				<core:choose>
					<core:when test="${facture.client.id==client.id}">
						<option selected value="${client.id}">${client.id} - ${client.prenom} ${client.nom} </option>
					</core:when>
				
					<core:otherwise>
						<option value="${client.id}">${client.id} - ${client.prenom} ${client.nom} </option>
					</core:otherwise>
				</core:choose>
			</core:forEach>
		</select>
		<br>
		<input type="submit" class="btn btn-warning me-2" value="Modifier Facture"><a href="facture" class="btn btn-info">Retour</a>
	</form>
	
	

	
</main>
</body>
</html>