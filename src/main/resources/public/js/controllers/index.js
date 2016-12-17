app.controller("index", function($scope, $mdDialog, auth)
{
    $scope.logged = false;

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

    $scope.openMenu = function($mdOpenMenu, $event)
    {
        $mdOpenMenu($event);
    };

    $scope.logout = function()
    {
        auth.logout();
    }

    auth.listenLogin(function()
    {
        $scope.logged = true;
    });

    auth.listenLogout(function()
    {
        $scope.logged = false;
    });
});
