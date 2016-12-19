package com.emirovschi.midps3.tags.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class TagModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tags_id_seq")
    @SequenceGenerator(name="tags_id_seq", sequenceName="tags_id_seq", allocationSize=1)
    private long id;

    @Column(unique = true)
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
