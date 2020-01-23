<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Addresses Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Add new home</h3>
                </div>
                <div class="panel-body">
                    <form role="form" class="form">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="street" id="street" class="form-control input-sm"
                                           placeholder="Street">
                                </div>
                            </div>
                            <div class="col-xs-3 col-sm-3 col-md-3">
                                <div class="form-group">
                                    <input type="text" name="house" id="house" class="form-control input-sm"
                                           placeholder="House">
                                </div>
                            </div>
                            <div class="col-xs-3 col-sm-3 col-md-3">
                                <div class="form-group">
                                    <input type="text" name="flat" id="flat" class="form-control input-sm"
                                           placeholder="Flat">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-4 col-sm-4 col-md-4">
                                <div class="form-group">
                                    <input type="text" name="code" id="code" class="form-control input-sm"
                                           placeholder="Code">
                                </div>
                            </div>
                            <div class="col-xs-8 col-sm-8 col-md-8">
                                <div class="form-group">
                                    <input type="text" name="city" id="city" class="form-control input-sm"
                                           placeholder="City">
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="area" id="area" class="form-control input-sm"
                                           placeholder="Area">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="price" id="price" class="form-control input-sm"
                                           placeholder="Price">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12">
                                <div class="form-group">
                                    <input type="text" name="type" id="type" class="form-control input-sm"
                                           placeholder="Type">
                                </div>
                            </div>
                        </div>
                        <input type="button" value="Submit address" id="submitHomeBtn" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<button id="getHomes" type="button">Get homes</button>
<button id="getMyHomes" type="button">Get my homes</button>
<table class="table">
    <thead>
    <tr>
        <th scope="col">HomeId</th>
        <th scope="col">AddressId</th>
        <th scope="col">UserId</th>
        <th scope="col">Street</th>
        <th scope="col">House</th>
        <th scope="col">Flat</th>
        <th scope="col">Code</th>
        <th scope="col">City</th>
        <th scope="col">Area</th>
        <th scope="col">Price</th>
        <th scope="col">Type</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script type="text/javascript">
    $list = $('.table tbody');
    $("#getHomes").on('click', function () {
        console.log(localStorage.getItem('loggedUserId'));
        $btn = $(this);
        $.ajax({
            url: 'http://localhost:8080/userView/',
            dataType: 'json'
        })
            .done((res) => {
                $list.empty();
                $.each(res, function (i, item) {
                    $list.append(
                        '<tr><th scope="row" >' + res[i].homeId + '</th>' +
                        '<td>' + res[i].addressId + '</td>' +
                        '<td>' + res[i].userId + '</td>' +
                        '<td>' + res[i].street + '</td>' +
                        '<td>' + res[i].house + '</td>' +
                        '<td>' + res[i].flat + '</td>' +
                        '<td>' + res[i].code + '</td>' +
                        '<td>' + res[i].city + '</td>' +
                        '<td>' + res[i].area + '</td>' +
                        '<td>' + res[i].price + '</td>' +
                        '<td>' + res[i].type + '</td>' +
                        '<td><button class="btn btn-danger btn-xs btn-delete" id='+res[i].id+'>Delete</button></td></tr>');
                })
            })
    });
</script>
<script type="text/javascript">
    $list = $('.table tbody');
    $("#getMyHomes").on('click', function () {
        console.log(localStorage.getItem('loggedUserId'));
        console.log()
        $btn = $(this);
        $.ajax({
            url: 'http://localhost:8080/userView/'+localStorage.getItem('loggedUserId'),
            dataType: 'json'
        })
            .done((res) => {
                $list.empty();
                $.each(res, function (i, item) {
                    $list.append(
                        '<tr><th scope="row" >' + res[i].homeId + '</th>' +
                        '<td>' + res[i].addressId + '</td>' +
                        '<td>' + res[i].userId + '</td>' +
                        '<td>' + res[i].street + '</td>' +
                        '<td>' + res[i].house + '</td>' +
                        '<td>' + res[i].flat + '</td>' +
                        '<td>' + res[i].code + '</td>' +
                        '<td>' + res[i].city + '</td>' +
                        '<td>' + res[i].area + '</td>' +
                        '<td>' + res[i].price + '</td>' +
                        '<td>' + res[i].type + '</td>' +
                        '<td><button class="btn btn-danger btn-xs btn-delete" id='+res[i].id+'>Delete</button></td></tr>');
                })
            })
    });
</script>
<script type="text/javascript">
    $('#submitHomeBtn').click(function () {
        let addressData = {
            street: $('#street').val(),
            house: $('#house').val(),
            flat: $('#flat').val(),
            code: $('#code').val(),
            city: $('#city').val(),
            user:{
                id: localStorage.getItem('loggedUserId')
            }
        };

        saveAddress(addressData);
    });

    function saveAddress(data) {
        $.ajax({
            url: "http://localhost:8080/address",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (res) {
                alert("Addess added successfully");
                console.log(res);
                let homeData = {
                    area: $('#area').val(),
                    price: $('#price').val(),
                    type: $('#type').val(),
                    address:{
                        id: res.id
                    }
                };
                saveHome(homeData)
            },
            error: function () {
                alert("Adding address error")
            }
        })
    }

    function saveHome(data) {
        $.ajax({
            url: "http://localhost:8080/home",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (res) {
                alert("Home added successfully");
                console.log(data)
            },
            error: function () {
                alert("Adding home error")
            }
        })
    }
</script>
</body>
</html>
