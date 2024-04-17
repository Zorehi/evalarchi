<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Eval Archi</title>
</head>
<body>
  <form action="connexion" method="post">
    <c:if test="${requestScope.FAILED}">
      <div style="color: red">Le nom d'utilisateur ou le mot de passe saisit n'est pas valide.</div>
    </c:if>
    <div>
      <label>Login</label>
      <input type="text" name="login">
    </div>
    <div>
      <label>Mot de passe</label>
      <input type="password" name="password">
    </div>
    <button type="submit">Connexion</button>
  </form>
</body>
</html>