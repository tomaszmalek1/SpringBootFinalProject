<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Trip planner</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
</head>
<body>
<div id="container">

    <div id="header_logo">
        <a href="/home"><img src="/images/logo.png" alt="Logo"/></a>
    </div>
    <div id="header_menu">
        <ul>
            <li><a href="/home">Strona główna</a></li>
            <li><a href="#">O nas</a></li>
            <li><a href="#">Kontakt</a></li>
            <li><a href="#">Edytuj</a></li>
            <li><a href="#">Usuń</a></li>
            <li><a href="/app/logout">Wyloguj</a></li>
        </ul>
    </div>
    <div id="header_main">
        Formularz do planwania:
        <%--@elvariable id="country" type=""--%>
        <form:form method="post" modelAttribute="country">
            Kraj <form:input path="name"/><form:errors path="name" cssClass="errors"/><br>
            Data od: <form:input type="date" path="firstDate"/><form:errors path="firstDate" cssClass="errors"/><br>
            Data do: <form:input type="date" path="lastDate"/><form:errors path="lastDate" cssClass="errors"/>${localDateIsBefore}<br>
            <input type="submit" value="Dodaj">
        </form:form>
    </div>
    <div id="boxy">
        <div id="boxy_box_1">
            <h2>Lorem ipsum</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
                ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
            </p>
            <a href="#">Lorem ipsum</a>
        </div>
        <div id="boxy_box_2">
            <h2>Lorem ipsum</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
                ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
            </p>
            <a href="#">Lorem ipsum</a>
        </div>
        <div id="boxy_box_3">
            <h2>Lorem ipsum</h2>
            <p>
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation
                ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
            </p>
            <a href="#">Lorem ipsum</a>
        </div>
    </div>
    <div id="footer">
        © Wszelkie prawa zastrzeżone. <br> Projekt: <a href="http://www.templatki.net">Darmowe Szablony Stron</a>
    </div>
</div>
</body>
</html>