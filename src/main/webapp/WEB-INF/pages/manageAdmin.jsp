<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: loicv
  Date: 02-06-23
  Time: 10:32
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
    <title>Gestion des admins</title>
</head>
<body>
<%if (session.getAttribute("connectedUser") != null) {%> <h2>
    Bienvenue ${connectedUser.username}</h2><%}%>
<p>
<p>-affichage des comptes</p>
<p>-cocher</p>
<p>la validation définira le/les comptes cochés comme admin</p>
<form method="post" enctype="text/plain">
    <table>
        <tr>
            <th>ID</th>
            <th>nom d'utilisateur</th>
            <th>email</th>
            <th>admin</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.username}</td>
                <td>${customer.email}</td>
                <td>
                    <input type="checkbox" name="setAdmin${customer.id}" value="${customer.id}" ${customer.isAdmin ? 'checked' : ''}>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="définir les admins"><br><br>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="index">Accueil</button>
    <button class="btn btn btn-Success  me-1 " type="submit" formaction="manage">Retour</button>
</form>
</body>
</html>
