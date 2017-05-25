angular.module('app').controller('EdytujRegionController', function($rootScope, $scope, $localStorage, CrudService, $filter, $routeParams, CrudService, $location) {
    $scope.nazwa;
    $scope.opis;

    var zaladujDaneRegionu = function(id){

                CrudService
                    .znajdzJedenRegion(id)
                    .then(function(response) {
                        if (response.status == 200) {
                            //alert(response.data.nazwa);
                            $scope.nazwa = response.data.nazwa;
                            $scope.opis = response.data.opis;
                        }
                    });

    }
    zaladujDaneRegionu($routeParams.id);
    $scope.edytujRegion = function(){
            var region = {
                "id": $routeParams.id,
                "nazwa":$scope.nazwa,
                "opis": $scope.opis
            }
            CrudService
                .edytuj(region, '/api/region/edytuj')
                .then(function(response) {
                    if (response.status == 200) {
                        alert('Region zosta zmieniony.');
                        $location.path('/zarzadzaj')
                    } else {
                        alert('Problem z modyfikacją.');
                    }
                });
    }

});