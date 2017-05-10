<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <th>ID</th>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_USER')">
            <th>Номер заказа</th>
        </security:authorize>
        <th>Пользователь</th>
        <th>Тип</th>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <th></th>
            <th></th>
        </security:authorize>
        <th><security:authorize access="hasRole('ROLE_ADMIN')"><a class="btn btn-success"
                                                                  href="/admin/main">Админка</a></security:authorize><security:authorize
                access="hasRole('ROLE_USER')"><a class="btn btn-success" href="/">Главная</a></security:authorize></th>
    </tr>
    </thead>

    <core:forEach var="order" items="${orders}">
        <tbody>
        <tr>

            <td>${order.id}</td>
            <td>${order.user.email}</td>
            <td>${order.typeOrder}</td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <sf:form action="/admin/order/all" method="post" modelAttribute="order_form">
                    <td><sf:select path="typeOrder">
                        <sf:option value="SEARS">Поиск товара на складе</sf:option>
                        <sf:option value="COMPLETED">Товар готов</sf:option>
                    </sf:select></td>
                    <td>
                        <sf:button value="${order.id}" name="order_id" class="btn btn-success">Изменить</sf:button>
                    </td>
                </sf:form>
            </security:authorize>
            <security:authorize access="hasRole('ROLE_ADMIN')"><td><a class="btn btn-danger" href="/admin/order/delete?id=${order.id}">Удалить</a></td></security:authorize>
            <security:authorize access="hasRole('ROLE_USER')"><td><a class="btn btn-danger" href="/orders/delete?id=${order.id}">Удалить</a></td></security:authorize>


        </tr>
        </tbody>
    </core:forEach>
</table>
</body>
</html>
