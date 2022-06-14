<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 31.05.2022
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<b>
<head>
    <title>Strona główna</title>
</head>
<b>
<header>Menu</header>
    <sec:authorize access="hasRole('ADMIN')">
    <a href="<c:out value="drivers/all"/>">Kierowcy</a></b>
    </sec:authorize>

<a href="<c:out value="cars/all"/>">Samochody</a></b>
<a href="<c:out value="loads/all"/>">Ładunki</a></b>
<a href="<c:out value="users/all"/>">Użytkownicy</a></b>
<br>
<a href="<c:url value="/logout"/>">Logout</a>


</body>
</html>
