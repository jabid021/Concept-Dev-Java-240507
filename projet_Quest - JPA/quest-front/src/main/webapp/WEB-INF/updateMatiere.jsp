<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<main class="container">




	<h1>Modifier la matiere ${matiere.id}</h1>

	<form action="matiere" method="POST">
	<input type="hidden" name="id" value="${matiere.id}">
		Libelle : <input required="required" type="text" name="libelle" placeholder="Saisir libelle" value="${matiere.libelle}"/><br>
		Quest : <input required="required" type="number" name="quest" placeholder="Saisir code quest" value="${matiere.quest}" /><br>
		
		<input type="submit" class="btn btn-warning me-2" value="Modifier matiere"><a href="matiere" class="btn btn-info">Retour</a>
	</form>
	
	
</main>
</body>
</html>