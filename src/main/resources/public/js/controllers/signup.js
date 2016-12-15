app.controller("login", function($scope, $mdDialog, users)
{
    $scope.request = users.registerData;

    $scope.isLoading = function()
    {
        return users.isLoading();
    }
});