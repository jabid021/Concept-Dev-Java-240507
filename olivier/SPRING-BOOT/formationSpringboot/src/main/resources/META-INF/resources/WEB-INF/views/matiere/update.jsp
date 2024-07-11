<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="content">
	<base href="${pageContext.request.contextPath}/">
	<h3>Modifier Matiere ${matiere.id}</h3>
	<form:form action="matiere/save" method="post"
		modelAttribute="matiere">
		<form:hidden path="id" />
		<form:label path="libelle">Libelle :</form:label>
		<form:input path="libelle" placeholder="Saisir le libelle" />
		<br>
		<form:label path="quest">Code Quest :</form:label>
		<form:input path="quest" type="number"
			placeholder="Saisir le code Quest" />
		<br>
		<button class="btn btn-success" type="submit">modifier</button>
		<a href="matiere"><input type="button" class="btn btn-info"
			value="Retour"></a>
	</form:form>

</div>
