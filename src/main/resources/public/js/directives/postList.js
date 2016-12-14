angular.module('App').directive('postList', function(posts){
    return {
        restrict: 'E',
        scope:
        {
            searchData: "=searchData"
        },
        templateUrl: '/templates/postList.html',
        link: function($scope, elem)
        {
            var pageSize = 20;
            var totalPages = -1;
            var page = 0;
            var promise;

            $scope.$watch("searchData.tags", function(newVal, oldVal)
            {
                page = 0;
                totalPages = -1;
                promise = null;
                $scope.searchData.firstId = null;
                $scope.posts = [];
                $scope.fetch();
            }, true);

            $scope.posts = [];

            $scope.showLoading = function()
            {
                return totalPages != page;
            };

            $scope.fetch = function()
            {
                if (promise == null && (totalPages < 0 || page < totalPages))
                {
                    promise = posts.getPosts(page, pageSize, $scope.searchData);

                    promise.then(function(response)
                    {
                        if (promise == null)
                        {
                            return;
                        }

                        response.data.items.forEach(function(e)
                        {
                            e.size = e.height * 768 / e.width + 81;
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
                        promise = null;
                    });
                }
            }
        }
    }
});
