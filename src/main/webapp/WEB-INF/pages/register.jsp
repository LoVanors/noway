<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 31-05-23
  Time: 08:01
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
    <title>Inscription</title>
</head>
<body>
<form method="post" action="register">
    <label for="username">nom d'utilisateur : </label>
    <input type="text" name="username" id="username" value="${username}">
    <label for="email">email : </label>
    <input type="text" name="email" id="email" value="${email}">
    <label for="password">mot de passe : </label>
    <input type="password" name="password" id="password" value="${password}">
    <label for="confirmPassword">confirmez le mot de passe : </label>
    <input type="password" name="confirmedPassword" id="confirmPassword" value="${confirmPassword}">
    <span style="color: red">${errorMessage}</span>
    <button class="btn btn btn-Primary  me-1 " type="submit">Valider</button>
</form>
<form class="d-flex" role="search">
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
</form>
</body>
</html>
