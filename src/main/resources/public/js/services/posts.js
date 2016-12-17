app.service('posts', function($http)
{
    this.getPosts = function(page, size, searchData)
    {
        return $http.post("/posts/search?page=" + page + "&size=" + size, searchData);
    }

    this.getVotes = function(size, searchData)
    {
        return $http.post("/posts/votes?page=0&size=" + size, searchData);
    }

    this.voteUp = function(id)
    {
        return $http.post("/posts/" + id + "/vote/up");
    }

    this.voteDown = function(id)
    {
        return $http.post("/posts/" + id + "/vote/down");
    }
});
