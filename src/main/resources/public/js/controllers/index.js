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
        }).then(function(){console.log($scope.loading);},function(){console.log($scope.loading);});
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

    $scope.login = function()
    {
        auth.login("emirovschi@gmail.com","123456", function(){ tags.search($scope.searchData); }, function(er){console.log(er);});
    }
});
