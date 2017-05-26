angular.module('app').controller('DodajController', function($rootScope, $scope, $location, CrudService, $routeParams, $route) {
    $scope.region;
    $scope.uprawa;
    $scope.zagrozenie;
    $scope.ochrona;

    $scope.dodajRegion = function() {
        CrudService
            .dodajRegion($scope.region)
            .then(function(response) {
                if (response.status == 200) {
                    czyscPola($scope.region);
                    alert('Region zosta dodany.');
                    $route.reload();
                } else {
                    alert('Problem z dodaniem regionu.');
                }
            });
    }
    $scope.dodajUprawe = function() {
        CrudService
            .dodajUprawe($scope.uprawa)
            .then(function(response) {
                if (response.status == 200) {
                    czyscPola($scope.uprawa);
                    alert('Uprawa zostala dodany.');
                    $route.reload();
                } else {
                    alert('Problem z dodaniem regionu.');
                }
            });
    }
    $scope.dodajZagrozenie = function() {
        CrudService
            .dodajZagrozenie($scope.zagrozenie)
            .then(function(response) {
                if (response.status == 200) {
                    czyscPola($scope.zagrozenie);
                    alert('Zagrozenie zosta dodany.');
                    $route.reload();
                } else {
                    alert('Problem z dodaniem zagrozenia.');
                }
            });
    }
    $scope.dodajOchrone = function() {
        CrudService
            .dodajOchrone($scope.ochrona)
            .then(function(response) {
                if (response.status == 200) {
                    czyscPola($scope.ochrona);
                    alert('Ochrona zosta dodany.');
                    $route.reload();
                } else {
                    alert('Problem z dodaniem regionu.');
                }
            });
    }
    var czyscPola = function(obj) {
        obj.nazwa = '';
        obj.opis = '';
    }
//*********************************************************************************************************************
//Przypisz uprawy do regionu
    $scope.wybranyRegion;
    $scope.wszystkieRegiony = new Array();

    $scope.wszystkieUprawy = new Array();
    $scope.wybraneUprawy;

    var wczytajWszystkieRegiony = function() {
        CrudService
            .znajdzWszystkieRegiony()
            .then(function(response) {
                if (response.status == 200) {
                    $scope.wszystkieRegiony = response.data;
                }
            });
    }
    wczytajWszystkieRegiony();
    //Wczytaj wszystkie uprawy
    var wczytajWszystkieUprawy = function() {
        CrudService
            .znajdzWszystkieUprawy()
            .then(function(response) {
                if (response.status == 200) {
                    $scope.wszystkieUprawy = response.data;
                }
            });
    }
    wczytajWszystkieUprawy();

    $scope.zatwierdzUprawyWregionie = function() {
        var idUpraw = [];
        for(var i=0; i<$scope.wybraneUprawy.length; i++){
            console.log($scope.wybraneUprawy[i].id);
            idUpraw.push($scope.wybraneUprawy[i].id);
        }
        var obj = {
            "id": $scope.wybranyRegion.id,
            "ids": idUpraw
        }
        CrudService
            .przypiszUprawyDoRegionu(obj)
            .then(function(response) {
                if (response.status == 200) {
                    alert('Powiązanie dodane.');
                }
            });
    }

//**********************************************************************************************************************
//Przypisz zagrozenia do uprawy

        $scope.wybranaUprawaTab6;
        $scope.wszystkieZagrozenia = new Array();
        $scope.wybraneZagrozenia;
        var wczytajWszystkieZagrozenia = function() {
            CrudService
                .znajdzWszystkieZagrozenia()
                .then(function(response) {
                    if (response.status == 200) {
                        $scope.wszystkieZagrozenia = response.data;
                    }
                });
        }
       wczytajWszystkieZagrozenia();

           $scope.zatwierdzZagrozeniaDlaUprawy = function() {
               var idUpraw = [];
               for(var i=0; i<$scope.wybraneZagrozenia.length; i++){
                   idUpraw.push($scope.wybraneZagrozenia[i].id);
               }
               var obj = {
                   "id": $scope.wybranaUprawaTab6.id,
                   "ids": idUpraw
               }
               CrudService
                   .przypiszZagrozeniaDoUprawy(obj)
                   .then(function(response) {
                       if (response.status == 200) {
                           alert('Powiązanie dodane.');
                       }
                   });
           }
//**********************************************************************************************************************
//Przypisz ochrony do zagrozenia
        $scope.wybraneZagrozenieTabLast;
        $scope.wszystkieOchrony = new Array();
        $scope.wybraneOchrony;
        var wczytajWszystkieOchrony = function() {
            CrudService
                .znajdzWszystkieOchrony()
                .then(function(response) {
                    if (response.status == 200) {
                        $scope.wszystkieOchrony = response.data;
                    }
                });
        }
       wczytajWszystkieOchrony();

           $scope.zatwierdzOchronyDlaZagrozenia = function() {
               var idOchron = [];
               for(var i=0; i<$scope.wybraneOchrony.length; i++){
                   idOchron.push($scope.wybraneOchrony[i].id);
               }
               var obj = {
                   "id": $scope.wybraneZagrozenieTabLast.id,
                   "ids": idOchron
               }
               CrudService
                   .przypiszOchronyDoZagrozenia(obj)
                   .then(function(response) {
                       if (response.status == 200) {
                           alert('Powiązanie dodane.');
                       }
                   });
           }

           $scope.usunUprawe = function(uprawa){
                           CrudService
                               .usun(uprawa.id, '/api/uprawa/usun')
                               .then(function(response) {
                                   if (response.status == 200) {
                                       alert('Usunieto uprawe.');
                                       $route.reload();
                                   }
                               });
           }
});