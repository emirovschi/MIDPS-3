app.controller("login", function($scope, $mdDialog, auth)
{
    $scope.close = function()
    {
        $mdDialog.cancel();
    }
});
