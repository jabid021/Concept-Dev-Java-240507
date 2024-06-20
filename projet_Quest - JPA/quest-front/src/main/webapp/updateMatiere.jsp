<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content">

  <h3>Modifier Matiere 1</h3>
  <form action="matiere" method="post">
  <input type="hidden" name="id" value="1">
  Libelle :<input value="Algo avec Java" name="libelle" type="text" placeholder="Saisir le libelle"><br>
  Code Quest :<input value="7245" name="quest" type="number" placeholder="Saisir le code Quest"><br>


    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="matiere"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
