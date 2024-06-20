<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des clients</title>
</head>
<body>
<main class="container">
<div id="content">
  <h1>Liste des Stagiaires</h1>
  <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Filiere</th>
        <th>Actions</th>
      </tr>
    </thead>
    <core:forEach items="${stagaires}"  var="stagiaire">
			<tr>
				<td>${stagiaire.id}</td>
				<td>${stagiaire.nom}</td>
				<td>${stagiaire.prenom}</td>
				<td>${stagiaire.email}</td>
				<td>${stagiaire.filiere.id} - ${stagiaire.filiere.libelle}</td>
				
				<td><a href="stagiaire?id=${stagiaire.id}" class="btn btn-warning me-2">Modifier</a> <a href="stagiaire?id=${stagiaire.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			
			
			</tr>
	</core:forEach>
    
  </table>





  <div id="addFormStagiaire" class="formAjout">
    <h3>Ajouter Stagiaire</h3>
    <form action="stagiaire" method="post">
      Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
      Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenm"><br>
      Email :<input name="email" type="email" placeholder="Saisir votre email"><br>
      Filiere
      <select name="filiere">
        <option value="1" >1 - DIS-399-SOPRA-JAVA</option>
      </select><br>
      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

<script>

  btnAddStagiaire.onclick=function()
  {
    addFormStagiaire.style.display="block";
  }

</script>
</main>
</body>
</html>
