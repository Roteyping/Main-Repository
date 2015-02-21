'use strict';

/* jasmine specs for controllers go here */


describe('Alert Control', function(){
    var $rootscope,$httpBackend,createController;
    beforeEach(function(){

        angular.mock.module('myhh');

        inject(function($injector){
            // The $controller service is used to create instances of controllers
            var $controller = $injector.get('$controller');

            createController = function() {
                return $controller('lessonPlanController', {'$scope' : $rootscope });
            };
        })
    });

    it('should return data',function(){
        var controller = createController();
    });
});