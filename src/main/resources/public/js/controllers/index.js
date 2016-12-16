app.controller("index", function($scope, $mdDialog, auth, tags)
{
    $scope.searchData = {
        query: '',
        tags: [],
        users: []
    };

    $scope.openLogIn = function()
    {
        $mdDialog.show(
        {
            controller: 'login',
            clickOutsideToClose: true,
            openFrom: '#login',
            closeTo: '#login',
            templateUrl: '/templates/login.html'
        });
    };

    $scope.openSignUp = function()
    {
        $mdDialog.show(
        {
            controller: 'signup',
            clickOutsideToClose: true,
            openFrom: '#signup',
            closeTo: '#signup',
            templateUrl: '/templates/signup.html'
        });
    };
});
