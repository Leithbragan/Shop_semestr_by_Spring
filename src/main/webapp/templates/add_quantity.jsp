<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление количества продукта</title>
    <style>
        <%@include file='css/add.css' %>
    </style>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h1>Добавление количества продукта</h1>
        <sf:form method="post" modelAttribute="quantity_form" cssClass="login-form">
            <sf:select path="stocktaking" placeholder="Продукт" cssClass="form_component">
                <core:forEach var="stocktak" items="${stocktaking}">
                    <sf:option value="${stocktak.id}">${stocktak.product.name}, город: ${stocktak.warehouse.city}</sf:option>
                </core:forEach>
            </sf:select>
            <sf:input path="quantity" placeholder="Количество" cssClass="form_component"/>
            <button type="submit">Добавить</button>
            <h6><a href="/admin/main">Админка</a></h6>
        </sf:form>
    </div>
</div>
</body>
</html>
