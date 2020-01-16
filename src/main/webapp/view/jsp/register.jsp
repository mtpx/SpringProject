<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
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
                                    <input type="text" name="first_name" id="first_name" class="form-control input-sm"
                                           placeholder="First Name">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-sm"
                                           placeholder="Last Name">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm"
                                   placeholder="Email Address">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-sm"
                                   placeholder="Password">
                        </div>
                        <br>
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
                        <input type="submit" value="Register" id="registerBtn" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    apiUrl = "http://localhost:8080";
    //
    // function prepareLoginData() {
    //     $('#registerBtn').click(function () {
    //         let loginData = {
    //             firstname: $('#first_name').val(),
    //             lastname: $('#last_name').val(),
    //             email: $('#email').val(),
    //             password: $('#password').val()
    //         };
    //         register(loginData);
    //     })
    // }
    //
    // function register(data) {
    //         $.ajax({
    //             url: "http://localhost:8080/user",
    //             type: "POST",
    //             contentType: "application/json",
    //             data: JSON.stringify(data)
    //         })
    // }

    const $form = $('.form');
    $inputFirstName = $('#first_name');
    $inputLastName = $('#last_name');
    $inputEmail = $('#email');
    $inputPassword = $('#password');

    $form.on("submit", function (e) {
        e.preventDefault();
        $.ajax({
            url: apiUrl + '/user',
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                firstname: $inputFirstName.val(),
                lastname: $inputLastName.val(),
                email: $inputEmail.val(),
                password: $inputPassword.val()
            })
        })
            .done(function (res) {
                alert('Użytkownik zarejestowany');
            })
            .error(function () {
                alert('Użytkownik neizarejestrowany');
            })
    });

</script>
</body>
</html>
