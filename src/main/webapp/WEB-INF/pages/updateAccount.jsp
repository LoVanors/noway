<%@ page import="com.example.noway.models.dtos.ConnectedUserDTO" %><%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 05-06-23
  Time: 16:09
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
    <title>Modifier le compte</title>
</head>
<body>
<%if (session.getAttribute("connectedUser") != null) {%> <h2>
  Bienvenue ${connectedUser.username}</h2><%}%>
<p>affichage des paramètres</p>
<p>affichage des cases pour modifier</p>

<form method="post" action="updateAccount">
  <p>nom d'utilisateur : ${connectedUser.username}</p><br><br>
  <label for="username">nom d'utilisateur : </label><br><br>
  <input type="text" name="username" id="username" value="${username}"><br><br>
  <p>email : ${connectedUser.email}</p><br><br>
  <label for="email">email : </label><br><br>
  <input type="text" name="email" id="email" value="${email}"><br><br>
  <label for="password">mot de passe : </label><br><br>
  <input type="password" name="password" id="password" value="${password}"><br><br>
  <label for="confirmedPassword">confirmez le mot de passe : </label><br><br>
  <input type="password" name="confirmedPassword" id="confirmedPassword" value="${confirmedPassword}"><br><br>
  <label for="oldPassword">Mot de passe actuel : </label><br><br>
  <input type="password" name="oldPassword" id="oldPassword" value="${oldPassword}"><br><br>
  <span style="color: red">${errorMessage}</span>
  <button class="btn btn btn-Primary  me-1 " type="submit">Valider</button><br><br>
</form>
</body>
</html>
