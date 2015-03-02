var loginController = function($scope, loginService){
                          $scope.signIn = function(email, password) {
                              loginService.login({
                                  email : email,
                                  password : password
                              }, function(data){

                              }, function(data){
                              })
                          };

                          $scope.add = function(a, b) {
                              return a + b;
                          };
                      };

myhh.controller('loginController', ['$scope','loginService', loginController]);