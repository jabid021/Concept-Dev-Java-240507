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

	<h1>Liste des clients</h1>

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Login</th>
			<th>Password</th>
			<th>Prenom</th>
			<th>Nom</th>
			<th>Civilite</th>
			<th>Adresse</th>
			<th>Buttons</th>
		</tr>


		<core:forEach items="${clients}" var="client">
			<tr>
				<td>${client.id}</td>
				<td>${client.login}</td>
				<td>${client.password}</td>
				<td>${client.prenom}</td>
				<td>${client.nom}</td>

				<core:if test="${client.civilite=='Homme'}">
					<td class="civ-homme">${client.civilite}</td>
				</core:if>

				<core:if test="${client.civilite=='Femme'}">
					<td class="civ-femme">${client.civilite}</td>
				</core:if>

				<core:if test="${client.civilite=='NB'}">
					<td>${client.civilite}</td>
				</core:if>


				<td>${client.adresse.numero}${client.adresse.voie}, ${client.adresse.cp}, ${client.adresse.ville}</td>
				
				
				<td><a href="client?id=${client.id}" class="btn btn-warning me-2">Modifier</a> <a href="client?id=${client.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			
			
			</tr>
		</core:forEach>

	</table>

	<form action="client" method="POST">
		Login : <input required="required" type="text" name="login" placeholder="Saisir login" /><br>
		Password : <input required="required" type="password" name="password" placeholder="Saisir password" /><br>
		Prenom : <input type="text" name="prenom" placeholder="Saisir prenom"/><br>
		Nom : <input type="text" name="nom" placeholder="Saisir nom" /><br>
		Civilite : 
		<core:forEach items="${civilites}" var="civ">
			<input checked name="civilite" value="${civ}" type="radio"/>${civ} 
		</core:forEach>
		<br>
		Numero : <input required="required" type="text" name="adresse.numero" placeholder="Saisir numero" /><br>
		Voie :  <input required="required" type="text" name="adresse.voie" placeholder="Saisir voie" /><br>
		Ville : <input required="required" type="text" name="adresse.ville" placeholder="Saisir ville" /><br>
		CP : <input required="required" type="text" name="adresse.cp" placeholder="Saisir cp" /><br>
		<input type="submit" class="btn btn-success" value="Ajouter client">
	</form>

</main>
</body>
</html>