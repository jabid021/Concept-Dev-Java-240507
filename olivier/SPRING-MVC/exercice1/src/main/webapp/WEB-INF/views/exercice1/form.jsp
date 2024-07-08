<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form:form method="post" action="" modelAttribute="personne">
			<div>
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" />
				<form:errors path="prenom">
					*ne doit pas etre vide
				</form:errors>
			</div>
			<div>
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" />
			</div>
			<div>
				<form:label path="age">age:</form:label>
				<form:input type="number" path="age" />
			</div>
			<div>
				<form:label path="dtNaissance">date de naissance:</form:label>
				<form:input type="date" path="dtNaissance" />
			</div>
			<div>
				<form:label path="adresse.rue">	adresse:</form:label>
				<form:input path="adresse.rue" />
				<form:errors path="adresse.rue" />
			</div>
			<div>
				<button type="submit">envoyer</button>
			</div>
		</form:form>
	</div>
</body>
</html>