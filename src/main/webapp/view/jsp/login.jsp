<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
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
                    <h3 class="panel-title">Login form</h3>
                </div>
                <div class="panel-body">
                    <form role="form" class="form">
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address">
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password">
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="Login" class="btn btn-info btn-block">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    apiUrl = "http://localhost:8080";
    const $form = $('.form');
    const $inputEmail = $('#email');
    const $inputPassword = $('#password');
    const $submitBtn = $form.find(":submit");


    $form.on("submit", function (e) {
        e.preventDefault();

        $.ajax({
            url: apiUrl + '/login',
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                email: $inputEmail.val(),
                password: $inputPassword.val()
            })
        })
            .done(function (res) {
                if(res>0){
                    alert("Użytkownik zalogowany");
                    localStorage.setItem('loggedUser',res);
                    window.location.href = "users";
                }else{
                    alert("Błędne dane logowania");
                }
            })
            .error(function () {
                alert("Błędne dane logowania");
            });
    });
</script>
</body>
</html>
