var app = angular.module('app', ['ngRoute',
'ngResource',
'ui.bootstrap',
'ngStorage',
'multipleSelect']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: '/app/views/main/main.html',
            controller: 'MainController'
        })
        .when('/login', {
            templateUrl: '/app/views/user/login.html',
            controller: 'LoginController'
        })
        .when('/users', {
            templateUrl: '/app/views/user/users.html',
            controller: 'UserController'
        })
        .when('/zarzadzaj', {
            templateUrl: '/app/views/main/dodaj.html',
            controller: 'DodajController'
        })
        .when('/region/edytuj/:id', {
            templateUrl: '/app/views/main/edytujRegion.html',
            controller: 'EdytujRegionController'
         })
        .when('/uprawa/edytuj/:id', {
            templateUrl: '/app/views/main/edytujUprawe.html',
            controller: 'EdytujUpraweController'
        })
        .when('/zagrozenie/edytuj/:id', {
            templateUrl: '/app/views/main/edytujZagrozenie.html',
            controller: 'EdytujZagrozenieController'
        })
        .when('/ochrona/edytuj/:id', {
            templateUrl: '/app/views/main/edytujOchrone.html',
            controller: 'EdytujOchroneController'
        })
        .otherwise({
            redirectTo: '/'
        });
});

app.run(function ($localStorage) {
    if ($localStorage.currentUser == undefined) {
        $localStorage.currentUser=null;
    }
});

app.filter('removeSpaces', function() {
    return function(string) {
        if (!angular.isString(string)) {
            return string;
        }
        return string.replace(/[\s]/g, '');
    };
});