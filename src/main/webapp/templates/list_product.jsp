<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="/product/add" class="href">Добавить продукт</a></div>
<h1>Каталог</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <td>ID</td>
        <td>Название</td>
        <td>Описание</td>
        <td>Цена</td>
    </tr>
    </thead>

<core:forEach var="product" items="${products}">
    <tbody>
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.price} рублей</td>
    </tr>
    </tbody>
</core:forEach>
</table>
</body>
</html>
