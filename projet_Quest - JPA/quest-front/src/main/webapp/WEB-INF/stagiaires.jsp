<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
	       <tbody>
	       	<core:forEach items="${stagiaires}" var="stagiaire">
	         <tr>
	           <td>${stagiaire.id}</td>
	           <td>${stagiaire.nom}</td>
	           <td>${stagiaire.prenom}</td>
	           <td>${stagiaire.email}</td>
	           <td>${stagiaire.filiere.libelle}</td>
	           <td>
	             <a href="stagiaire?id=${stagiaire.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
	             <a href="stagiaire?id=${stagiaire.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
	           </td>
	         </tr>
	         </core:forEach>
	       </tbody>
	     </table>
	
	
	
	
	
	     <div id="addFormStagiaire" class="formAjout">
	            <h3>Ajouter Stagiaire</h3>
	            <form action="stagiaire" method="post">
	            Nom :<input name="nom" type="text" placeholder="Saisir le nom"><br>
	            Prenom :<input name="prenom" type="text" placeholder="Saisir le prenom"><br>
	            Email :<input name="email" type="email" placeholder="Saisir l'email"><br>
	            Filiere :<select name="filiere" id="filiere-select">
		            <core:forEach items="${filieres}" var="filiere">
						<option value="${filiere.id}">${filiere.libelle}</option>
					</core:forEach>
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

</body>
</html>