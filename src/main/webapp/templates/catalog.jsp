<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
<form class="navbar-form navbar-right" action="/product/all">
    <input type="text" name="name" class="form-control" placeholder="Поиск по названию...">
</form>
<h1>Каталог</h1>
<div class="container-fluid">
    <div class="nav navbar-nav">
        <ul class="nav nav-tabs nav-justified">
            <li><a class="link-content" href="#Все" data-toggle="tab">Все</a></li>
            <li><a class="link-content" href="#Phone" data-toggle="tab">Телефоны</a></li>
            <li><a class="link-content" href="#Компьютеры" data-toggle="tab">Компьютеры</a></li>
            <li><a class="link-content" href="#Планшеты" data-toggle="tab">Планшеты</a></li>
            <li><a class="link-content" href="#Теревзоры" data-toggle="tab">Теревзоры</a></li>
            <li><a class="link-content" href="#Бытовая тнхника" data-toggle="tab">Быт. тнхника</a></li>
            <li><a class="link-content" href="#Фотокамеры" data-toggle="tab">Фотокамеры</a></li>
            <li><a class="link-content" href="#Аудио" data-toggle="tab">Аудио</a></li>
            <li><a class="link-content" href="#Комплектующие для ПК" data-toggle="tab">Комплектующие</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane active" id="Все">
                <div class="text-content"><h1 class="text-content">Все</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <tr>
                                <td class="text-content"><a class="product"
                                                            href="/product/?id=${product.id}">${product.name}</a>
                                    <h5>${product.description}</h5></td>
                                <td class="text-content"><a class="link-content" href="#${product.type}"
                                                            data-toggle="tab">${product.type}</a></td>
                                <td class="text-content">${product.price} рублей</td>
                                <td>
                                    <button class="btn btn-default" id="${product.id}" type="submit"
                                            name="product_id">Купить
                                    </button>
                                </td>
                            </tr>
                        </core:forEach>
                    </table>
                </div>
            </div>

            <div class="tab-pane fade" id="Phone">
                <div class="text-content"><h1>Телефоны</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Телефоны"/>
                            <core:set var="type" value="${product.type}"/>
                            <core:if test="${type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>

            <div class="tab-pane fade" id="Компьютеры">
                <div class="text-content"><h1>Компьютеры</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Компьютеры"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Планшеты">
                <div class="text-content"><h1>Планшеты</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Планшеты"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Теревзоры">
                <div class="text-content"><h1>Теревзоры</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Теревзоры"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Бытовая тнхника">
                <div class="text-content"><h1>Быт. тнхника</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Бытовая тнхника"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Фотокамеры">
                <div class="text-content"><h1>Фотокамеры</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Фотокамеры"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Аудио">
                <div class="text-content"><h1>Аудио</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Аудио"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
            <div class="tab-pane fade" id="Комплектующие для ПК">
                <div class="text-content"><h1>Комплектующие для ПК</h1></div>
                <div>
                    <table class="table table-condensed table table-bordered">
                        <core:forEach var="product" items="${products}">
                            <core:set var="type_p" value="Комплектующие для ПК"/>
                            <core:if test="${product.type == type_p}">
                                <tr>
                                    <td class="text-content"><a class="product"
                                                                href="/product/?id=${product.id}">${product.name}</a>
                                        <h5>${product.description}</h5></td>
                                    <td class="text-content"><a class="link-content" href="#${product.type}"
                                                                data-toggle="tab">${product.type}</a></td>
                                    <td class="text-content">${product.price} рублей</td>
                                    <td>
                                        <button class="btn btn-default" id="${product.id}" type="submit"
                                                name="product_id">Купить
                                        </button>
                                    </td>
                                </tr>
                            </core:if>
                        </core:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
