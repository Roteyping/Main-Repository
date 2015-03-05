var signUpController = function($scope, loginService){
//TODO: Check if two passwords are the same
                          $scope.signUp = function(email, password) {
                              signUpService.signUp({
                                  email : email,
                                  password : password
                              }, function(data){

                              }, function(data){
                              })
                          };
                  };

myhh.controller('signUpController', ['$scope','signUpService', signUpController]);