<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un stagiaire</title>
</head>
<body class="bg-dark">
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark sticky-top bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand"> <img src="assets/medias/netflix.png" width="36" alt="Logo" /> Net Formation </a>
			<form class="d-flex" role="search">
				<input class="border form-control me-2 border-info" type="search" placeholder="Recherche..." aria-label="Recherche" />
				<button class="ml-2 btn btn-secondary" type="submit">
					<i class="fa-solid fa-magnifying-glass fa-lg"></i>
				</button>
			</form>
		</div>
	</nav>
	<main class="container my-5">
		<h1>Modifier le stagiaire ${stagiaire.id}</h1>

		<div class="mx-auto" style="max-width: 680px">
			<form class="gap-4 mx-auto d-flex flex-column" action="matiere" method="POST">
				<input type="hidden" name="id" value="${stagiaire.id}" />
				<div>
					<label for="nom" class="text-white form-label">Nom</label>
					<div class="input-group">
						<input required="required" type="text" aria-label="nom" class="text-white form-control bg-dark border-primary" name="nom" placeholder="Saisir nom" value="${stagiaire.nom}"/><br>
						<input required="required" type="text" aria-label="prenom" class="text-white form-control bg-dark border-primary" name="prenom" placeholder="Saisir prenom" value="${stagiaire.prenom}"/><br>
						<input required="required" type="email" aria-label="email" class="text-white form-control bg-dark border-primary" name="email" placeholder="Saisir email" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${stagiaire.email}"/><br>
						<select required="required" name="filiere.id" class="text-white form-select bg-dark border-primary">
							<core:forEach items="${filieres}" var="filiere">
								<core:choose>
									<core:when test="${stagiaire.filiere.id==filiere.id}">
										<option selected value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
									</core:when>
								
									<core:otherwise>
										<option value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
									</core:otherwise>
								</core:choose>
							</core:forEach>
						</select><br>
					</div>
				</div>

				<div class="d-flex justify-content-end">
					<button class="btn btn-primary me-2" type="submit">Modifier</button>
					<a href="stagiaire"><button class="btn btn-danger" type="button">Retour</button></a>
				</div>
			</form>
		</div>
	</main>
</body>
</html>