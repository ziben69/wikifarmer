angular.module('app').controller('MainController', function($rootScope, $scope, $localStorage, CrudService, $filter) {
    $scope.message = 'MainController 1';
    $scope.regiony = new Array();
    $scope.wybranyRegion;
    $scope.test;
    var znajdzRegiony = function() {
        CrudService
            .znajdzWszystkieRegiony()
            .then(function(response) {
                if (response.status == 200) {
                    $scope.regiony = response.data;
                }
            });

    }
    znajdzRegiony();

    $scope.pokazUprawy = function(){
        console.log('Test' + $scope.wybranyRegion.uprawy);
    }

    $scope.wybranaUprawa;
    $scope.znajdzDaneWybranejUprawy = function(id){
            CrudService
                .znajdzJednaUprawe(id)
                .then(function(response) {
                    if (response.status == 200) {
                        $scope.wybranaUprawa = response.data;
                    }
                });
    }

        $scope.wybraneZagrozenie;
        $scope.znajdzDaneWybranegoZagrozenia = function(id){
                CrudService
                    .znajdzJednoZagrozenie(id)
                    .then(function(response) {
                        if (response.status == 200) {
                            $scope.wybraneZagrozenie = response.data;
                        }
                    });
        }

        $scope.wybierzRegionZPrzycisku = function (nazwa) {
            for(var i=0; i<$scope.regiony.length; i++){
                if(angular.equals(nazwa, $scope.regiony[i].nazwa)){
                    $scope.wybranyRegion = $scope.regiony[i];
                }
            }
        }

         $scope.znajdzDaneWybranegoRegionu = function(id){
                    CrudService
                        .znajdzJedenRegion(id)
                        .then(function(response) {
                            if (response.status == 200) {
                                $scope.wybranyRegion = response.data;
                            }
                        });
            }
            $scope.wartosc = false;
});