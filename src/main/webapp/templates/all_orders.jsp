<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказы</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <%@include file='css/ad.css' %>
    </style>
</head>
<body>
<h1>Заказы пользователя</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Пользователь</th>
        <th>Продукт</th>
        <th>Тип</th>
        <th></th>
        <th></th>
        <th></th>
        <th><h6><a href="/admin/main">Админка</a></h6></th>
    </tr>
    </thead>

    <core:forEach var="order" items="${orders}">
        <tbody>
        <tr>
            <sf:form method="post" modelAttribute="order_modify_form">
                <td>${order.id}</td>
                <td>${order.user.email}</td>
                <core:forEach var="product" items="${order.productInOrder}">
                    <p>${product.product.name}</p>
                </core:forEach>
                <td>${order.typeOrder}</td>

                <td><sf:select path="typeOrder">
                    <sf:option value="SEARS">Поиск товара на складе</sf:option>
                    <sf:option value="COMPLETED">Товар готов</sf:option>
                </sf:select></td>
                <td>
                    <sf:button value="${order.id}" name="user_id" class="btn btn-success">Изменить</sf:button>
                </td>
                <td><a class="btn btn-success" href="admin/order/delete?id=${order.id}">Удалить</a></td>

            </sf:form>
        </tr>
        </tbody>
    </core:forEach>
</table>
</body>
</html>
