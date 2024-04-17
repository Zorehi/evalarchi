<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Votre Panier</title>
</head>
<body>
<h1>Votre Panier</h1>
<table border="1">
    <tr>
        <th>Nom</th>
        <th>Prix</th>
        <th>Restant</th>
        <th></th>
        <th>Retirer 1 du panier</th>
        <th>Actuellement dans votre panier</th>
        <th>Ajouter 1 au panier</th>
    </tr>
    <c:forEach items="${requestScope.ARTICLE}" var="article">
        <tr>
            <td>${article.name}</td>
            <td>${article.price}</td>
            <td>${article.nbRestant}</td>
            <td></td>
            <td>
                <form action="retirerArticleDuPanier" method="post">
                    <input type="hidden" name="article" value="${article.id}" />
                    <input type="submit" value="Retirer">
                </form>
            </td>
            <td></td>
            <td>
                <form action="ajouterArticleAuPanier" method="post">
                <input type="hidden" name="article" value="${article.id}" />
                <input type="submit" value="Ajouter" name="Ajout"/>
            </form></td>
        </tr>
    </c:forEach>
</table>
<br>
<form action="afficherPanier" method="post">
    <input type="submit" value="Afficher le panier">
</form>
</body>
</html>
