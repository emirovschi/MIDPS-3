package com.emirovschi.midps3.users.models;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel
{
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    private String password;

    @ElementCollection
    @CollectionTable(name="roles", joinColumns=@JoinColumn(name="userId"))
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
