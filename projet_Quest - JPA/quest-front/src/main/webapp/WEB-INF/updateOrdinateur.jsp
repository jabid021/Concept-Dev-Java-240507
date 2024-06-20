<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="content">

  <h3>Modifier Ordinateur ${ordinateur.id}</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="id" value="${ordinateur.id}">
  Marque :<input value="${ordinateur.marque}" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="${ordinateur.ram}" name="ram" type="number" placeholder="Saisir votre RAM"><br>
  Stagiaire
    <select required="required" name="stagiaire.id">
        <option value="">Choisir un stagiaire</option>
			<core:forEach items="${stagiaires}" var="stagiaire">
			<core:choose>
					<core:when test="${ordinateur.stagiaire.id==stagiaire.id}">
						<option selected value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom} </option>
					</core:when>
				
					<core:otherwise>
						<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom} </option>
					</core:otherwise>
			</core:choose>
			</core:forEach>
    </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateurs.html"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>
</body>
</html>