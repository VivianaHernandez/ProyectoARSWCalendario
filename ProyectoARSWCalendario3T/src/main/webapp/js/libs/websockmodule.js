angular.element(document).ready(function () {
    //Create stomp client over sockJS protocol
    var socket = new SockJS("/ProyectoARSWCalendario3T/sockets/ws");
    var stompClient = Stomp.over(socket);
    
    // Callback function to be called when stomp client is connected to server
    var connectCallback = function () {
        stompClient.subscribe('/topic/newmessage',
                function (data) {
                    console.log("got:" + data);
                    var message = JSON.parse(data.body);
                    console.log("got:" + message.destiny + "," + message.body);
                    
                    var controllerElement = document.getElementById("control");
                    var controllerScope = angular.element(controllerElement).scope();             
                     alert('Entro');
                    controllerScope.$apply(function() {
                    controllerScope.cuerpo="\n"+controllerScope.cuerpo+message.destiny + "," + message.body+"\n";
                    alert('Entro=)');
                    });     
                }
        );
    };    
    
    
    
    // Callback function to be called when stomp client could not connect to server
    var errorCallback = function (error) {
        alert(error.headers.message);
    };
    // Connect to server via websocket
    
      
    
    stompClient.connect("guest", "guest", connectCallback, errorCallback);  
    
    var jsonstr = JSON.stringify({"destiny": "servidor", "body":"acuse de recibo"});
    stompClient.send("/app/newmessage", {},jsonstr);
    

    
});


