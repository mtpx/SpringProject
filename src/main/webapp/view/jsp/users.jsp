<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />
<button class="button test-ajax" id="getUsers" type="button">Get users</button>
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
    apiUrl = "http://localhost:8080";
    $list = $('.table tbody');
    $("#getUsers").on('click', function () {
        console.log(localStorage.getItem('loggedUser'));
        $btn = $(this);
        $.ajax({
            url: apiUrl + '/user',
            dataType: 'json'
        })
            .done((res) => {
                $list.empty();
                $.each(res, function (i, item) {
                    $list.append('<tr>' +
                        '<th scope="row" >' + res[i].id + '</th>' +
                        '<td>' + res[i].firstname + '</td>' +
                        '<td>' + res[i].lastname + '</td>' +
                        '<td>' + res[i].email + '</td>' +
                        '<td><button class="btn btn-danger btn-xs btn-delete" id='+res[i].id+'>Delete</button></td>' +
                        '</tr>');
                })
            })
    });
</script>
<script type="text/javascript">
    apiUrl = "http://localhost:8080";
    $(".table tbody").on('click','.btn-delete', function (){
        var id = this.id;
        row = $(this);
        $.ajax({
            url: apiUrl+'/user/'+id,
            type: 'DELETE',
            contentType:'application/json',
            dataType: 'text',
            success: function(result) {
                row.closest("tr").remove();
                alert('user: '+id+' deleted');
            },
            error: function(result) {
                alert('cannot delete user: '+id);
            }
        });
    });
</script>
</body>
</html>
