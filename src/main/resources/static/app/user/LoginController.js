angular.module('app').controller('LoginController', function ($rootScope, $scope, LoginService, $location, $localStorage) {
    $scope.message = "LoginController";
    $scope.errorMsg = '';
    $scope.rememberMe = true;

    $scope.username='';
    $scope.password='';



    $scope.login = function () {
        var userLoginAndPassword = {
            "username":$scope.username,
            "password":$scope.password
        }
        LoginService
            .login(userLoginAndPassword)
            .then(function (response) {
                if (response.status == 200) {
                    LoginService
                        .getCurrentUser().then(function (response) {
                        $localStorage.currentUser = response.data;
                        $localStorage.showNavbar = true;
                        $localStorage.showTopMenu = true;
                        $rootScope.showNavbar = true;
                        $rootScope.showTopMenu = true;
                        $location.path('/');
                    })
                }else{
                    $scope.errorMsg = 'Please check your credentials and try again.';
                }
            })
    }
});