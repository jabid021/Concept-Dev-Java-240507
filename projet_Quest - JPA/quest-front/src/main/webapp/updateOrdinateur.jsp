<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content">

  <h3>Modifier Ordinateur 1</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="id" value="1">
  Marque :<input value="Asus" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="8" name="ram" type="number" placeholder="Saisir votre RAM"><br>
  Stagiaire
    <select name="stagiaire">
        <option selected value="1" >1 - Jordan Abid</option>
        <option value="2" >2 - John Doe</option>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateurs.html"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
