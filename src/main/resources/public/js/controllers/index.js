app.controller("index",function($scope, $mdDialog)
{
    $scope.tags = [];

     $scope.openLogIn = function() {
        $mdDialog.show(
          $mdDialog.alert()
            .clickOutsideToClose(true)
            .title('Opening from the left')
            .textContent('Closing to the right!')
            .ariaLabel('Left to right demo')
            .ok('Nice!')
            .openFrom('#login')
            .closeTo('#login')
        );
      };

     $scope.openSignUp = function() {
        $mdDialog.show(
          $mdDialog.alert()
            .clickOutsideToClose(true)
            .title('Opening from the left')
            .textContent('Closing to the right!')
            .ariaLabel('Left to right demo')
            .ok('Nice!')
            .openFrom('#signup')
            .closeTo('#signup')
        );
      };
});
