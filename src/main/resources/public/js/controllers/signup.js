app.controller("signup", function($scope, $mdDialog, users, auth)
{
    $scope.registerData = users.registerData;

    $scope.isLoading = function()
    {
        return users.isLoading();
    }

    $scope.signup = function()
    {
        users.register(function(data)
        {
            console.log(data);
        },
        function(data)
        {
            console.log(data);
        });
    }
});