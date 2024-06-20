<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="content">
  <h1>Liste des Stagiaires</h1>
  <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
  <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

  <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Email</th>
        <th>Filiere</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Abid</td>
        <td>Jordan</td>
        <td>jordanabid@gmail.com</td>
        <td>1 - DIS-399-SOPRA-JAVA</td>
        <td>
          <a href="stagiaire?id=1"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="stagiaire?id=1&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>

      <tr>
        <td>2</td>
        <td>Doe</td>
        <td>John</td>
        <td>jdoe@gmail.com</td>
        <td>1 - DIS-399-SOPRA-JAVA</td>
        <td>
          <a href="stagiaire?id=2"><input type="button" class ="btn btn-warning" value="Modifier"></a>
          <a href="stagiaire?id=2&delete">  <input type="button" class ="btn btn-danger" value="Supprimer"></a>
        </td>
      </tr>
    </tbody>
  </table>





  <div id="addFormStagiaire" class="formAjout">
    <h3>Ajouter Stagiaire</h3>
    <form action="stagiaire" method="post">
      Nom :<input name="nom" type="text" placeholder="Saisir votre nom"><br>
      Prenom :<input name="prenom" type="text" placeholder="Saisir votre prenm"><br>
      Email :<input name="email" type="email" placeholder="Saisir votre email"><br>
      Filiere
      <select name="filiere">
        <option value="1" >1 - DIS-399-SOPRA-JAVA</option>
      </select><br>
      <input class ="btn btn-success" type="submit" value="Ajouter">
    </form>
  </div>

</div>

<script>

  btnAddStagiaire.onclick=function()
  {
    addFormStagiaire.style.display="block";
  }

</script>
