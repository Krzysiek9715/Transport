<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 09.06.2022
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista kierowców</title>
</head>
<body>
<table border="1">

    <thead>

    <th>ID</th>

    <th>Imię</th>

    <th>Nazwisko</th>

    <th>Nazwa użytkownika</th>

    <th>E-mail</th>

    <th>Funkcja</th>

    </thead>

    <tbody>

    <a href="<c:out value="/register"/>">Dodaj użytkownika</a>
    <c:forEach items="${user}" var="user">

        <tr>

            <td><c:out value="${user.id}"/></td>

            <td><c:out value="${user.firstName}"/></td>

            <td><c:out value="${user.lastName}"/></td>

            <td><c:out value="${user.username}"/></td>

            <td><c:out value="${user.email}"/></td>

            <td><c:out value="${user.role}"/></td>

        </tr>
        <td>

            <a href="<c:out value="/users/edit/${user.id}"/>">Edytuj</a>

            <a href="<c:out value="/users/find/${user.id}"/>">Pokaż</a>

        </td>
    </c:forEach>

    </tbody>

</table>
<a href="<c:out value="/"/>">Menu główne</a>

</body>
</html>
