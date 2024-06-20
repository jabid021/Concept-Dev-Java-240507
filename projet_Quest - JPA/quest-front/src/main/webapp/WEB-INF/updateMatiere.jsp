<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des matières</title>
</head>
<div id="content">

  <h3>Modifier Matière</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="${matiere.id}">
  Libelle :<input value="${matiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Quest :<input value="${matiere.quest}" name="quest" type="number" placeholder="Saisir le code quest"><br>
 

  <input class ="btn btn-warning" type="submit" value="Modifier">
  <a href="matiere"><input type="button" class ="btn btn-info" value="Retour"></a>

  </form>

</div>
</html>