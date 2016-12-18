app.controller("home", function($scope, $mdDialog, auth)
{
    $scope.searchData = {
        query: '',
        tags: [],
        users: []
    };
});