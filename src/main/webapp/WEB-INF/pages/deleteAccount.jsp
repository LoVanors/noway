<%@ page import="com.example.noway.models.entities.Customer" %>
<%@ page import="com.example.noway.models.dtos.ConnectedUserDTO" %><%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 02-06-23
  Time: 11:24
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
    <title>Suppression de compte</title>
</head>
<body>
<% if (session.getAttribute("connectedUser") != null) {
    // Cast de l'objet connectedUser vers la classe appropriée (par exemple, User)
    ConnectedUserDTO connectedUser = (ConnectedUserDTO) session.getAttribute("connectedUser");
%>
<% } %>
<%if (session.getAttribute("connectedUser") != null) {%> <h2>
    Bienvenue ${connectedUser.username}</h2><%}%>
<p>demande de validation</p>
<form method="post" action="deleteAccount">
    <p>Pour supprimer votre compte, écrire : supprimer ${connectedUser.username}</p>
    <input type="confirmation" name="confirmation" id="confirmation" value="${confirmation}">
    <span style="color: red">${errorMessage}</span>
    <button type="submit">Supprimer</button>
</form>
<p>si texte exact, suppression du compte</p>
<form class="d-flex" role="search">
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="manageAccount">Retour</button>
</form>
</body>
</html>
