<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 02-06-23
  Time: 09:50
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
    <title>Gestion des voyages</title>
</head>
<body>
<%if (session.getAttribute("connectedUser") != null) {%> <h2>
    Bienvenue ${connectedUser.username}</h2><%}%>
<form class="d-flex" role="search">

    <button class="btn btn btn-info me-1 " type="submit" formaction="addTravel">ajouter un voyage</button><br><br>

    <button class="btn btn btn-info  me-1 " type="submit" formaction="updateTravel">modifier un voyage</button><br><br>

    <button class="btn btn btn-info  me-1 " type="submit" formaction="deleteTravel">supprimer un ou plusieurs voyages</button><br><br>

    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="manage">Retour</button>
</form>
</body>
</html>
