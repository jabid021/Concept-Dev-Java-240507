<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="netfilm.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Acteur</title>
</head>
<body>



<%
Acteur acteur = (Acteur)request.getAttribute("acteur");
%>



<table border>

<tr>
	<th>Prenom</th><th>Nom</th><th>Adresse</th>
</tr>
	<%
	if(acteur==null)
	{
		out.println("<tr><td colspan='3'>Aucun acteur avec cet id</td></tr>");
	}
	else
	{
		out.println("<tr><td>"+acteur.getPrenom()+"</td><td>"+acteur.getNom()+"</td><td>"+acteur.getAdresse()+"</td></tr>");
	}
	%>

</table>
</body>
</html>