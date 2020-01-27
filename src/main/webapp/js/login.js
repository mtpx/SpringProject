function prepareLoginData() {
    let loginData = {
        email: $('#email').val(),
        password: $('#password').val()
    };
    login(loginData);
}

function login(data) {
    $.ajax({
        url: "http://localhost:8080/login",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function(res) {
            if (res > 0) {
                alert("Successfully logged");
                localStorage.setItem('loggedUserId', res);
                window.location.href = "users";
            } else {
                alert("Login error");
            }
        },
        error: function() {
            alert("Login error")
        }
    })
}