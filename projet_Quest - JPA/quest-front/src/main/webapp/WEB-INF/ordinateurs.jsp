<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des ordinateurs</title>
</head>
<body>

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
		<h1>Liste des ordinateurs</h1>

		<section id="listeSMatieres" style="display: block">
			<div class="gap-4 mt-5 d-flex">
				<button class="btn btn-primary" id="ajouterordinateurBtn">Ajouter</button>
				<a href="index.html"><button class="btn btn-success">Retour</button></a>
			</div>
			<div class="mx-auto mt-3">
				<div class="table-responsive">
					<table class="table rounded shadow-lg table-striped table-primary">
						<thead>
							<tr>
								<th>ID</th>
								<th>Marque</th>
								<th>RAM</th>
								<th>Stagiaire</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach items="${ordinateurs}" var="ordinateur">
								<tr class="">
									<td class="p-3 align-middle">${ordinateur.id}</td>
									<td class="p-3 align-middle">${ordinateur.marque}</td>
									<td class="p-3 align-middle">${ordinateur.ram}</td>
									<td class="p-3 align-middle">${ordinateur.stagiaire.prenom} ${ordinateur.stagiaire.nom}</td>
									<td class="p-3 align-middle">
										<div class="gap-1 d-flex align-items-center">
											<a href="ordinateur?id=${ordinateur.id}">
												<span class="btn">
													<i class="fa-solid fa-pen-to-square fa-lg" style="color: #424244"></i>
												</span>
											</a> 
											<a href="ordinateur?id=${ordinateur.id}&delete">
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
		<section id="ajouterordinateur" class="my-4 mt-5" style="display: none">
			<h3 class="mb-4 text-center text-white">Ajouter un ordinateur</h3>
			<div class="mx-auto" style="max-width: 680px">
				<form class="gap-4 mx-auto d-flex flex-column" action="ordinateur" method="POST">
					Marque : <input required="required" type="text" name="marque" placeholder="Saisir marque" /><br>
					RAM : <input required="required" type="number" name="ram" /><br>
					<select required="required" name="stagiaire.id" class="text-white form-select bg-dark border-primary">
						<option value="">Choisir un stagiaire</option>
						<core:forEach items="${stagiaires}" var="stagiaire">
							<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
						</core:forEach>
					</select><br>
					<div class="d-flex justify-content-end">
						<button id="modifierordinateurBtn" class="btn btn-primary me-2" type="submit">Ajouter ordinateur</button>
						<button class="btn btn-success" type="button" id="retourListeBtn"> Retour</button>
					</div>
				</form>
			</div>
		</section>
	</main>
</body>

<script>
let ajouterordinateurBtn = document.getElementById("ajouterordinateurBtn");
ajouterordinateurBtn.addEventListener("click", (evt) => ajouterordinateur());

let listeordinateursBtn = document.getElementById("retourListeBtn");
listeordinateursBtn.addEventListener("click", (evt) => retourListe());

function ajouterordinateur() {
  document.getElementById("ajouterordinateur").style.display = "block";
  document.getElementById("listeordinateurs").style.display = "none";
}

function retourListe() {
  document.getElementById("ajouterordinateur").style.display = "none";
  document.getElementById("listeordinateurs").style.display = "block";
}
</script>

</html>