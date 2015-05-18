/* global date */

(function () {
    var app = angular.module('modone', []);

    app.controller('controlador',
            function ($scope, $http) {
                
                $scope.nombre = ""; 
                $scope.nombtarea=""
                $scope.descripcion = "";
               
                $scope.tarea = "";
                this.tarea1="";
                $scope.fechas="";
                $scope.fecha=new Date();
                $scope.dia;
                $scope.month;
                $scope.consulta="";
                $scope.arr=[];

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
                   
                    $http.get('rest/grupos/' + $scope.nombre).
                            success(function (data) {
                                $scope.arr=data.tarea;
                                nom=[];
                                for(i=0;i<data.tarea.length;i++){
                                    nom[i]=data.tarea[i].nombre;
                                }
                                $scope.arregloTareas=nom;
                                
                            }).
                            error(function (data) {
                                alert('error');
                            });
                };
      
                this.consultarTodo = function () {
                    $http.get('rest/grupos/' + $scope.nombre).
                            success(function (data) {
                            for(i=0;i<$scope.arr.length;i++){
                                    if($scope.tarea==$scope.arr[i].nombre){
                                        $scope.descripcion=$scope.arr[i].descripcion;
                                        $scope.dia=$scope.arr[i].dia;
                                        $scope.month=$scope.arr[i].month;
                                        if($scope.arr[i].year==115){
                                            $scope.arr[i].year=2015;
                                        }
                                        alert('alertaaaaaaa'+$scope.arr[i].year);
                                        $scope.year=$scope.dia+"/"+$scope.month+"/"+$scope.arr[i].year;
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
                   
                                $scope.dia=$scope.fecha.getDate();
                                $scope.month=$scope.fecha.getMonth();
                                $scope.fechas=$scope.fecha.getFullYear()+"";
                    $http.post('rest/grupos/'+$scope.nombre,{"nombre":$scope.nombtarea,"descripcion":$scope.descripcion,"fecha":$scope.fecha,"fechas":$scope.year,"dia":$scope.dia,"month":$scope.month,"year":$scope.year}).
                            success(function (data) {
                                
                            }).
                            error(function (data) {
                                alert('error');
                            }); 
                };  
            }
    );

})(); 