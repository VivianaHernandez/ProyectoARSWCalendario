(function () {
    var app = angular.module('modone', []);

    app.controller('controlregistro',
            function ($scope, $http) {
                this.nombre = "";
                $scope.arreglo = [];
                this.consulta = function () {
                    $http.get('rest/blueprints').
                            success(function (data) {
                                alert('Satisfactorio=)');
                                $scope.arreglo=data;
                            }).
                            error(function (data) {
                                alert('Error');
                            });
                    
                };
                
            }
    );

})();
