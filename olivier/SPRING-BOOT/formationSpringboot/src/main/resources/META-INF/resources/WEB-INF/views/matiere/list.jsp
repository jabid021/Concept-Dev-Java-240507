<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<base href="${pageContext.request.contextPath}/">

<div id="content">
	<h1>Liste des Matieres</h1>
	<input id="btnAddMatiere" type="button" class="btn btn-success"
		value="Ajouter"> <a href="index.html"><input type="button"
		class="btn btn-info" value="Retour"></a>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Id</th>
				<th>Libelle</th>
				<th>Quest</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach items="${matieres}" var="matiere">
				<tr>
					<td>${matiere.id}</td>
					<td>${matiere.libelle}</td>
					<td>${matiere.quest}</td>
					<td><a href="matiere/update?id=${matiere.id}"><input
							type="button" class="btn btn-warning" value="Modifier"></a> <a
						href="matiere/delete?id=${matiere.id}" class="btn btn-danger">supprimer</a></td>
				</tr>


			</core:forEach>
		</tbody>
	</table>





	<div id="addFormMatiere" class="formAjout">
		<h3>Ajouter Matiere</h3>
		<form:form action="matiere/save" method="post"
			modelAttribute="matiere">
			<form:label path="libelle">Libelle :</form:label>
			<form:input path="libelle" placeholder="Saisir le libelle" />
			<br>
			<form:label path="quest">Code Quest :</form:label>
			<form:input path="quest" type="number"
				placeholder="Saisir le code Quest" />
			<br>
			<button class="btn btn-success" type="submit">ajouter</button>
		</form:form>
	</div>

</div>

<script>
	btnAddMatiere.onclick = function() {
		addFormMatiere.style.display = "block";
	}
</script>
