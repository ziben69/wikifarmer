angular.module('app').controller('EdytujUpraweController', function($rootScope, $scope, $localStorage, CrudService, $filter, $routeParams, CrudService, $location) {
    $scope.nazwa;
    $scope.opis;

    var zaladujDaneUprawy = function(id){

                CrudService
                    .znajdzJednaUprawe(id)
                    .then(function(response) {
                        if (response.status == 200) {
                            //alert(response.data.nazwa);
                            $scope.nazwa = response.data.nazwa;
                            $scope.opis = response.data.opis;
                        }
                    });

    }
    zaladujDaneUprawy($routeParams.id);
    $scope.edytuj = function(){
            var uprawa = {
                "id": $routeParams.id,
                "nazwa":$scope.nazwa,
                "opis": $scope.opis
            }
            CrudService
                .edytuj(uprawa, '/api/uprawa/edytuj')
                .then(function(response) {
                    if (response.status == 200) {
                        alert('Uprawa zostala zmieniona.');
                        $location.path('/zarzadzaj')
                    } else {
                        alert('Problem z modyfikacją.');
                    }
                });
    }

});