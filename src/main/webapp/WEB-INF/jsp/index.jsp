<!DOCTYPE HTML>
<html>
<head>
    <title>Belong</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta charset="utf-8">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <link href="/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#DOB" ).datepicker();
        } );
    </script>
    <style type="text/css">
        body {
            background-color: azure;
        }
    </style>
</head>
<body>
<div id="mainDiv">

    <h2>
        <br> Welcome!<br>
    </h2>
    <hr>

    <div>
        <h3>Get all phone numbers</h3>
    </div>

    <form action="/listPhoneNumbers" method="GET">
        <div id="getNumbersBtn">
            <button>Get all phone numbers</button>
        </div>
    </form>
    <hr>

    <div>
        <h3>Get all phone numbers of a customer</h3>
    </div>

    <form action="/findUser" method="GET">
        <div id="customerIdDiv">
            <label for="id" class="required">Customer Id:</label>
            <input type="number" name="id" id="id" required>
        </div>
        <div id="searchCustomerBtn">
            <button>Search customer</button>
        </div>
    </form>

    <h4>OR</h4>

    <form action="/findUserByNameAndDOB" method="GET">
        <div>
            <div id="firstNameDiv">
                <label for="firstName" class="required">First Name:</label>
                <input type="text" name="firstName" id="firstName" required>
            </div>
            <div id="lastNameDiv">
                <label for="lastName" class="required">Last Name:</label>
                <input type="text" name="lastName" id="lastName" required>
            </div>
            <div id="birthdayDiv">
                <label for="DOB" class="required">Birthday:</label>
                <input type="text" id="DOB" name="DOB" required>
            </div>
            <div id="searchBtn">
                <button>Search customer</button>
            </div>
        </div>
    </form>
    <hr>

    <div>
        <h3>Activate a phone number</h3>
    </div>

    <form action="/activate" method="POST">
        <div id="activateDiv">
            <div>
                <label for="number" class="required">Phone Number:</label>
                <input type="text" name="number" id="number" required>
            </div>
            <h5>Note: Customer Id is required to activate an unassigned phone number.</h5>
            <div>
                <label for="customerId">Customer Id:</label>
                <input type="number" name="customerId" id="customerId">
            </div>
            <div id="activateBtn">
                <button>Activate number</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>