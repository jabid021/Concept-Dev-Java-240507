<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des filieres</title>
</head>
<body>
<main class="container">
	<h1>Liste des filieres</h1>

	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Libelle</th>
			<th>Date de début</th>
			<th>Date de fin</th>
		</tr>


		<core:forEach items="${filieres}" var="filiere">
			<tr>
				<td>${filiere.id}</td>
				<td>${filiere.libelle}</td>
				<td>${filiere.debut}</td>
				<td>${filiere.fin}</td>
				<td><a href="filiere?id=${filiere.id}" class="btn btn-warning me-2">Modifier</a> <a href="filiere?id=${filiere.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			</tr>
		</core:forEach>

	</table>

	<form action="filiere" method="POST">
		Libellé : <input required="required" type="text" name="libelle" placeholder="Saisir libellé de la filière" /><br>
		Date de début : <input required="required" type="date" name="debut" placeholder="Saisir prenom"/><br>
		Date de fin : <input required="required" type="date" name="fin" placeholder="Saisir nom" /><br>
		<input type="submit" class="btn btn-success" value="Ajouter filiere">
	</form>
</main>
</body>
</html>