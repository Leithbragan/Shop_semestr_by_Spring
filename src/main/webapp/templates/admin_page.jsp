<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка</title>
    <style>
        <%@include file='css/admin_page.css' %>
    </style>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse" role="navigation">
       <div class="bt">
           <a class="btn btn-success" href="/product/add">Выход из админки</a>
       </div>
    </nav>
<div class="middle-body">
    <div class="button-panel">
        <div class="col-md-4"><a class="btn btn-success" href="/product/add">Добавление продукта</a></div>
        <div class="col-md-4"><a class="btn btn-success" href="/warehouse/add">Добавление склада</a></div>
        <div class="col-md-4"><a class="btn btn-success" href="/stocktaking/add">Добавление учетной записи</a></div>
        <div class="col-md-4"><a class="btn btn-success" href="/users/all">Список пользователей</a></div>
        <div class="col-md-4"><a class="btn btn-success" href="/product/all">Список продуктов</a></div>
        <div class="col-md-4"><a class="btn btn-success" href="/warehouse/all">Список складов</a></div>
    </div>
</div>
</div>
<div class="footer-body">

</div>
</body>
</html>
