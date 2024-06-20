<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des acteurs</title>
</head>
<body>


<h1>Liste des acteurs</h1>

<p>

${acteurs}

</p>

<form action="acteur" method="POST">
	Prenom : <input type="text" name="prenom" placeholder="Saisir prenom"/><br>
	Nom : <input type="text" name="nom" placeholder="Saisir nom"/><br>
	Numero : <input required="required" type="text" name="adresse.numero" placeholder="Saisir numero"/><br>
	Voie : <input required="required" type="text" name="adresse.voie" placeholder="Saisir voie"/><br>
	Ville : <input required="required" type="text" name="adresse.ville" placeholder="Saisir ville"/><br>
	CP : <input required="required" type="text" name="adresse.cp" placeholder="Saisir cp"/><br>
	<input type="submit" value="Ajouter acteur">
</form>



</body>
</html>