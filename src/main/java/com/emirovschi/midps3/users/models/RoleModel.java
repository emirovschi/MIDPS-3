package com.emirovschi.midps3.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roles_id_seq")
    @SequenceGenerator(name="roles_id_seq", sequenceName="roles_id_seq", allocationSize=1)
    private long id;

    @Column(nullable = false)
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }
}
