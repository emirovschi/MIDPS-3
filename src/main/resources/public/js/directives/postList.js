angular.module('App').directive('postList', function($timeout, posts){
    return {
        restrict: 'E',
        scope:
        {
            searchData: "=searchData"
        },
        templateUrl: '/templates/postList.html',
        link: function($scope, elem)
        {
            $scope.$watch("searchData", function(newVal, oldVal)
            {
                //reset
            }, true);

            $scope.posts = [];

            var isLoading = false;
            var pageSize = 20;

            $scope.fetch = function()
            {
                if (!isLoading)
                {
                    $timeout(angular.noop, 1000).then(angular.bind(this, function()
                    {
                        var last = $scope.posts.length
                        for(i = 0; i < pageSize; i++)
                        {
                            var index = last+i;
                            if (index < total)
                            {
                                $scope.posts.push({text:"test " + index, size: 50 + (index*50) % 300});
                            }
                        }
                        isLoading = false;
                    }));
                }
            }

            posts.getPosts(0, 2, $scope.searchData).then(function(data)
            {
                console.log(data);
            });

            $scope.fetch();
        }
    }
});
