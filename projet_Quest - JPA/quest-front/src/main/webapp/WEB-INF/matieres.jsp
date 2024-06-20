<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des matières</title>
</head>
<body>
<main class="container">
<div id="content">
<h1>Liste des Matieres</h1>
     <input id="btnAddMatiere" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Libelle</th>
           <th>Quest</th>
           <th>Actions</th>
           </tr>
       </thead>
       <core:forEach items="${matieres}" var="matiere">
         <tr>
           <td>${matiere.id}</td>
           <td>${matiere.libelle}</td>
           <td>${matiere.quest}</td>           
           <td>
             <a href="matiere?id=${matiere.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="matiere?id=${matiere.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </core:forEach>
     </table>





     <div id="addFormMatiere" class="formAjout">
            <h3>Ajouter Matiere</h3>
            <form action="matiere" method="post">
            Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle"><br>
            QUEST :<input name="debut" type="number" placeholder="Saisir le code quest"><br>

              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>

<script>

btnAddMatiere.onclick=function()
{
  addFormMatiere.style.display="block";
}

</script>
</main>
</body>
</html>
