(function () {
    var app = angular.module('modone', []);

    app.controller('controlador',
            function ($scope, $http) {
                
                this.nombre = ""; 
                $scope.descripcion = "";
               
                $scope.tarea = "";
                this.tarea1="";
                $scope.fechas="";
                $scope.fecha="";
                this.dia;
                this.month;
                this.year;

                $scope.arregloGrupos = [];
                $scope.arregloTareas = [];
                $scope.arreglo = [];
                
//-----------------------------------------------------------------------------------------------------//                
//--------------------------------------------Funciones para consultar---------------------------------//
//-----------------------------------------------------------------------------------------------------//
                this.consultaGrupo = function () {
                    
                    $http.get('rest/grupos').
                            success(function (data) {
                                alert('hola');
                                $scope.arregloGrupos = data;
                            }).
                            error(function (data) {
                                alert('Error');
                            });

                };

                this.consultaNombre = function () {
                   
                    $http.get('rest/grupos/' + this.nombre).
                            success(function (data) {
                                    
                                for (i = 0; i < data.tarea.length; i++) {
                                    $scope.arregloTareas[i] = data.tarea[i].nombre;
                                }
                            }).
                            error(function (data) {
                                alert('error');
                            });
                };
      
                this.consultarTodo = function () {
                    $http.get('rest/grupos/' + this.nombre).
                            success(function (data) {

                            for (i = 0; i < data.tarea.length; i++) {
                                   this.tarea1=$scope.tarea;  
                                    if(data.tarea[i].nombre==this.tarea1)
                                    {
                                        var message = data.tarea[i];
                                       $scope.descripcion=data.tarea[i].descripcion;  
                                       $scope.fechas=data.tarea[i].dia+"/"+data.tarea[i].month+"/"+data.tarea[i].year;
                                      console.log(message['fechas']); 
                                    }
                                }                     
                            }).
                            error(function (data) {
                                alert('error');
                            }); 
                };  
                
//-----------------------------------------------------------------------------------------------------//                
//--------------------------------------------Funciones para crear---------------------------------//
//-----------------------------------------------------------------------------------------------------//                
               $scope.enviar = function () {
                   alert('pasooooo');
                    $http.post('rest/grupos/'+this.nombre,{"nombre":this.nombre,"descripcion":$scope.descripcion,
                                "fecha":$scope.fecha,"fechas":"","dia":$scope.dia,"month":$scope.month,"year":$scope.year}).
                            success(function (data) {
                                alert('trae en lafecha: '+$scope.fecha);
                            }).
                            error(function (data) {
                                alert('error');
                            }); 
                };  
            }
    );

})();

