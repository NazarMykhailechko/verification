<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Verification list</title>
    <style>
        .tab_f {
            /*background-color : White;*/
            /*border-color : Navy Blue;*/
            border: 1px dotted Green;
            width: 550px;
            background-color: #f3fe1c;
        }

        .tab_f_name_tb {
            background-image: url(/WEB-INF/img/tb000000.png);
            border: 1px outset #FFFACD;
            /*color : White;*/
        }

        .tab_f_tb_2 {
            border: 1px outset #FFFACD;
            padding: 1px 5px 1px 5px;
            background-color: #D8F1FE;
        }
    </style>
</head>
<body>
<h2>Verification list</h2>
<table border=1 cellspacing='0' cellpadding='0' class="tab_f">
    <tr>
        <th class=tab_f_name_tb>id</th>
        <th class=tab_f_name_tb>name</th>
        <th class=tab_f_name_tb>inn</th>
        <th class=tab_f_name_tb>negative</th>
        <th class=tab_f_name_tb>hbCheckKb</th>
        <th class=tab_f_name_tb>hbCheckProfit</th>
        <th class=tab_f_name_tb>hbResult</th>
        <th class=tab_f_name_tb>hbType</th>
        <th class=tab_f_name_tb>commentary</th>
        <th class=tab_f_name_tb>description</th>
        <th class=tab_f_name_tb>user</th>
        <th class=tab_f_name_tb>entryDate</th>
        <th class=tab_f_name_tb>edit</th>
        <th class=tab_f_name_tb>delete</th>
    </tr>

    <c:forEach items="${clientCars}" var="clientCar">
        <tr class="tab_f_tb_2">

            <td> ${clientCar.id}</td>
            <td>${clientCar.name}</td>
            <td>${clientCar.inn}</td>
            <td>${clientCar.hbNegative.getType()}</td>
            <td>${clientCar.hbCheckKb.getType()}</td>
            <td>${clientCar.hbCheckProfit.getType()}</td>
            <td>${clientCar.hbResult.getType()}</td>
            <td>${clientCar.hbType.getType()}</td>
            <td>${clientCar.commentary}</td>
            <td>${clientCar.description}</td>
            <td>${clientCar.user.getType()}</td>
            <td>${clientCar.entryDate}</td>
            <td>
                <button onclick="">edit</button>
            </td>
            <td>
                <button onclick="">delete</button>
            </td>

        </tr>
    </c:forEach>

</table>

<br>

<form method="POST" action="/verification/add" class=".tab_f">

    <table border=1 cellspacing='0' cellpadding='0' class="tab_f">
        <tr>
            <th class=tab_f_name_tb>name</th>
            <th class=tab_f_name_tb>inn</th>
            <th class=tab_f_name_tb>negative</th>
            <th class=tab_f_name_tb>hbCheckKb</th>
            <th class=tab_f_name_tb>hbCheckProfit</th>
            <th class=tab_f_name_tb>hbResult</th>
            <th class=tab_f_name_tb>hbType</th>
            <th class=tab_f_name_tb>commentary</th>
            <th class=tab_f_name_tb>description</th>
            <th class=tab_f_name_tb>user</th>
        </tr>
        <tr class="tab_f_tb_2">

            <td><input type="text" name="name"/></td>
            <td><input type="text" name="inn"/></td>

            <td>
                <select  id="hbNegative" name="hbNegative">
                    <option value="5">Так</option>
                    <option value="6">Ні</option>
                </select>
            </td>
            <td>
                <select  id="hbCheckKb" name="hbCheckKb">
                    <option value="7">Немає</option>
                    <option value="8">Низький КР</option>
                    <option value="9">Діюча прострочка</option>
                    <option value="10">Є, закритий</option>
                    <option value="11">Є, з прострочками</option>
                    <option value="12">Позитивна кредитна історія</option>
                    <option value="13">Не перевірялось</option>
                </select>
            </td>
            <td>
                <select  id="hbCheckProfit" name="hbCheckProfit">
                    <option value="14">Не перевірялось</option>
                    <option value="15">Підтверджуються</option>
                </select>
            </td>
            <td>
                <select  id="hbResult" name="hbResult">
                    <option value="16">Погоджено</option>
                    <option value="17">Відмовлено</option>
                    <option value="18">На розгляд РМ</option>
                    <option value="19">На доопрацювання</option>
                    <option value="20">Інше</option>
                </select>
            </td>
            <td>
                <select  id="hbType" name="hbType">
                    <option value="21">Клієнт</option>
                    <option value="22">Поручитель</option>
                    <option value="23">Член ГСК</option>
                </select>
            </td>
            <td><input type="text" name="commentary"/></td>
            <td><input type="text" name="description"/></td>
            <td>
                <select  id="user" name="user">
                <option value="1">admin</option>
                <option value="2">semykopna</option>
                <option value="3">borova</option>
                <option value="4">selivanovao</option>
                </select>
            </td>
        </tr>

    </table>
    <input type="submit" value="save"/>

</form>

</body>
</html>
