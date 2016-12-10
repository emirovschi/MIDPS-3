package com.emirovschi.midps3.posts.dto;

import java.util.List;

public class PostDTO
{
    private String title;
    private byte[] image;
    private int score;
    private List<CommentDTO> comments;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(final byte[] image)
    {
        this.image = image;
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
