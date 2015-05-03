(function () {
    var app = angular.module('modone', ['ngRoute']);
    app.controller('controlador', function($scope, $http){
         $scope.grupo="";
         $scope.nombre="";
         $scope.descripcion="";
           
        $scope.cuerpo="";
        $scope.destino="";
        $scope.mensajes="";
        
        $scope.enviar=function(){
             $http.post('rest/messages', {"destiny":$scope.nombre,"body":$scope.descripcion}).
            success(function(data){alert('Hizo Peticion =)'+$scope.nombre)});
        }
        
        
        
        
          this.consulta = function () {
                    $http.get('rest/blueprints/' + $scope.nombre).
                            success(function (data) {
                                alert('Satisfactorio=)');
                                $scope.nombre=data;
                            }).
                            error(function (data) {
                                alert('Error');
                            });
                    
                };
        
      
        
        
        
    });
})();









