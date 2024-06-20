<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des stagiaires</title>
</head>
<body>
<main class="container">
	<h1>Liste des stagiaires</h1>

	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>nom</th>
			<th>prenom</th>
			<th>email</th>
			<th>Filière</th>
		</tr>


		<core:forEach items="${stagiaires}" var="stagiaire">
			<tr>
				<td>${stagiaire.id}</td>
				<td>${stagiaire.nom}</td>
				<td>${stagiaire.prenom}</td>
				<td>${stagiaire.email}</td>
				<td>${stagiaire.filiere.libelle}</td>
				<td><a href="stagiaire?id=${stagiaire.id}" class="btn btn-warning me-2">Modifier</a> <a href="stagiaire?id=${stagiaire.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			</tr>
		</core:forEach>

	</table>

	<form action="stagiaire" method="POST">
		Nom : <input required="required" type="text" name="nom" placeholder="Saisir nom" /><br>
		Prénom : <input required="required" type="text" name="prenom" placeholder="Saisir prenom"/><br>
		Email : <input required="required" type="email" name="email" placeholder="Saisir email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"/><br>
		<select required="required" name="filiere.id">
			<option value="">Choisir une filière</option>
			<core:forEach items="${filieres}" var="filiere">
				<option value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
			</core:forEach>
		</select><br>
		<input type="submit" class="btn btn-success" value="Ajouter stagiaire">
	</form>
</main>
</body>
</html>