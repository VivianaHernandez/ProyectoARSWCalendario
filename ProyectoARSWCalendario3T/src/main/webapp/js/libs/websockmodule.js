angular.element(document).ready(function () {
    //Create stomp client over sockJS protocol
    var socket = new SockJS("/ProyectoARSWCalendario3T/docu    mento/sockets/ws");
    var stompClient = Stomp.over(socket);
   

    // Callback function to be called when stomp client is connected to server
    var connectCallback = function () {
        stompClient.subscribe('/topic/newmessage',
                function (data) {
                   alert('entro a websocket************');
                    console.log("got:" + data);
                    var message = JSON.parse(data.body);
                    console.log("got:" + message.destiny + "," + message.body);
                   
                    var controllerElement = document.getElementById("controlId");
                    var controllerScope = angular.element(controllerElement).scope();
                    
                    controllerScope.$apply(function() {
                        controllerScope.varia= controllerScope.varia + message.destiny + "," + message.body;
                    
                    });
                    
                    var jsonstr = JSON.stringify({'destiny': 'servidor', 'body':'acuse de recibo' });
                    stompClient.send("/app/rutaMensajesEntrantes", {}, jsonstr);
                
                });
    };

    // Callback function to be called when stomp client could not connect to server
    var errorCallback = function (error) {
        alert(error.headers.message);
    };

    // Connect to server via websocket
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
});                            


