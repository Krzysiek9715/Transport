<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 30.05.2022
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista samochodów</title>
</head>
<body>
<table border="1">

    <thead>

    <th>Id</th>

    <th>Numery rejestracyjne</th>

    <th>Marka</th>

    <th>Rok produkcji</th>

    </thead>

    <tbody>

    <a href="<c:out value="/cars/add"/>">Dodaj samochód</a>

    <c:forEach items="${car}" var="car">

        <tr>

            <td><c:out value="${car.id}"/></td>

            <td><c:out value="${car.plates}"/></td>

            <td><c:out value="${car.brand}"/></td>

            <td><c:out value="${car.yearOfProduction}"/></td>

        </tr>
        <td>

            <a href="<c:out value="/cars/edit/${car.id}"/>">Edytuj</a>

            <a href="<c:out value="/cars/delete/${car.id}"/>">Usuń</a>

            <a href="<c:out value="/cars/find/${car.id}"/>">Pokaż</a>

        </td>
    </c:forEach>

    </tbody>

</table>
<a href="<c:out value="/"/>">Menu główne</a>

</body>
</html>
