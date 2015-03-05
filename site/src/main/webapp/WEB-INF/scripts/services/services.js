myhh.factory('lesson-plan-service',['$resource', function($resource){
    return $resource('/lesson-plans');
}]);

myhh.factory('loginService', ['$resource', function ($resource){
     return $resource('/login', {}, {
        login: {
              method : 'POST'
        }
     });
}]);

myhh.factory('signUpService', ['$resource', function ($resource){
     return $resource('/signup', {}, {
        signup: {
              method : 'POST'
        }
     });
}]);