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
            var page = 0;

            $scope.fetch = function()
            {
                if (!isLoading)
                {
                    isLoading = false;
                    posts.getPosts(page, pageSize, $scope.searchData).then(function(response)
                    {
                        response.data.items.forEach(function(e)
                        {
                            var img = new Image();
                            img.onload = function()
                            {
                                e.width = this.width;
                                e.height = this.height;
                            }
                            img.src = '/posts/' + e.id + '/image';
                        });

                        $scope.posts = $scope.posts.concat(response.data.items);
                        if ($scope.searchData.firstId == null && response.data.items.length > 0)
                        {
                            $scope.searchData.firstId = response.data.items[0].id;
                        }

                        page++;
                    });
                }
            }

            $scope.fetch();
        }
    }
});
