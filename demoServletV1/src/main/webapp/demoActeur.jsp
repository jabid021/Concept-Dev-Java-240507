<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import ="netfilm.model.*" %>
  <%@ page import ="netfilm.context.Singleton" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%


Integer id = Integer.parseInt(request.getParameter("id"));

out.println("C'est du java !");


Acteur acteur = Singleton.getInstance().getDaoActeur().findById(id);
%>

<h1>Fiche de l'acteur <%=id%></h1>

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