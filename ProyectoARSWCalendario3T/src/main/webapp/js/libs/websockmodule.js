angular.element(document).ready(function () {
    //Create stomp client over sockJS protocol
    var socket = new SockJS("/ProyectoARSWCalendario3T/sockets/ws");
    var stompClient = Stomp.over(socket);
   

    // Callback function to be called when stomp client is connected to server
    var connectCallback = function () {
        stompClient.subscribe('/topic/newmessage',
                function (data) {
                    
                    alert('ETNRO AL WEBSCO¡KE=)=)=)=))=)=');
                    console.log("got:" + data);
                    var message = JSON.parse(data.body);
                    console.log("got:" + message.destiny + "," + message.body);
                   alert('ETNRO AL WEBSCO¡KE');
                    var controllerElement = document.getElementById("controlId");
                    var controllerScope = angular.element(controllerElement).scope();
                    
                    controllerScope.$apply(function() {
                        controllerScope.varia= controllerScope.varia+ message.destiny + message.body;
                    
                    });
                    
                
                
                });
    };

    // Callback function to be called when stomp client could not connect to server
    var errorCallback = function (error) {
        alert(error.headers.message);
    };

    // Connect to server via websocket
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
});


