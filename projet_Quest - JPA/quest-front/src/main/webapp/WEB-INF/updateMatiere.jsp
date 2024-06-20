<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="core"%>

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
    <title>Modifier matière</title>
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
      <h1>Modifier la matière ${matiere.id}</h1>

      <div class="mx-auto" style="max-width: 680px">
        <form
          class="gap-4 mx-auto d-flex flex-column"
          action="matiere"
          method="POST"
        >
          <input type="hidden" name="id" value="${matiere.id}" />
          <div>
            <label for="nom" class="text-white form-label">Quest</label>
            <div class="input-group">
              <input
                type="number"
                aria-label="quest"
                class="text-white form-control bg-dark border-primary"
                placeholder="Code quest"
                value="${matiere.quest}"
                name="quest"
              />
              <input
                type="text"
                aria-label="Libelle"
                class="text-white form-control bg-dark border-primary"
                placeholder="libelle"
                value="${matiere.libelle}"
                name="libelle"
              />
            </div>
          </div>

          <div class="d-flex justify-content-end">
            <button class="btn btn-primary me-2" type="submit">Modifier</button>
            <a href="matiere"
              ><button class="btn btn-danger" type="button">Retour</button></a
            >
          </div>
        </form>
      </div>
    </main>
  </body>
</html>
