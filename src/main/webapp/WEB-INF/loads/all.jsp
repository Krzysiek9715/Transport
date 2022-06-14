<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 03.06.2022
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Exporty</title>
</head>
<body>
Exporty:
<table border="1">

    <thead>

    <th>Id</th>

    <th>Długość trasy</th>

    <th>Miejsce załadunku</th>

    <th>Miejsce rozładunku</th>

    <th>Stawka</th>

    <th>Czy konieczny powrót</th>

    <th>Kierowca</th>

    <th>Raport</th>


    </thead>

    <tbody>

    <a href="<c:out value="/loads/add"/>">Dodaj ładunek</a>
    <c:forEach items="${load}" var="load">

        <tr>

            <td><c:out value="${load.id}"/></td>

            <td><c:out value="${load.kilometers}"/></td>

            <td><c:out value="${load.loadCity}"/></td>

            <td><c:out value="${load.unloadCity}"/></td>

            <td><c:out value="${load.price}"/></td>

            <td><c:out value="${load.loadImport}"/></td>

            <td><c:out value="${load.drivers}"/></td>

            <td><a href="<c:out value="/loads/price/${load.id}"/>"/>Raport</td>


        </tr>
        <td>

            <a href="<c:out value="/loads/edit/${load.id}"/>">Edytuj</a>

            <a href="<c:out value="/loads/delete/${load.id}"/>">Usuń</a>

            <a href="<c:out value="/loads/find/${load.id}"/>">Pokaż</a>

        </td>
    </c:forEach>

    </tbody>

</table>

<a href="<c:out value="/"/>">Menu główne</a>

</body>
</html>
