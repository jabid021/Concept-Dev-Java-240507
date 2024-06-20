<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un ordinateur</title>
</head>
<body>

	<main class="container">
		<h1>Modifier l'ordinateur ${ordinateur.id}</h1>

		<div class="mx-auto" style="max-width: 680px">
				<form class="gap-4 mx-auto d-flex flex-column" action="ordinateur" method="POST">
					<input type="hidden" name="id" value="${ordinateur.id}" />
					<div>
						<label for="nom" class="text-white form-label">Marque</label>
						<div class="input-group">
							<input required="required" aria-label="marque" class="text-white form-control bg-dark border-primary" type="text" name="marque" value="${ordinateur.marque}" /><br>
							<input required="required" aria-label="ram" class="text-white form-control bg-dark border-primary" type="number" name="ram" value="${ordinateur.ram}" /><br>
							<select required="required" name="stagiaire.id" class="text-white form-select bg-dark border-primary">
								<core:forEach items="${stagiaires}" var="stagiaire">
									<core:choose>
										<core:when test="${ordinateur.stagiaire.id==stagiaire.id}">
											<option selected value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.nom} ${stagiaire.prenom}</option>
										</core:when>
									
										<core:otherwise>
											<option value="${stagiaire.id}">${stagiaire.id} - ${stagiaire.nom} ${stagiaire.prenom}</option>
										</core:otherwise>
									</core:choose>
								</core:forEach>
							</select><br>
						</div>
					</div>
				<div class="d-flex justify-content-end">
					<button class="btn btn-primary me-2" type="submit">Modifier</button>
					<a href="ordinateur"><button class="btn btn-danger" type="button">Retour</button></a>
				</div>
				</form>
			</div>
	</main>
</body>
</html>