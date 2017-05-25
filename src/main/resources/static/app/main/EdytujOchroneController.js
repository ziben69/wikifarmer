angular.module('app').controller('EdytujOchroneController', function($rootScope, $scope, $localStorage, CrudService, $filter, $routeParams, CrudService, $location) {
    $scope.nazwa;
    $scope.opis;

    var zaladujDaneOchrony = function(id){

                CrudService
                    .znajdzJednaOchrone(id)
                    .then(function(response) {
                        if (response.status == 200) {
                            //alert(response.data.nazwa);
                            $scope.nazwa = response.data.nazwa;
                            $scope.opis = response.data.opis;
                        }
                    });

    }
    zaladujDaneOchrony($routeParams.id);
    $scope.edytuj = function(){
            var ochrona = {
                "id": $routeParams.id,
                "nazwa":$scope.nazwa,
                "opis": $scope.opis
            }
            CrudService
                .edytuj(ochrona, '/api/ochrona/edytuj')
                .then(function(response) {
                    if (response.status == 200) {
                        alert('Ochrona zostala zmieniona.');
                        $location.path('/zarzadzaj')
                    } else {
                        alert('Problem z modyfikacją.');
                    }
                });
    }

});