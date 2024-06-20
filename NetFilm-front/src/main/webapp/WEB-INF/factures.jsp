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

	<h1>Liste des factures</h1>

	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Prix</th>
			<th>Valide ?</th>
			<th>Client</th>
			<th>Buttons</th>
		</tr>


		<core:forEach items="${factures}" var="facture">
			<tr>
				<td>${facture.id}</td>
				<td>${facture.prix}€</td>
				<td>${facture.valide}</td>
				<td>${facture.client.id} - ${facture.client.prenom} ${facture.client.nom} </td>
				
				<td><a href="facture?id=${facture.id}" class="btn btn-warning me-2">Modifier</a> <a href="facture?id=${facture.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			
			
			</tr>
		</core:forEach>

	</table>

	<form action="facture" method="POST">
		Prix : <input required="required" type="number" step="0.01" name="prix" placeholder="Saisir prix" /><br>
		Valide ? : <input  type="checkbox" name="valide"/><br>
		Client : 
		<select required="required" name="client.id">
			<option value="">Choisir un client</option>
			<core:forEach items="${clients}" var="client">
				<option value="${client.id}">${client.id} - ${client.prenom} ${client.nom} </option>
			</core:forEach>
		</select>
		<br>
		<input type="submit" class="btn btn-success" value="Ajouter Facture">
	</form>

</main>
</body>
</html>