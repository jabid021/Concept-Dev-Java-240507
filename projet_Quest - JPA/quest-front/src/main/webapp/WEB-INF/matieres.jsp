<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 

	<!DOCTYPE html>
	<html lang="fr">
	  <head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link
		  rel="stylesheet"
		  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		/>
		<link rel="stylesheet" href="assets/src/bootstrap.min.css" />
		<script
		  src="https://kit.fontawesome.com/d536dee93f.js"
		  crossorigin="anonymous"
		></script>
		<script src="assets/src/script.js"></script>
		<title>Liste des matières</title>
	  </head>
	  <body class="bg-dark">
		<nav
		  class="navbar navbar-expand-lg fixed-top navbar-dark sticky-top bg-primary"
		>
		  <div class="container-fluid">
			<a class="navbar-brand">
			  <img src="assets/medias/netflix.png" width="36" alt="Logo" />
			  Net Formation
			</a>
			<form class="d-flex" role="search">
			  <input
				class="border form-control me-2 border-info"
				type="search"
				placeholder="Recherche..."
				aria-label="Recherche"
			  />
			  <button class="ml-2 btn btn-secondary" type="submit">
				<i class="fa-solid fa-magnifying-glass fa-lg"></i>
			  </button>
			</form>
		  </div>
		</nav>
<main class="container my-5">

	<h1>Liste des  matières</h1>

	<section id="listeSMatieres" style="display: block">
        <div class="gap-4 mt-5 d-flex">
          <button class="btn btn-primary" id="ajoutermatiereBtn">
            Ajouter
          </button>
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
					<th>Quest</th>
					<th>Buttons</th>
                </tr>
              </thead>
              <tbody>
				<core:forEach items="${matieres}" var="matiere">
                <tr class="">
                  <td class="p-3 align-middle">${matiere.id}</td>
                  <td class="p-3 align-middle">
                    ${matiere.libelle}
                  </td>
                  <td class="p-3 align-middle">${matiere.quest}</td>
                  <td class="p-3 align-middle">
                    <div class="gap-1 d-flex align-items-center">
						<a href="matiere?id=${matiere.id}"><span class="btn"
							><i
							  class="fa-solid fa-pen-to-square fa-lg"
							  style="color: #424244"
							></i
						  ></span></a> 
				<a href="matiere?id=${matiere.id}&delete""><span class="btn"
					><i
					  class="fa-solid fa-trash fa-lg"
					  style="color: #eb6262"
					></i
				  ></span></a> 
                      
                      
                    </div>
                  </td>
                </tr>
			</core:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </section>
	  <section id="ajoutermatiere" class="my-4 mt-5" style="display: none">
        <h3 class="mb-4 text-center text-white">Ajouter une matière</h3>
        <div class="mx-auto" style="max-width: 680px">
			<form class="gap-4 mx-auto d-flex flex-column" action="matiere" method="POST">
			Libellé : <input required="required" type="text" name="libelle" placeholder="Saisir libelle" /><br>
			Quest : <input required="required" type="number" name="quest" placeholder="Saisir le code Quest" /><br>
			<div class="d-flex justify-content-end">
              <button
                id="modifiermatiereBtn"
                class="btn btn-primary me-2"
                type="submit"
              >
              Ajouter matière
              </button>
              <button class="btn btn-success" type="button" id="retourListeBtn">
                Retour
              </button>
            </div>
          </form>
        </div>
      </section>
	</main>
</body>

<script>
let ajoutermatiereBtn = document.getElementById("ajoutermatiereBtn");
ajoutermatiereBtn.addEventListener("click", (evt) => ajoutermatiere());

let listematieresBtn = document.getElementById("retourListeBtn");
listematieresBtn.addEventListener("click", (evt) => retourListe());

function ajoutermatiere() {
  document.getElementById("ajoutermatiere").style.display = "block";
  document.getElementById("listematieres").style.display = "none";
}

function retourListe() {
  document.getElementById("ajoutermatiere").style.display = "none";
  document.getElementById("listematieres").style.display = "block";
}
</script>
</html>