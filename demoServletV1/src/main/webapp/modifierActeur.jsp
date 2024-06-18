<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Acteur</title>
</head>
<body>

<table border>




<tr>
	<th>Prenom</th><th>Nom</th><th>Adresse</th>
</tr>
	<tr><td>${acteurs[0].prenom}</td><td>${acteurs[0].nom}</td><td>${acteurs[0].adresse}</td></tr>
	<tr><td>${acteur.prenom}</td><td>${acteur.nom}</td><td>${acteur.adresse.numero} ${acteur.adresse.voie}, ${acteur.adresse.ville}, ${acteur.adresse.cp}</td></tr>
</table>
</body>
</html>