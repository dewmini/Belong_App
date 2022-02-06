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
<div id="phoneNumberDetailsDiv">

    <h2>
        <br> Phone Number Details <br>
    </h2>

    <c:if test="${result != null}">
        <c:if test="${result.get('error') == 'true'}">
            <h3 class="error">${result.get('msg')}</h3>
        </c:if>
        <c:if test="${result.get('error') == 'false'}">
            <h3 class="success">${result.get('msg')}</h3>
        </c:if>
    </c:if>

    <c:if test="${numberDetails != null}">
        <div>
            <div id="customerIdDiv">
                <label for="phoneNumber">Phone number:</label>
                <input type="text" name="phoneNumber" id="phoneNumber" readonly value="${numberDetails.number}">
            </div>
            <div id="statusDiv">
                <label for="status">Status:</label>
                <input type="text" name="status" id="status" readonly value="${numberDetails.status}">
            </div>
            <div id="startDateDiv">
                <label for="startDate">Start Date:</label>
                <input type="text" name="startDate" id="startDate" readonly value="${numberDetails.startDate}">
            </div>
            <div id="userDiv">
                <label for="userId">Customer Id:</label>
                <input type="text" id="userId" name="userId" readonly value="${numberDetails.userId}">
            </div>
        </div>
    </c:if>

    <form action="/" method="GET">
        <div id="backBtn">
            <button>Back</button>
        </div>
    </form>
</div>
</body>
</html>