package com.emirovschi.midps3.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name="userRoles", joinColumns=@JoinColumn(name="user"), inverseJoinColumns=@JoinColumn(name="role"))
    private List<RoleModel> roles;

    public long getId()
    {
        return id;
    }

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

    public List<RoleModel> getRoles()
    {
        return roles;
    }

    public void setRoles(final List<RoleModel> roles)
    {
        this.roles = roles;
    }
}
