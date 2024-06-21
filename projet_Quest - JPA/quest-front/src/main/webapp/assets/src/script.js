function init() {
  let ajouterStagiaireBtn = document.getElementById("ajouterStagiaireBtn");
  ajouterStagiaireBtn.addEventListener("click", (evt) => ajouterStagiaire());

  let listeStagiairesBtn = document.getElementById("retourListeBtn");
  listeStagiairesBtn.addEventListener("click", (evt) => retourListe());
}

window.onload = init;

function ajouterStagiaire() {
  document.getElementById("ajouterStagiaire").style.display = "block";
  document.getElementById("listeStagiaires").style.display = "none";
}

function retourListe() {
  document.getElementById("ajouterStagiaire").style.display = "none";
  document.getElementById("listeStagiaires").style.display = "block";
}
