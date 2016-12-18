app.controller("account", function($scope, users)
{
    $scope.isLoading = true;
    $scope.user =
    {
    };

    $scope.update = function()
    {
        $scope.isLoading = false;
        Object.keys($scope.user).forEach(function(key)
        {
            if ($scope.user[key] != null && $scope.user[key].length == 0)
            {
                delete $scope.user[key];
            }
        });

        users.updateUser($scope.user).then(function(data)
        {
            delete $scope.user.password1;
            delete $scope.user.password2;
            $scope.isLoading = false;
        },
        function(data)
        {
            console.log(data);
            $scope.isLoading = false;
        });
    };

    users.getUser().then(function(user)
    {
        $scope.user.name = user.data.name;
        $scope.isLoading = false;
    });
});