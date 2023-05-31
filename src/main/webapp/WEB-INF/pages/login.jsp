<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 31-05-23
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<form method="post" action="login">
    <label for="username">nom d'utilisateur : </label>
    <input type="text" name="username" id="username" value="${username}">
    <label for="password">mot de passe : </label>
    <input type="password" name="password" id="password" value="${password}">
    <span style="color: red">${errorMessage}</span>
    <button type="submit">Connexion</button>
</form>
</body>
</html>
