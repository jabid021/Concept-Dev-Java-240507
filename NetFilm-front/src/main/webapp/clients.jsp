<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des clients</title>
</head>
<body>


<h1>Liste des clients</h1>

<p>Tableau (findall) à faire plus tard</p>


<form action="client" method="POST">
	Login : <input required="required" type="text" name="login" placeholder="Saisir login"/><br>
	Password : <input required="required" type="password" name="password" placeholder="Saisir password"/><br>
	Prenom : <input type="text" name="prenom" placeholder="Saisir prenom"/><br>
	Nom : <input type="text" name="nom" placeholder="Saisir nom"/><br>
	Civilite : <input checked="checked" name="civilite" value="Homme" type="radio">Homme <input name="civilite" value="Femme" type="radio">Femme <input name="civilite"  value="NB" type="radio"> NB<br>
	Numero : <input required="required" type="text" name="adresse.numero" placeholder="Saisir numero"/><br>
	Voie : <input required="required" type="text" name="adresse.voie" placeholder="Saisir voie"/><br>
	Ville : <input required="required" type="text" name="adresse.ville" placeholder="Saisir ville"/><br>
	CP : <input required="required" type="text" name="adresse.cp" placeholder="Saisir cp"/><br>
	<input type="submit" value="Ajouter client">
</form>


</body>
</html>