function prepareRegisterData() {
    let registerData = {
        firstname: $('#first_name').val(),
        lastname: $('#last_name').val(),
        email: $('#email').val(),
        password: $('#password').val()
    };
    register(registerData);
}

function register(data) {
    $.ajax({
        url: "http://localhost:8080/user",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function() {
            alert("Successfully registered");
        },
        error: function() {
            alert("Registration error")
        }
    })
}