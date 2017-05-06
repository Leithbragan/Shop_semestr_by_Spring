<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Страница склада</title>
</head>
<body>
    ${warehouse.city}
    ${warehouse.street}
    <c:forEach var="print"  items="${stocktaking}">
        ${print.quantity} ${print.product.name}
    </c:forEach>
    ${quantity}
</body>
</html>
