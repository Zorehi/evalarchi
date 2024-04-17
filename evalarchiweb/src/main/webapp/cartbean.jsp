<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        ${requestScope.USER.name}
        <a href="deconnexion">Déconnexion</a>
    </div>

    <h1 style="margin: 10px 0">Contenu du panier</h1>

    <fieldset>
        <table>
            <tr>
                <th>Articles</th>
                <th>Prix</th>
                <th>Quantité</th>
            </tr>
            <c:forEach items="${requestScope.CART}" var="result">
                <c:if test="${result.nbTaken > 0}">
                    <tr>
                        <td>${result.article.name}</td>
                        <td>${result.article.price}</td>
                        <td>${result.nbTaken}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        Prix total : ${requestScope.TOTALPRICE}
    </fieldset>

    <div style="margin-top: 10px">
        <button>Payer</button>
    </div>

    <form style="margin-top: 10px" action="listarticles" method="get">
        <button type="submit">Retour</button>
    </form>
</body>
</html>
