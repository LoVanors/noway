<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 02-06-23
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Explora&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/index.css">
    <title>ajout de voyage</title>
</head>
<body>
<p>formulaire permettant d'ajouter un voyage</p>
<form action="addTravel" method="post" enctype="multipart/form-data">
    <label for="destination">Destination:</label>
    <input type="text" id="destination" name="destination" value="${destination}" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" rows="4" cols="50" value="${description}" required></textarea><br><br>

    <label for="prix">Prix:</label>
    <input type="number" id="prix" name="prix" value="${price}" required><br><br>

    <label for="dateDebut">Date de début:</label>
    <input type="date" id="dateDebut" name="dateDebut" value="${startDate}" required><br><br>

    <label for="dateFin">Date de fin:</label>
    <input type="date" id="dateFin" name="dateFin" value="${endDate}" required><br><br>

    <label for="image">Image:</label>
    <input type="file" id="image" name="image" accept="image/*" value="${image}" required><br><br>

    <input type="submit" value="Ajouter">
</form>
<form class="d-flex" role="search">
    <p>-retour</p>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="manageTravel">Retour</button>
</form>
</body>
</html>
