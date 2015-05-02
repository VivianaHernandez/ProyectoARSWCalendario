(function () {
    var app = angular.module('modone', ['ngRoute']);
    app.controller('controlador', function($scope, $http){
        $scope.nombre="";
        $scope.descripcion="";
        $scope.fecha=date;
        
        
       this.guardar= function () {
                    $http.get('rest/messages').
                            success(function (data) {
                                alert('Satisfactorio=)'+data);
                                $scope.fecha=fecha;
                            }).
                            error(function (data) {
                                alert('Error');
                            });          
                };
 });
})();





