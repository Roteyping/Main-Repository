var myhh = angular.module('myhh', ['ngResource', 'ngRoute']);

myhh.config(['$routeProvider', function($routeProvider){
    $routeProvider
    .when('/lesson-plans', {templateUrl: '/static/partials/lesson-plans.html', controller: 'lessonPlanController'})
    .when('/home', {templateUrl: '/static/partials/home.html'})
    .when('/contact-us', {templateUrl: '/static/partials/contact-us.html'})
    .when('/about-us', {templateUrl: '/static/partials/about-us.html'})
    .when('/', {templateUrl: '/static/partials/home.html'})
    .otherwise({redirectTo: '/'});
}]);