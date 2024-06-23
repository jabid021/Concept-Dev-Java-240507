<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content">

  <h3>Modifier Ordinateur ${stagiaire.id}</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="id" value="${stagiaire.id}">
  Marque :<input value="${stagiaire.marque}" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="8" name="${stagiaire.ram}" type="number" placeholder="Saisir votre RAM"><br>
  Stagiaire :
    <select name="stagiaire">
    <core:forEach items="${stagiaires}" var="stagiaire">
        <option selected value="${stagiaire.id}" >${stagiaire.prenom} ${stagiaire.nom}</option>
    </core:forEach>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateurs.html"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
