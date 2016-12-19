package com.emirovschi.midps3.tags.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM;

@Entity
@Table(name = "tags")
public class TagModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_seq")
    @GenericGenerator(name = "tags_id_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
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
