function getMyAddresses() {
    $.ajax({
            url: 'http://localhost:8080/address/' + localStorage.getItem('loggedUserId'),
            dataType: 'json'
        })
        .done((res) => {
            $list = $('.table tbody');
            $list.empty();
            $.each(res, function(i, item) {
                $list.append(
                    '<tr><th scope="row" >' + res[i].id + '</th>' +
                    '<td>' + res[i].street + '</td>' +
                    '<td>' + res[i].house + '</td>' +
                    '<td>' + res[i].flat + '</td>' +
                    '<td>' + res[i].code + '</td>' +
                    '<td>' + res[i].city + '</td>' +
                    '<td>' + res[i].user.id + '</td>'
                );
            });
        });
}

function getAddresses() {
    $.ajax({
            url: 'http://localhost:8080/address/',
            dataType: 'json'
        })
        .done((res) => {
            $list = $('.table tbody');
            $list.empty();
            $.each(res, function(i, item) {
                $list.append(
                    '<tr><th scope="row" >' + res[i].id + '</th>' +
                    '<td>' + res[i].street + '</td>' +
                    '<td>' + res[i].house + '</td>' +
                    '<td>' + res[i].flat + '</td>' +
                    '<td>' + res[i].code + '</td>' +
                    '<td>' + res[i].city + '</td>' +
                    '<td>' + res[i].user.id + '</td>'
                );
            });
        });
}

function prepareAddressData() {
    let addressData = {
        street: $('#street').val(),
        house: $('#house').val(),
        flat: $('#flat').val(),
        code: $('#code').val(),
        city: $('#city').val(),
        user: {
            id: localStorage.getItem('loggedUserId')
        }
    };
    saveAddress(addressData);
}

function saveAddress(data) {
    $.ajax({
        url: "http://localhost:8080/address",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function() {
            alert("Addess added successfully");
            console.log(data)
        },
        error: function() {
            alert("Adding address error")
        }
    })
}