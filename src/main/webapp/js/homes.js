function prepareFullAddressData() {
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
        success: function(res) {
            alert("Addess added successfully");
            console.log(res);
            let homeData = {
                area: $('#area').val(),
                price: $('#price').val(),
                type: $('#type').val(),
                address: {
                    id: res.id
                }
            };
            saveHome(homeData)
        },
        error: function() {
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
        success: function(res) {
            alert("Home added successfully");
            console.log(data)
            getHomeStats();
        },
        error: function() {
            alert("Adding home error")
        }
    })
}

function appendToTable(res) {
    $list = $('.table tbody');
    $list.empty();
    $.each(res, function(i, item) {
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
            '<td>' + res[i].type + '</td>');
    })
}

function searchByAddress() {
    $.ajax({
            url: 'http://localhost:8080/userView/search',
            dataType: 'json',
            data: {
                street: $('#streetSearch').val(),
                city: $('#citySearch').val()
            }
        })
        .done((results) => {
            appendToTable(results);
        })
}

function getHomes() {
    $.ajax({
            url: 'http://localhost:8080/userView/',
            dataType: 'json'
        })
        .done((results) => {
            appendToTable(results);
        })
}

function getMyHomes() {
    $.ajax({
            url: 'http://localhost:8080/userView/' + localStorage.getItem('loggedUserId'),
            dataType: 'json'
        })
        .done((results) => {
            appendToTable(results);
        })
}

function getHomeStats() {
    $.ajax({
        url: 'http://localhost:8080/userView/' + localStorage.getItem('loggedUserId') + '/value',
        type: "GET",
        contentType: "application/json",
        success: function(res) {
            $("#valueOfHomes").text("    Value of my homes: " + res);
            console.log(res)
        }
    })
    $.ajax({
        url: 'http://localhost:8080/userView/' + localStorage.getItem('loggedUserId') + '/numberOfHomes',
        type: "GET",
        contentType: "application/json",
        success: function(res) {
            $("#numberOfHomes").text("    Number of my homes: " + res);
            console.log(res)
        }
    })
}