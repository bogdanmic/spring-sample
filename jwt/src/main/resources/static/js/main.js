'use strict';

/* App Module */
var app = angular.module('App', []);
// .module('App.controllers', [])
// .module('App.controllers')
app.controller('AppController', ['$scope', '$http',
    function ($scope, $http) {
        $scope.credentials = {
            username: null,
            password: null
        };
        $scope.authToken = null;

        $scope.doSubmit = function (credentials) {
            var req = {
                method: 'POST',
                url: '/login',
                data: credentials
            };

            $http(req).then(function (response) {
                // Get the auth token received at login
                var authToken = response.headers('Authorization');
                // Remove descriptive text
                // $scope.authToken = authToken.replace('Bearer ', '');
                // console.log(response.headers('Authorization'));
                $scope.authToken = response.headers('Authorization');
                // console.log($scope.authToken);
                getRestrictedData($scope.authToken);
            }, function (response) {
                console.log(response);
            });
        };

        var getRestrictedData = function (authToken) {
            // Get the restricted url
            $http({
                method: 'GET',
                url: '/users',
                headers: {
                    "Authorization": authToken
                }
            }).then(function successCallback(response) {
                // this callback will be called asynchronously
                // when the response is available
                $scope.response = response;
            }, function errorCallback(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
                $scope.response = response;
            });
        };

        getRestrictedData($scope.authToken);
    }]);