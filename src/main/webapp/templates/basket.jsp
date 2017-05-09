<%@ taglib prefix="core" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basket</title>
</head>
<body>
    <h1>Корзина</h1>
    ${order.typeOrder}
    <sf:forEach var="product" items="${products}">
        ${product.product.name} ${product.quantity}
    </sf:forEach>
</body>
</html>
