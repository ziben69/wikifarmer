angular.module('app').service('CrudService', function($http) {
    this.dodajRegion = function(region) {
        return $http({
            method: "POST",
            url: '/api/region/dodaj',
            data: region,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }
    this.znajdzWszystkieRegiony = function() {
        var url = 'api/region/wszystkie';
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.znajdzJedenRegion = function(id) {
        var url = 'api/region/id/' + id;
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.dodajUprawe = function(uprawa) {
        return $http({
            method: "POST",
            url: '/api/uprawa/dodaj',
            data: uprawa,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.dodajZagrozenie = function(zagrozenie) {
        return $http({
            method: "POST",
            url: '/api/zagrozenie/dodaj',
            data: zagrozenie,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.dodajOchrone = function(ochrona) {
        return $http({
            method: "POST",
            url: '/api/ochrona/dodaj',
            data: ochrona,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }
    this.znajdzWszystkieUprawy = function() {
        var url = 'api/uprawa/wszystkie';
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.przypiszUprawyDoRegionu = function(regionIuprawy) {
        return $http({
            method: "POST",
            url: '/api/przypisz/uprawy/do/regionu',
            data: regionIuprawy,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.znajdzWszystkieZagrozenia = function() {
        var url = 'api/zagrozenia/wszystkie';
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.przypiszZagrozeniaDoUprawy = function(uprawaIZagrozenia) {
        return $http({
            method: "POST",
            url: '/api/przypisz/zagrozenia/do/uprawy',
            data: uprawaIZagrozenia,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.znajdzJednaUprawe = function(id) {
        var url = 'api/uprawa/id/' + id;
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.znajdzWszystkieOchrony = function() {
        var url = 'api/ochrony/wszystkie';
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }
    this.znajdzJednaOchrone = function(id) {
        var url = 'api/ochrona/id/' + id;
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.przypiszOchronyDoZagrozenia = function(zagrozenieIOchrony) {
        return $http({
            method: "POST",
            url: '/api/przypisz/ochrony/do/zagrozenia',
            data: zagrozenieIOchrony,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.znajdzJednoZagrozenie = function(id) {
        var url = 'api/zagrozenie/id/' + id;
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    this.edytuj = function(region, url) {
        return $http({
            method: "POST",
            url: url,
            data: region,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response;
        });
    }

    // this.edytujRegion = function(region) {
    //     return $http({
    //         method: "POST",
    //         url: '/api/region/edytuj',
    //         data: region,
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     }).then(function successCallback(response) {
    //         return response;
    //     }, function errorCallback(response) {
    //         return response;
    //     });
    // }
});