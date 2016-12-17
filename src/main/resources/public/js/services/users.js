app.service('users', function($http)
{
    var isLoading_ = false;
    var registerData_ = {};

    this.isLoading = function()
    {
        return isLoading_;
    }

    this.registerData = registerData_;

    this.register = function(success, error)
    {
        isLoading_ = true;
        return $http.post("/users", registerData_).then(function(data)
        {
            success(registerData_);

            isLoading_ = false;
            registerData_ = {};
        },
        function(data)
        {
            isLoading_ = false;
            error(data.data);
        });
    }
});
