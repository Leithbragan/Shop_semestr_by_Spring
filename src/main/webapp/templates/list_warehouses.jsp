<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Склады</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <%@include file='css/ad.css' %>
    </style>
</head>
<body>
<div class="collapse navbar-collapse"><a href="/admin/main">Админка</a>
     <a href="/warehouse/add">Добавить склад</a></div>
<h1>Доступные склады</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <td>ID</td>
        <td>Город</td>
        <td>Улица</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <core:forEach var="warehouse" items="${warehouses}">
        <tr>
            <td>${warehouse.id}</td>
            <td>${warehouse.city}</td>
            <td>${warehouse.street}</td>
            <td>
                <a href="/warehouse/${warehouse.id}" class="btn btn-success">Посмотреть склад</a>
            </td>
            <td>
                <a href="/warehouse/${warehouse.id}" class="btn btn-success">Удалить склад</a>
            </td>
        </tr>
    </core:forEach>
    </tbody>
</table>
</body>
</html>
