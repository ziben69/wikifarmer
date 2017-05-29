angular.module('app').controller('RegisterController', function ($rootScope, $scope, LoginService, $location, $localStorage,$http) {

    $scope.zarejestruj = function(){
            var url = 'api/users/add'
           $http.post(url, $scope.newUser).then(function (response) {
                //alert('Zarjestrowano');
                $location.path('/login');
            }, function(response){
             //errro
             alert('Nie udalo sie zarejstrowac');
            });
    }
});