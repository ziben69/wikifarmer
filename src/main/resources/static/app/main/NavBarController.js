angular.module('app').controller('NavBarController', function($scope, $localStorage, $rootScope,
LoginService, $location, $sessionStorage,$route) {

    $rootScope.email='';
    $rootScope.pokazZarzadzaj = false;
    var isLoggedUser = function() {
        if ($sessionStorage.currentUser != undefined) {
            $rootScope.showNavBar = $sessionStorage.showNavBar;
            $rootScope.email = $sessionStorage.currentUser.email;
            var role = $sessionStorage.currentUser.role;
            if(angular.equals(role, "ADMIN")){
                $rootScope.pokazZarzadzaj = true;
                console.log('true');
            }else{
             $rootScope.pokazZarzadzaj = false;
            }
        }
    }
    isLoggedUser();

    $scope.logoutUser = function () {
        LoginService
            .logoutUser()
            .then(function (response) {
                $sessionStorage.pokazZarzadzaj = false;
                $rootScope.pokazZarzadzaj = false;
                $sessionStorage.currentUser = null;
                //$route.reload();
                 window.location.reload();
                $location.path('/login');

            });
    }
});