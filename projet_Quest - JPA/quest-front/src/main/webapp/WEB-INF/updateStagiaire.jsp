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
<div id="content">

  <h3>Modifier Stagiaire ${stagiare.id}</h3>
  <form action="stagiaire" method="post">
  <input type="hidden" name="id" value="1">
  Nom :<input value="${stagiare.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="${stagiare.prenom}" name="prenom" type="text" placeholder="Saisir votre prenm"><br>
  Email :<input value="${stagiare.email}" name="email" type="email" placeholder="Saisir votre email"><br>
  Filiere
    <select required="required" name="filiere">
    <option value="" >Choisir une filière</option>
    <core:forEach items="${filieres}" var="filiere">
    <core:choose>
    	<core:when test="${stagiare.filiere.id==filiere.id}">
    		<option selected value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
    	</core:when>
    	<core:otherwise>
			<option value="${filiere.id}" >${filiere.id} - ${filiere.libelle}</option>
		</core:otherwise>
    </core:choose>
    </core:forEach>
        
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
</main>
</body>
</html>