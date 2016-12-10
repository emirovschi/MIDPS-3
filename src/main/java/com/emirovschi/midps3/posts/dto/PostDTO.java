package com.emirovschi.midps3.posts.dto;

import java.util.List;

public class PostDTO
{
    private long id;
    private String title;
    private int score;
    private List<CommentDTO> comments;

    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(final int score)
    {
        this.score = score;
    }

    public List<CommentDTO> getComments()
    {
        return comments;
    }

    public void setComments(final List<CommentDTO> comments)
    {
        this.comments = comments;
    }
}
