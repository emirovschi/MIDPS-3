package com.emirovschi.midps3.posts.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentModel
{
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="post")
    private PostModel post;
}
