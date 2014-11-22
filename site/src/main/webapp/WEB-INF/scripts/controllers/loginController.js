roteyping.controller('loginController', ['$scope','loginService', function($scope, loginService){
    $scope.signIn = function(email, password) {
        loginService.login({
            email : email,
            password : password
        }, function(data){

        }, function(data){
        })
    }
}]);