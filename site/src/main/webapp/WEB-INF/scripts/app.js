var roteyping = angular.module('roteyping',['ngResource']);

roteyping.factory('loginService', ['$resource', function ($resource){
     return $resource('/login', {}, {
        login: {

        }
     });
}]);

