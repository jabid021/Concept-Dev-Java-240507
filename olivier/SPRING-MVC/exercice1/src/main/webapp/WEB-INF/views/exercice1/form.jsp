<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form method="post">
			prenom:<input name="prenom" value="${personne.prenom}">
			<c:if test="${prenomError!=null }">*prenom obligatoire</c:if>
			<br>nom:<input name="nom" value="${personne.nom}">
			<c:if test="${nomError!=null }">*nom obligatoire</c:if>
			<br> age:<input type="number" name="toto"
				value="${personne.age}"><br> naissance<input
				type="date" name="dtNaissance" value="${personne.dtNaissance }"><br>
			adresse:<input name="adresse.rue"><br>
			<button type="submit">ok</button>
		</form>
	</div>
</body>
</html>