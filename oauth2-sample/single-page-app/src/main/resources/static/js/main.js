'use strict';


angular.module('hello', ['ngRoute'])
    .config(function ($routeProvider, $httpProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider.when('/', {
            templateUrl: 'templates/home.html',
            controller: 'home',
            controllerAs: 'controller'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    })
    .controller('home', function ($http) {
        var self = this;
        $http.get('token').then(function(response) {
            $http({
                url : '/resource',
                method : 'GET',
                headers : {
                    'X-Auth-Token' : response.data.token
                }
            }).then(function(response) {
                self.greeting = response.data;
            });
        })
    })
    .controller('navigation', function ($rootScope, $http, $location) {

        var self = this;

        var authenticate = function (credentials, callback) {

            var headers = credentials ? {
                    authorization: "Basic "
                    + btoa(credentials.username + ":" + credentials.password)
                } : {};

            $http.get('user', {headers: headers}).then(function (response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }, function () {
                $rootScope.authenticated = false;
                callback && callback();
            });

        };

        authenticate();
        self.credentials = {};

        self.logout = function () {
            $http.post('logout', {}).finally(function () {
                $rootScope.authenticated = false;
                $location.path("/");
            });
        }
    });