angular.module('app').service('UserService', function($http) {
    this.add = function (user) {
        return $http({
            method: "POST",
            url: '/api/users/add',
            data: user,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            //return angular.toJson(response.data);
            return response;
        }, function errorCallback(response) {
            return response.status;
        });
    }

    this.editUser = function (user) {
        return $http({
            method: "POST",
            url: '/api/users/edit',
            data: user,
            headers: {'Content-Type': 'application/json'}
        }).then(function successCallback(response) {
            //return angular.toJson(response.data);
            return response;
        }, function errorCallback(response) {
            return response.status;
        });
    }

    this.findAll = function () {
        var url = 'api/users/all';
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response.status;
        });
    }

    this.findOneUser = function (id) {
        var url = 'api/users/id/' + id;
        return $http({
            method: "GET",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response.status;
        });
    }

    this.deleteUser = function (id) {
        var url = 'api/user/delete/id/' + id;
        return $http({
            method: "POST",
            url: url
        }).then(function successCallback(response) {
            return response;
        }, function errorCallback(response) {
            return response.status;
        });
    }
});