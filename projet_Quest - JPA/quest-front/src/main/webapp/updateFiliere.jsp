<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="content">

  <h3>Modifier Filiere  ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
  Libelle :<input value="${filiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Debut :<input value="${filiere.debut}" name="debut" type="date"><br>
  Fin :<input value="${filiere.fin}" name="fin" type="date"><br>

  <input class ="btn btn-warning" type="submit" value="Modifier">
  <a href="filieres.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  </form>

</div>
