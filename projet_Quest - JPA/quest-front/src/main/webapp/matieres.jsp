<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
       <tbody>
         <tr>
           <td>1</td>
           <td>Algo avec Java</td>
           <td>7245</td>
           <td>
             <a href="matiere?id=1"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="matiere?id=1&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>

         <tr>
           <td>2</td>
           <td>SQL</td>
           <td>4352</td>
           <td>
             <a href="matiere?id=2"><input type="button" class ="btn btn-warning" value="Modifier"></a>
              <a href="matiere?id=2&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
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