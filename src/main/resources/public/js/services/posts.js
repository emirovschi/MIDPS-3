angular.module('App').service('posts', function($http)
{
    this.getPosts = function (page, size, searchData, success, error)
    {
        return $http.post("/posts/search?page=" + page + "&size=" + size, searchData);
    }
});
