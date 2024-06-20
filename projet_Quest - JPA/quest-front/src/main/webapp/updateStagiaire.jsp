<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="content">

  <h3>Modifier Stagiaire 1</h3>
  <form action="stagiaire" method="post">
  <input type="hidden" name="id" value="1">
  Nom :<input value="Abid" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="Jordan" name="prenom" type="text" placeholder="Saisir votre prenm"><br>
  Email :<input value="jordanabid@gmail.com" name="email" type="email" placeholder="Saisir votre email"><br>
  Filiere
    <select name="filiere">
        <option selected value="1" >1 - DIS-399-SOPRA-JAVA</option>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaires.html"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
