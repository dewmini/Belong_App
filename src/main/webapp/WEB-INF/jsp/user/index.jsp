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
<div id="userDetailsDiv">

    <h2>
        <br> User Details <br>
    </h2>

    <c:if test="${error != null}">
        <h3 class="error">${error}</h3>
    </c:if>

    <c:if test="${error == null}">
        <div>
            <div id="customerIdDiv">
                <label for="customerId">Customer Id:</label>
                <input type="text" name="customerId" id="customerId" readonly value="${user.id}">
            </div>
            <div id="firstNameDiv">
                <label for="firstName">First Name:</label>
                <input type="text" name="firstName" id="firstName" readonly value="${user.firstName}">
            </div>
            <div id="lastNameDiv">
                <label for="lastName">Last Name:</label>
                <input type="text" name="lastName" id="lastName" readonly value="${user.lastName}">
            </div>
            <div id="birthdayDiv">
                <label for="DOB">Birthday:</label>
                <input type="text" id="DOB" name="DOB" readonly value="${user.dob}">
            </div>
            <div id="genderDiv">
                <label for="gender">Gender:</label>
                <input type="text" name="gender" id="gender" readonly value="${user.gender}">
            </div>
            <div id="emailDiv">
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" readonly value="${user.email}">
            </div>
            <div id="addressDiv">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" readonly value="${user.address}">
            </div>

            <div id="userPhoneNumbersDiv">
                <h3>Phone numbers</h3>
                <div class="tableFixHead">
                    <table id="phoneNumberListTbl">
                        <thead>
                        <tr>
                            <th>Phone Number</th>
                            <th>Status</th>
                            <th>Start Date</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${user.getPhoneNumbers()}" var="item">
                                <tr>
                                    <td>${item.number}</td>
                                    <td>${item.status}</td>
                                    <td>${item.startDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
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