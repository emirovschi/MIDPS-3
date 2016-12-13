angular.module('App').service('tags', function($http)
{
    this.search = function (query, searchData)
    {
        return $http.post("/tags/search", searchData);
    }
});
