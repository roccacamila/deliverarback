var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/user', function (user) {
            showGreeting(JSON.parse(user.body).contenido);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendCliente() {
    stompClient.send("/app/cliente");
}

function sendProveedor() {
    stompClient.send("/app/proveedor");
}

function sendRepartidor() {
    stompClient.send("/app/repartidor");
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#sendCliente" ).click(function() { sendCliente(); });
	$( "#sendProveedor" ).click(function() { sendProveedor(); });
	$( "#sendRepartidor" ).click(function() { sendRepartidor(); });
});
