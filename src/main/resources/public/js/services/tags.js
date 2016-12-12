angular.module('App').service('tags', function($http)
{
    this.search = function (query, tags, success, error)
    {
        var search = {
            query: "%" + query + "%",
            tags: tags
        };

        return $http.post("/tags/search", search).then(function(body) { success(body.data); }, error);
    }
});
