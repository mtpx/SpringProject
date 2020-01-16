<nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav" id="navbarList">
        <li class="nav-item">
            <a class="nav-link" id="loginMenuBtn" href="login">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="registerMenuBtn" href="register">Register</a>
        </li>
    </ul>
    <div id="userId" align="right"></div>
</nav>
<script>
     loggedUserId = localStorage.getItem('loggedUserId');
     if(loggedUserId>0){
        $("#userId").text("logged user: "+loggedUserId);
        $("#navbarList").append(
            '<li class="nav-item"><a class="nav-link" href="users">Users</a></li>'+
            '<li class="nav-item"><a class="nav-link" href="addresses">Addresses</a></li>'+
            '<li class="nav-item"><a class="nav-link" href="homes">Homes</a></li>'
            )
     }
</script>
<script type="text/javascript">
    $("#loginMenuBtn").on('click', function (){
        localStorage.setItem('loggedUserId','0');
    });
    $("#registerMenuBtn").on('click', function (){
        localStorage.setItem('loggedUserId','0');
    });

</script>