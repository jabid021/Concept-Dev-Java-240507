<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des stagiaires</title>
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
		<h1>Liste des stagiaires</h1>

		<section id="listeSMatieres" style="display: block">
			<div class="gap-4 mt-5 d-flex">
				<button class="btn btn-primary" id="ajouterstagiaireBtn">Ajouter</button>
				<a href="index.html"><button class="btn btn-success">Retour</button></a>
			</div>
			<div class="mx-auto mt-3">
				<div class="table-responsive">
					<table class="table rounded shadow-lg table-striped table-primary">
						<thead>
							<tr>
								<th>ID</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Filiere</th>
							</tr>
						</thead>
						<tbody>
							<core:forEach items="${stagiaires}" var="stagiaire">
								<tr class="">
									<td class="p-3 align-middle">${stagiaire.id}</td>
									<td class="p-3 align-middle">${stagiaire.nom}</td>
									<td class="p-3 align-middle">${stagiaire.prenom}</td>
									<td class="p-3 align-middle">${stagiaire.filiere.libelle}</td>
									<td class="p-3 align-middle">
										<div class="gap-1 d-flex align-items-center">
											<a href="stagiaire?id=${stagiaire.id}">
												<span class="btn">
													<i class="fa-solid fa-pen-to-square fa-lg" style="color: #424244"></i>
												</span>
											</a> 
											<a href="stagiaire?id=${stagiaire.id}&delete">
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
		<section id="ajouterstagiaire" class="my-4 mt-5" style="display: none">
			<h3 class="mb-4 text-center text-white">Ajouter un stagiaire</h3>
			<div class="mx-auto" style="max-width: 680px">
				<form class="gap-4 mx-auto d-flex flex-column" action="stagiaire" method="POST">
					Nom : <input required="required" type="text" name="nom" placeholder="Saisir libelle" /><br>
					Prenom : <input required="required" type="text" name="prenom" placeholder="Saisir le code Quest" /><br>
					Email : <input required="required" type="email" name="email" placeholder="Saisir email" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" /><br>
					<select required="required" name="filiere.id" class="text-white form-select bg-dark border-primary">
						<option value="">Choisir une filière</option>
						<core:forEach items="${filieres}" var="filiere">
							<option value="${filiere.id}">${filiere.id} - ${filiere.libelle}</option>
						</core:forEach>
					</select><br>
					<div class="d-flex justify-content-end">
						<button id="modifierstagiaireBtn" class="btn btn-primary me-2" type="submit">Ajouter stagiaire</button>
						<button class="btn btn-success" type="button" id="retourListeBtn"> Retour</button>
					</div>
				</form>
			</div>
		</section>
	</main>
</body>

<script>
let ajouterstagiaireBtn = document.getElementById("ajouterstagiaireBtn");
ajouterstagiaireBtn.addEventListener("click", (evt) => ajouterstagiaire());

let listestagiairesBtn = document.getElementById("retourListeBtn");
listestagiairesBtn.addEventListener("click", (evt) => retourListe());

function ajouterstagiaire() {
  document.getElementById("ajouterstagiaire").style.display = "block";
  document.getElementById("listestagiaires").style.display = "none";
}

function retourListe() {
  document.getElementById("ajouterstagiaire").style.display = "none";
  document.getElementById("listestagiaires").style.display = "block";
}
</script>

</html>