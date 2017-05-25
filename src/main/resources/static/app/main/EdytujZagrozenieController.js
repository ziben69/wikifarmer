angular.module('app').controller('EdytujZagrozenieController', function($rootScope, $scope, $localStorage, CrudService, $filter, $routeParams, CrudService, $location) {
    $scope.nazwa;
    $scope.opis;

    var zaladujDaneZagrozenia = function(id){

                CrudService
                    .znajdzJednoZagrozenie(id)
                    .then(function(response) {
                        if (response.status == 200) {
                            //alert(response.data.nazwa);
                            $scope.nazwa = response.data.nazwa;
                            $scope.opis = response.data.opis;
                        }
                    });

    }
    zaladujDaneZagrozenia($routeParams.id);
    $scope.edytuj = function(){
            var zagrozenie = {
                "id": $routeParams.id,
                "nazwa":$scope.nazwa,
                "opis": $scope.opis
            }
            CrudService
                .edytuj(zagrozenie, '/api/zagrozenie/edytuj')
                .then(function(response) {
                    if (response.status == 200) {
                        alert('Zagrozenie zostalo zmienione.');
                        $location.path('/zarzadzaj')
                    } else {
                        alert('Problem z modyfikacją.');
                    }
                });
    }

});