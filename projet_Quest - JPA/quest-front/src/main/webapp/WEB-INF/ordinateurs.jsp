<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des ordinateurs</title>
</head>
<body>

<main class="container">

	<h1>Liste des ordinateurs</h1>

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Marque</th>
			<th>RAM</th>
			<th>Stagiaire</th>
			<th>Buttons</th>
		</tr>


		<core:forEach items="${ordinateurs}" var="ordinateur">
			<tr>
				<td>${ordinateur.id}</td>
				<td>${ordinateur.marque}</td>
				<td>${ordinateur.ram}</td>
				<td>${ordinateur.stagiaire.id} - ${ordinateur.stagiaire.prenom} ${ordinateur.stagiaire.nom} </td>
				
				<td><a href="ordinateur?id=${ordinateur.id}" class="btn btn-warning me-2">Modifier</a> <a href="ordinateur?id=${ordinateur.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			
			
			</tr>
		</core:forEach>

	</table>
	

	<form action="ordinateur" method="POST">
		Marque : <input required="required" type="text" name="marque" placeholder="Saisir marque" /><br>
		RAM : <input  type="number" name="ram"/><br>
		Stagiaire : 
		<select required="required" name="stagiaire.id">
			<option value="">Choisir un stagiaire</option>
			<core:forEach items="${stagiaires}" var="stagiaire">
				<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom} </option>
			</core:forEach>
		</select>
		<br>
		<input type="submit" class="btn btn-success" value="Ajouter Ordinateur">
	</form>

</main>
</body>
</html>