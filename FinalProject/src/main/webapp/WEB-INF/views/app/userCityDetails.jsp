<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li><a href="/app/userHomePage">Strona główna</a></li>
            <li><a href="#">O nas</a></li>
            <li><a href="#">Kontakt</a></li>
            <li><a href="/app/addPlan">Utwórz plan</a></li>
            <li><a href="/app/planList">Lista planów</a></li>
            <li><a href="/app/addToPlan">Dodaj do planu</a></li>
            <li><a href="/app/logout">Wyloguj</a></li>
        </ul>
    </div>
    <div id="header_main">
        <table>
            <tr>
                <th>Nazwa</th>
                <td>${cityDetails.get().getName()}</td>
            </tr>
            <tr>
                <th>Termin</th>
                <td>od ${cityDetails.get().getFirstDate()} do ${cityDetails.get().getLastDate()}</td>
            </tr>
            <tr>
                <th>Koszt dojazdu</th>
                <td>${cityDetails.get().getArrivalCost()} zł</td>
            </tr>
            <tr>
                <th>Koszt dziennego wyżywienia</th>
                <td>${cityDetails.get().getOneDayFoodCost()} zł</td>
            </tr>
            <tr>
                <th>Koszt noclegu</th>
                <td>${cityDetails.get().getSleepingCost()} zł</td>
            </tr>
            <tr>
                <th>Całkowity koszt pobytu w mieście</th>
                <td>${cityCost} zł</td>
            </tr>
        </table>
        <a href="javascript:history.back()">Powrót</a>
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