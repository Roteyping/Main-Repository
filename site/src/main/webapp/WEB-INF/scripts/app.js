var myhh = angular.module('myhh', ['ngResource', 'ngRoute']);

myhh.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/lesson-plans', {templateUrl: '/static/partials/lesson-plans.html', controller: 'lessonPlanController'})
    .when('/home', {templateUrl: '/static/partials/home.html'})
    .when('/', {templateUrl: '/static/partials/home.html'})
    .otherwise({redirectTo: '/'});
}]);



