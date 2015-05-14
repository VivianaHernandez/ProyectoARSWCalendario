(function () {
    var app = angular.module('modone', []);

    app.controller('controlador',
            function ($scope, $http) {
                this.nombre = "";
                this.tarea;
                this.dia;
                this.month;
                this.year;
                
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
                              
                this.consultaNombre = function () {
                    alert('Grupo: ' + this.nombre);
                    $http.get('rest/grupos/' + this.nombre).
                            success(function (data){
                                
                                
                                
                                $scope.arregloTareas=data;
                                
                                
                                
                                
                               for (i = 0; i < data.tarea.length; i++) {
                                fecha=
                                alert('Tarea Prueba: '+data.tarea[i].nombre+'......'+
                                'Fecha Prueba: '+data.tarea[i].dia+'/'+data.tarea[i].month+'/'+data.tarea[i].year);
                                }
                               
                                
                              
                                
                                
                              
                            }).
                            error(function (data) {
                                alert('error');
                            });


                };
            }
    );

})();

