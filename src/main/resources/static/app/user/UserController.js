angular.module('app').controller('UserController', function ($rootScope, $scope, UserService) {
    $scope.message = "User Controller";
    $scope.uLogin='';
    $scope.uPassword='';
    $scope.users;

    $scope.addUser = function () {
            var user = {
                "login": $scope.uLogin,
                "password": $scope.uPassword
            }
            UserService
                .add(user)
                .then(function (response) {
                    if (response.status == 200) {
                        loadAllUsers();
                        alert('User has been added.');
                    } else {
                        alert('We have problem. Chekc all fields.' );
                    }
                });

    }
    var loadAllUsers = function () {
        UserService
            .findAll()
            .then(function (response) {
                if (response.status == 200) {
                    $scope.users = response.data;
                }
            })
    }
    loadAllUsers();
});