'use strict';

/* App Module */
var app = angular.module('App', []);
// .module('App.controllers', [])
// .module('App.controllers')
app.controller('AppController', ['$scope',
    function ($scope) {
        $scope.credentials = {
            username: null,
            password: null
        };
    }]);