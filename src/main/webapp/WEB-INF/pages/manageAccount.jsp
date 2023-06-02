<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 02-06-23
  Time: 10:15
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
    <title>Gestion du profile</title>
</head>
<body>
<p>formulaires de gestion du compte:</p>
<form class="d-flex" role="search">
    <p>-modifier infos</p>
    <button class="btn btn btn-info me-1 " type="submit" formaction="manageTravel">Gestion des voyages</button>
    <p>-supprimer compte</p>
    <button class="btn btn btn-Danger  me-1 " type="submit" formaction="manageAdmin">Gestion des admins</button>
    <p>-retour</p>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="manage">Retour</button>
</form>
</body>
</html>
