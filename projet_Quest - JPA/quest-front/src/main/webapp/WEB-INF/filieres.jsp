<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des filieres</title>
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

		<h1>Liste des filières</h1>

		<section id="listeSMatieres" style="display: block">
			<div class="gap-4 mt-5 d-flex">
				<button class="btn btn-primary" id="ajouterfiliereBtn">Ajouter</button>
				<a href="index.html"><button class="btn btn-success">Retour</button></a>
			</div>
			<div class="mx-auto mt-3">
				<!-- Table -->
				<div class="table-responsive">
					<table class="table rounded shadow-lg table-striped table-primary">
						<thead>
							<tr>
								<th>ID</th>
								<th>Libellé</th>
								<th>Date de dédbut</th>
								<th>date de fin</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach items="${filieres}" var="filiere">
								<tr class="">
									<td class="p-3 align-middle">${filiere.id}</td>
									<td class="p-3 align-middle">${filiere.libelle}</td>
									<td class="p-3 align-middle">${filiere.debut}</td>
									<td class="p-3 align-middle">
										<div class="gap-1 d-flex align-items-center">
											<a href="filiere?id=${filiere.id}">
												<span class="btn">
													<i class="fa-solid fa-pen-to-square fa-lg" style="color: #424244"></i>
												</span>
											</a>
											<a href="filiere?id=${filiere.id}&delete"">
												<span class="btn">
													<i class="fa-solid fa-trash fa-lg" style="color: #eb6262"></i>
												</span>
											</a>
										</div>
									</td>
								</tr>
							</core:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
		<section id="ajouterfiliere" class="my-4 mt-5" style="display: none">
			<h3 class="mb-4 text-center text-white">Ajouter une filière</h3>
			<div class="mx-auto" style="max-width: 680px">
				<form class="gap-4 mx-auto d-flex flex-column" action="filiere" method="POST">
					Libellé : <input required="required" type="text" name="libelle" placeholder="Saisir libelle" /><br>
					Date de début : <input required="required" type="date" name="debut" /><br>
					Date de fin : <input required="required" type="date" name="fin" /><br>
					<div class="d-flex justify-content-end">
						<button id="modifierfiliereBtn" class="btn btn-primary me-2" type="submit">Ajouter filière</button>
						<button class="btn btn-success" type="button" id="retourListeBtn">Retour</button>
					</div>
				</form>
			</div>
		</section>
	</main>
</body>

<script>
let ajouterfiliereBtn = document.getElementById("ajouterfiliereBtn");
ajouterfiliereBtn.addEventListener("click", (evt) => ajouterfiliere());

let listefilieresBtn = document.getElementById("retourListeBtn");
listefilieresBtn.addEventListener("click", (evt) => retourListe());

function ajouterfiliere() {
  document.getElementById("ajouterfiliere").style.display = "block";
  document.getElementById("listefilieres").style.display = "none";
}

function retourListe() {
  document.getElementById("ajouterfiliere").style.display = "none";
  document.getElementById("listefilieres").style.display = "block";
}
</script>
</html>