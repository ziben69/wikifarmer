angular.module('app').controller('LoginController', function ($rootScope, $scope, LoginService, $location, $localStorage, $window, $timeout, $sessionStorage) {
    $scope.username = '';
    $scope.password = '';


    $scope.login = function () {
        var userLoginAndPassword = {
            "username": $scope.username,
            "password": $scope.password
        }
        LoginService
            .login(userLoginAndPassword)
            .then(function (response) {
                if (response.status == 200) {
                    LoginService
                        .getCurrentUser().then(function (response) {
                            $sessionStorage.currentUser = response.data;
                            $sessionStorage.pokazZarzadzaj = true;
                            $rootScope.pokazZarzadzaj = true;
                            $rootScope.email = $sessionStorage.currentUser.email;
                            $location.path('/main');
                    })
                } else {
                    alert('Error');
                }
            })
    }
    $scope.enterLoginKey = function(keyEvent) {
        if(keyEvent!=undefined){
                if (keyEvent.which === 13){
                    $scope.login();
                }
        }
    }
});