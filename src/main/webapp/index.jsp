<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="styles/normalize.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Explora&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/index.css">
    <title>NoWay</title>
</head>
<body>

<main>
    <nav class="navbar fixed-top navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#start">
                <img src="images/logo.jpg">

                <%if (session.getAttribute("connectedUser") != null) {%> <h2>
                Bienvenue ${connectedUser.username}</h2><%}%>
            </a>
            <form class="d-flex" role="search">
                <%if (session.getAttribute("connectedUser") == null) {%>
                <button class="btn btn-primary me-1 " type="submit" formaction="login">Se connecter</button>
                <button class="btn btn btn-success  me-1 " type="submit" formaction="register">S'enregistrer</button>
                <%} else {%>
                <button class="btn btn btn-warning me-1 " type="submit" formaction="logout">Déconnexion</button>
                <c:choose>
                    <c:when test="${connectedUser.isAdmin}">
                        <button class="btn btn btn-info me-1 " type="submit" formaction="manage">Gérer</button>                    </c:when>
                    <c:otherwise>
                        <button class="btn btn btn-info me-1 " type="submit" formaction="manageAccount">Gérer</button>
                </c:otherwise>
                </c:choose>

                <%}%>

            </form>
        </div>
    </nav>
    <header id="start"></header>
    <div class="prespace">
        <div class="espace">
        </div>
    </div>
    <div class="desc">
        <p>ici se trouvera la description de mon premier voyage</p>
    </div>
    <div class="prespace">
        <div class="espace2">
        </div>
    </div>
    <div class="desc">
        <p>ici se trouvera la description de mon premier voyage</p>
    </div>
    <br/>
</main>
</body>
</html>