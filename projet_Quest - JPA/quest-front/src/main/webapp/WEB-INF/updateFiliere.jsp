<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification d'une filière</title>
</head>
<body>
<main class="container">

	<h1>Modifier la filiere ${filiere.id}</h1>

	<form action="filiere" method="POST">
		<input type="hidden" name="id" value="${filiere.id}">
		
		Libellé : <input required="required" type="text" name="libelle" placeholder="Saisir libellé" value="${filiere.libelle}"/><br>
		Date de début : <input required="required" type="date" name="debut" value="${filiere.debut}" /><br>
		Date de fin : <input required="required" type="date" name="fin" value="${filiere.fin}"/><br>
		
		<input type="submit" class="btn btn-warning me-2" value="Modifier filiere"><a href="filiere" class="btn btn-info">Retour</a>
	</form>
	
</main>
</body>
</html>