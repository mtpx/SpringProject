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
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Register form</h3>
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
                        <input type="submit" value="Submit address" id="submitAddressBtn" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    apiUrl = "http://localhost:8080";

    const $form = $('.form');
    $inputStreet = $('#street');
    $inputHouse = $('#house');
    $inputFlat = $('#flat');
    $inputCode = $('#code');
    $inputCity = $('#city');

    $form.on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            url: apiUrl + '/address',
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                street: $inputStreet.val(),
                house: $inputHouse.val(),
                flat: $inputFlat.val(),
                code: $inputCode.val(),
                city: $inputCity.val(),
                user_id: localStorage.getItem('loggedUserId')
            })
        })
            .done(function (res) {
                alert('Adres dodany');
            })
            .error(function () {
                alert('Błąd dodawania adresu');
            })
    });

</script>
</body>
</html>
