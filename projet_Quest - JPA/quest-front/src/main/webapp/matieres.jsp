<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="content">
<h1>Liste des Matieres</h1>
     <input id="btnAddMatiere" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.jsp"><input type="button" class ="btn btn-info" value="Retour"></a>

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
				<td><a href="matiere?id=${matiere.id}" class="btn btn-warning me-2">Modifier</a> <a href="matiere?id=${matiere.id}&delete" class="btn btn-danger me-2">Supprimer</a> </td>
			</tr>
		</core:forEach>
       </tbody>
     </table>


     <div id="addFormMatiere" class="formAjout">
            <h3>Ajouter Matiere</h3>
            <form action="matiere" method="post">
            Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle"><br>
            Code Quest :<input name="quest" type="number" placeholder="Saisir le code Quest"><br>
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
