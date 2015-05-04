(function () {
    var app = angular.module('modone', ['ngRoute']);
    app.controller('controlador', function($scope, $http){
        $scope.cuerpo="";
        $scope.destino="";
        $scope.mensajes="";
        $scope.grupo="";
        $scope.nombre="";
        $scope.fecha=new Date();
        $scope.descripcion="";
        
        
        $scope.enviar=function(){
            $http.post('rest/messages', {"destiny":$scope.nombre,"body":$scope.descripcion}).
            success(function(data){alert('Hizo Peticion =)')});
        }
         
    });
})();








