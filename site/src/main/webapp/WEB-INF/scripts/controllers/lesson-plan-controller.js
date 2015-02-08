myhh.controller('lessonPlanController', ['$scope', 'lesson-plan-service', function($scope, lessonPlanService){
    $scope.lessonPlans = lessonPlanService.query();
}]);