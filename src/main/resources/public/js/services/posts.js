app.service('posts', function($http)
{
    this.getPosts = function (page, size, searchData)
    {
        return $http.post("/posts/search?page=" + page + "&size=" + size, searchData);
    }

    this.getVotes = function (size, searchData)
    {
        return $http.post("/posts/votes?page=0&size=" + size, searchData);
    }
});
