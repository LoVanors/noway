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
    <button type="submit">Valider</button>
</form>
</body>
</html>
