(function () {
    var app = angular.module('modone', []);

    app.controller('controlador',
            function ($scope, $http) {
                this.nombre = "";
                this.fecha;
                
                $scope.arregloGrupos = [];
                $scope.arregloTareas = [];
               
                this.consultaGrupo = function () {
                     alert('Entro');
                    $http.get('rest/grupos').
                            success(function (data) {
                                alert('Satisfactorio=)'+data);
                                $scope.arregloGrupos=data;
                                
                            }).
                            error(function (data) {
                                alert('Error');
                            });
                    
                };
                              
                this.consultaFecha = function () {
                    alert('Grupo: ' + this.nombre);
                    $http.get('rest/grupos/' + this.nombre).
                            success(function (data) {
                                alert('Prueba: '+data.tarea[0].nombre);
                                
                                
                                $scope.arregloTareas=data;
                                
                                 alert('tamaño '+data.tarea.length)
                                 fecha = [];
                                 for (i = 0; i < data.tarea.length; i++) {
                                //fecha[i]=data.tarea[i].fecha;
                                alert('fecha Prueba: '+data.tarea[i].getDia());
                                }
                                
                                
                                
                              
                            }).
                            error(function (data) {
                                alert('error');
                            });


                };
            }
    );

})();

