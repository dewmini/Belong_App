<!DOCTYPE HTML>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Belong</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="utf-8">
    <link href="/style.css" rel="stylesheet">
    <style type="text/css">
        body {
            background-color: azure;
        }
    </style>
</head>
<body>
<div id="phoneNumberListDiv">

    <h2>
        <br> All phone numbers <br>
    </h2>

    <div class="tableFixHead">
        <table id="phoneNumberListTbl">
            <thead>
            <tr>
                <th>Phone Number</th>
                <th>Status</th>
                <th>Start Date</th>
                <th>Customer Id</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${phoneNumberList}" var="item">
                    <tr>
                        <td>${item.number}</td>
                        <td>${item.status}</td>
                        <td>${item.startDate}</td>
                        <td>${item.userId}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <form action="/" method="GET">
        <div id="backBtn">
            <button>Back</button>
        </div>
    </form>


</div>
</body>
</html>