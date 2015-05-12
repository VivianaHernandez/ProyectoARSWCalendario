(function () {
    var app = angular.module('modone', []);

    app.controller('controlregistro',
            function ($scope, $http) {
                this.nombre = "";
                $scope.arreglo = [];
                this.consulta = function () {
                     alert('Entro');
                    $http.get('rest/grupos').
                            success(function (data) {
                                alert('Satisfactorio=)');
                                $scope.arreglo=data;
                            }).
                            error(function (data) {
                                alert('Error');
                            });
                    
                };
                              
                this.planoact = function () {
                    alert('Nombre: ' + this.nombre);
                    $http.get('rest/grupos/' + this.nombre).
                            success(function (data) {
                                //alert(angular.toJson(data));
                              
                            }).
                            error(function (data) {
                                alert('error');
                            });


                };
            }
    );

})();

