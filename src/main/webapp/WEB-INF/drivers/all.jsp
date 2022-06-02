<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 29.05.2022
  Time: 14:13
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

    <th>Id</th>

    <th>Imię</th>

    <th>Nazwisko</th>

    <th>Numer dowodu</th>

    <th>Numer telefonu</th>

    </thead>

    <tbody>

    <a href="<c:out value="/drivers/add"/>">Dodaj kierowcę</a>
    <c:forEach items="${driver}" var="driver">

        <tr>

            <td><c:out value="${driver.id}"/></td>

            <td><c:out value="${driver.firstName}"/></td>

            <td><c:out value="${driver.lastName}"/></td>

            <td><c:out value="${driver.idSerialNumber}"/></td>

            <td><c:out value="${driver.phoneNumber}"/></td>

        </tr>
        <td>

            <a href="<c:out value="/drivers/edit/${driver.id}"/>">Edytuj</a>

            <a href="<c:out value="/drivers/delete/${driver.id}"/>">Usuń</a>

            <a href="<c:out value="/drivers/find/${driver.id}"/>">Pokaż</a>

        </td>
    </c:forEach>

    </tbody>

</table>

</body>
</html>
