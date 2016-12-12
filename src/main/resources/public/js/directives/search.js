angular.module('App').directive('search', function(tags){
    return {
        restrict: 'E',
        scope:
        {
            tags: "=tags"
        },
        templateUrl: '/templates/search.html',
        link: function($scope, elem)
        {
            $scope.query = "";
            $scope.result = [];

            $scope.$watch("tags", function(newVal, oldVal)
            {
                $scope.search();
            }, true);

            $scope.search = function()
            {
                tags.search($scope.query, $scope.tags,
                function(response)
                {
                    $scope.result = response.items;
                });
            };

            $scope.add = function(tag)
            {
                removeExisting($scope.tags, tag);
                $scope.tags.push({name: tag, add: true});
            };

            $scope.exclude = function(tag)
            {
                removeExisting($scope.tags, tag);
                $scope.tags.push({name: tag, add: false});
            };

            var removeExisting = function(array, tag)
            {
                $scope.tags = $scope.tags.filter(function(item) { return item.name != tag});
            };

            $scope.search();
        }
    }
});
