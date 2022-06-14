<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 13.06.2022
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Driver View</title>
</head>
<body>
Witaj kierowco: <c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></br>

Twoje ładunki:
<a href="<c:out value="/driverData/load/${driver.id}"/>">Ładunki</a>
<a href="<c:out value="/driverData/car/${driver.id}"/>">Dane samochodu</a>
<a href="<c:url value="/logout"/>">Logout</a>


</body>
</html>
