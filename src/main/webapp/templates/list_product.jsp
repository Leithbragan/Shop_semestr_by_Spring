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
<div class="collapse navbar-collapse"><a class="btn btn-success" href="/admin/main" class="href">Админка</a>
    <a class="btn btn-success" href="/admin/product/add" class="href">Добавить продукт</a></div>
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

    <core:forEach var="product" items="${products}">
        <tbody>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price} рублей</td>
            <td>${product.type}</td>
            <sf:form method="post" modelAttribute="modify_product">
                <td><sf:input path="name"/></td>
                <td><sf:textarea path="description"/></td>
                <td><sf:input path="price"/></td>

                <td><sf:select path="type">
                    <sf:option value="Телефоны">Телефоны</sf:option>
                    <sf:option value="Компьютеры">Компьютеры</sf:option>
                    <sf:option value="Планшеты">Планшеты</sf:option>
                    <sf:option value="Теревзоры">Теревзоры</sf:option>
                    <sf:option value="Бытовая тнхника">Бытовая тнхника</sf:option>
                    <sf:option value="Фотокамеры">Фотокамеры</sf:option>
                    <sf:option value="Аудио">Аудио</sf:option>
                    <sf:option value="Комплектующие для ПК">Комплектующие для ПК</sf:option>
                </sf:select></td>
                <td>
                    <sf:button value="${product.id}" name="id" class="btn btn-success">Изменить</sf:button>
                </td>
            </sf:form>
        </tr>
        </tbody>
    </core:forEach>

</table>
</body>
</html>
