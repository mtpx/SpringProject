<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageTitle</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="login">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="register">Register</a>
        </li>
    </ul>
</nav>
<button class="button test-ajax" type="button">Pobierz listę użytkowników</button>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Mail</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script type="text/javascript">
    const apiUrl = "http://localhost:8080/";
    const $list = $('.table tbody');

    $('.test-ajax').on('click', function () {
        const $btn = $(this);

        $.ajax({
            url: apiUrl + '/users',
            dataType: 'json'
        })
            .done((res) => {
                $list.empty();
                $.each(res, function (i, item) {
                    $list.append('<tr><th scope="row">' + res[i].id + '</th><td>' + res[i].firstname + '</td><td>' + res[i].lastname + '</td>' +
                        '<td>' + res[i].email + '</td><td><button class="btn btn-danger btn-xs btn-delete">Delete</button></td></tr>');
                })
            })
            .always(() => {
            });
    });
</script>
</body>
</html>
