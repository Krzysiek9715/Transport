<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 12.06.2022
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Ładunki jednego kierowcy o ID:</title>
</head>

<br>
Ładunki kierowcy:
<table border="1">

    <thead>

    <th>Id</th>

    <th>Miejsce załadunku</th>

    <th>Miejsce rozładunku</th>

    <th>Kilometry</th>




    </thead>

    <tbody>

    <c:forEach items="${driverLoads}" var="load">

        <tr>

            <td><c:out value="${load.id}"/></td>

            <td><c:out value="${load.loadCity}"/></td>

            <td><c:out value="${load.unloadCity}"/></td>

            <td><c:out value="${load.kilometers}"/></td>

        </tr>

    </c:forEach>

    </tbody>

</table>
Suma kilometrów:  <c:out value="${kilometerSum}"/>
</br>



<a href="<c:out value="/"/>">Menu główne</a>

</body>
</html>
