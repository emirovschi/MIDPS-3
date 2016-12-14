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
            var pageSize = 2;
            var totalPages = -1;
            var page = 0;

            $scope.fetch = function()
            {
                console.log("fetch");
                if (!isLoading && (totalPages < 0 || page < totalPages))
                {
                    isLoading = true;
                    posts.getPosts(page, pageSize, $scope.searchData).then(function(response)
                    {
                        response.data.items.forEach(function(e)
                        {
                            e.size = e.height*768/e.width + 81;
                            $scope.posts.push(e);
                        });

                        if ($scope.searchData.firstId == null && response.data.items.length > 0)
                        {
                            $scope.searchData.firstId = response.data.items[0].id;
                        }

                        if (totalPages < 0)
                        {
                            totalPages = response.data.totalPage;
                        }

                        page++;
                        isLoading = false;
                    });
                }
            }

            $scope.fetch();
        }
    }
});
