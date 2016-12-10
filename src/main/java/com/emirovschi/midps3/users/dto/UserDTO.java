package com.emirovschi.midps3.users.dto;

import java.util.List;

public class UserDTO
{
    private String email;
    private String name;
    private String password;
    private List<String> roles;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public List<String> getRoles()
    {
        return roles;
    }

    public void setRoles(final List<String> roles)
    {
        this.roles = roles;
    }
}
