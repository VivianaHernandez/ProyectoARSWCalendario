(function () {
    var app = angular.module('modone', []);

    app.controller('controlador',
            function ($scope, $http) {
                
                this.nombre = ""; 
                $scope.descripcion = "";
               
                $scope.tarea = "";
                this.tarea1="";

                this.dia;
                this.month;
                this.year;

                $scope.arregloGrupos = [];
                $scope.arregloTareas = [];
                $scope.arreglo = [];
/*---------------Funciones para consultar-----------------*/
                this.consultaGrupo = function () {
                    
                    $http.get('rest/grupos').
                            success(function (data) {
                                alert('Satisfactorio=)' + data);
                                $scope.arregloGrupos = data;
                            }).
                            error(function (data) {
                                alert('Error');
                            });

                };

                this.consultaNombre = function () {
                    alert('Grupo: ' + this.nombre);
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
                
                
                 this.consultaNombre = function () {
                    alert('Grupo: ' + this.nombre);
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
                                  
                                   alert('Nombre Tarea: '+data.tarea[i].nombre);
                                   alert('This.tarea1: '+ this.tarea1);
           
                                    if(data.tarea[i].nombre==this.tarea1)
                                    {
                                        alert('Entro=)=)=)=)=)=)=)=)=)=)=)=)=)=)=)');
                                        
                                      descripcion=data.tarea[i].descripcion;  
                                      
                                       alert('Descripcion: '+data.tarea[i].descripcion);
                                    
                                    }
                                }
                                
                                alert('Descripcion=): '+descripcion);
                                
                                
                            }).
                            error(function (data) {
                                alert('error');
                            });
                    
                   
                };
                
                
            }
    );

})();

