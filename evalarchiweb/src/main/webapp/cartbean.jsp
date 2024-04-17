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
                <tr>
                    <td>${result.key.name}</td>
                    <td>${result.key.price}</td>
                    <td>${result.value}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>

    <div style="margin-top: 10px">
        <button>Retour</button>
    </div>
</body>
</html>
