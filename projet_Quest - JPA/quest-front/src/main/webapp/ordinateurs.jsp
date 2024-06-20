<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content">
  <h1>Liste des Ordinateurs</h1>
  <input id="btnAddOrdi" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Marque</th>
        <th>Ram</th>
        <th>Stagiaire</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Asus</td>
        <td>8Go</td>
        <td>1-Jordan Abid</td>
        <td>
          <a href="ordinateur.html?id=1"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="ordinateur?id=1&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>

      <tr>
        <td>2</td>
        <td>Dell</td>
        <td>16Go</td>
        <td>2-John Doe</td>
        <td>
          <a href="ordinateur.html?id=2"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="ordinateur?id=2&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </tbody>
  </table>





  <div id="addFormOrdi" class="formAjout">
    <h3>Ajouter Ordinateur</h3>
    <form action="ordinateur" method="post">
      Marque :<input name="marque" type="text" placeholder="Saisir votre marque"><br>
      RAM :<input name="ram" type="number" placeholder="Saisir votre RAM"><br>
      Stagiaire
      <select name="stagiaire">
        <option value="1" >1 - Jordan Abid</option>
        <option value="2" >2 - John Doe</option>
      </select><br>

      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

<script>

  btnAddOrdi.onclick=function()
  {
    addFormOrdi.style.display="block";
  }

</script>