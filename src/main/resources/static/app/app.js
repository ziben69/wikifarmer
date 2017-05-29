var app = angular.module('app', ['ngRoute',
'ngResource',
'ui.bootstrap',
'ngStorage',
'multipleSelect']);

app.config(function($routeProvider) {
    $routeProvider
        .when('/main', {
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
         .when('/register', {
                    templateUrl: '/app/views/user/register.html',
                    controller: 'RegisterController'
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

app.run(function($localStorage, $sessionStorage, $rootScope, LoginService, $location) {
    var checkUserInLocalStorage = function() {
        if ($sessionStorage.currentUser == undefined) {
            $sessionStorage.currentUser = null;
            $sessionStorage.pokazZarzadzaj = false;
            $location.path('/login');
        } else {
        var role = $sessionStorage.currentUser.role;
                    if(angular.equals(role, "ADMIN")){
                        $rootScope.pokazZarzadzaj = true;
                        console.log('true');
                    }else{
                     $rootScope.pokazZarzadzaj = false;
                    }
            $sessionStorage.pokazZarzadzaj = true;
        }
    };
    checkUserInLocalStorage();

    $rootScope.$on("$locationChangeStart", function(event, next, current) {
//         var currentPath = current.$$route.originalPath;
//        console.log(currentPath);

    });
        $rootScope.$on('$routeChangeSuccess', function (e, current, pre) {
            var currentPath = current.$$route.originalPath;
                console.log(currentPath);
                if(!angular.equals(currentPath, '/register')){
                  checkUserInLocalStorage();
                  if($sessionStorage.currentUser!=undefined){
                   var role = $sessionStorage.currentUser.role;
                                    if(angular.equals(role, "ADMIN")){
                                       $rootScope.pokazZarzadzaj = true;
                                       console.log('true');
                                    }else{
                                      $rootScope.pokazZarzadzaj = false;
                                      $location.path('/main');
                                    }
                  }

                }

        });
});