angular.module('App').service('auth', function($http, $timeout)
{
    var client_login = "web";
    var client_password = "";
    var loginCallbacks = [];
    var logoutCallbacks = [];
    var authToken = btoa(client_login + ":" + client_password);
    var refresher = null;
    var refreshTimeDelta = 15;

    var config = {
        headers:
        {
            "Authorization": "Basic " + authToken,
            "Content-Type": "application/x-www-form-urlencoded"
        }
    };

    var encode = function(data)
    {
        return Object.keys(data)
                     .map(function(k){ return encodeURIComponent(k) + "=" + encodeURIComponent(data[k])})
                     .join("&");
    };

    var startRefresh = function(authorization)
    {
        return $timeout(function()
        {
            var body = {
                grant_type: "refresh_token",
                refresh_token: authorization.refresh_token
            };

            $http.post("/oauth/token", encode(body), config).then(function(response)
            {
                refresher = startRefresh(response.data);
            },
            function(er)
            {
                this.logout();
            });
        }, (authorization.expires_in - refreshTimeDelta) * 1000);
    };

    var save = function(authorization)
    {
        if (authorization != null && authorization.access_token != null)
        {
            $http.defaults.headers.common["Authorization"] = "Bearer " + authorization.access_token;
            refresher = startRefresh(authorization);
        }
        else
        {
            $http.defaults.headers.common["Authorization"] = null;
            $timeout.cancel(refresher);
        }
    };

    var isLoading_ = false;
    var request_ =
    {
        grant_type: "password",
        username: "",
        password: ""
    };

    this.isLoading = function()
    {
        return isLoading_;
    };

    this.request = request_;

    this.login = function(success, error)
    {
        isLoading_ = true;
        $http.post("/oauth/token", encode(request_), config).then(function(response)
        {
            save(response.data);

            success();

            loginCallbacks.forEach(function(callback)
            {
                callback();
            });

            isLoading_ = false;
            request_.username = "";
            request_.password = "";
        },
        function(er)
        {
            isLoading_ = false;
            error(er);
        });
    };

    this.logout = function()
    {
        save();

        logoutCallbacks.forEach(function(callback)
        {
            callback();
        });
    };

    this.listenLogin = function(callback)
    {
        loginCallbacks.push(callback);
    };

    this.listenLogout = function(callback)
    {
        logoutCallbacks.push(callback);
    };
});