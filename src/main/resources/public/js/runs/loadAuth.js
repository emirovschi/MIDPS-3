app.run(function(auth)
{
    if (localStorage.refresh_token != null)
    {
        auth.refresh(localStorage.refresh_token);
    }
});




