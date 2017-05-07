<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Каталог</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <%@include file='css/ad.css' %>
    </style>
</head>
<body>
<div class="collapse navbar-collapse"><a href="/admin/main" class="href">Админка</a>
    <a href="/admin/product/add" class="href">Добавить продукт</a></div>
<h1>Продукты</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Тип</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <sf:form method="post" modelAttribute="modify_product">
        <core:forEach var="product" items="${products}">
            <tbody>
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price} рублей</td>
                <td>${product.type}</td>
                <td><sf:input path="name"/></td>
                <td><sf:textarea path="description"/></td>
                <td><sf:input path="price"/></td>

                <td><sf:select path="type">
                    <sf:option value="Еда">Еда</sf:option>
                    <sf:option value="Вода">Вода</sf:option>
                </sf:select></td>
                <td>
                    <sf:button value="${product.id}" name="id" class="btn btn-success">Изменить</sf:button>
                </td>
            </tr>
            </tbody>
        </core:forEach>
    </sf:form>
</table>
</body>
</html>
