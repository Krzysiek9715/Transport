<%--
  Created by IntelliJ IDEA.
  User: krzysiek
  Date: 13.06.2022
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dane samochodu kierowcy</title>
</head>
<body>
Dane auta:
Numery rejestracyjne:
<c:out value="${car.plates}"/><br>
Marka:
<c:out value="${car.brand}"/><br>
Rok produkcji
<c:out value="${car.yearOfProduction}"/><br>
</body>
</html>
