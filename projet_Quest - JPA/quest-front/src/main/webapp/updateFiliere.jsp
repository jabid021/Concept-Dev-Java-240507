<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
<div id="content">

  <h3>Modifier Filiere 1</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="1">
  Libelle :<input value="DIS-399-SOPRA-JAVA" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Debut :<input value="2022-10-25" name="debut" type="date"><br>
  Fin :<input value="2023-01-20" name="fin" type="date"><br>

  <input class ="btn btn-warning" type="submit" value="Modifier">
  <a href="filieres.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  </form>

</div>
</html>