package com.emirovschi.midps3.posts.dto;

import com.emirovschi.midps3.users.dto.UserDTO;

import java.util.List;

public class PostDTO
{
    private long id;
    private String title;
    private int ups;
    private int downs;
    private int userVote;
    private List<CommentDTO> comments;
    private UserDTO user;
    private int width;
    private int height;

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

    public int getUps()
    {
        return ups;
    }

    public void setUps(final int ups)
    {
        this.ups = ups;
    }

    public int getDowns()
    {
        return downs;
    }

    public void setDowns(final int downs)
    {
        this.downs = downs;
    }

    public List<CommentDTO> getComments()
    {
        return comments;
    }

    public void setComments(final List<CommentDTO> comments)
    {
        this.comments = comments;
    }

    public int getUserVote()
    {
        return userVote;
    }

    public void setUserVote(final int userVote)
    {
        this.userVote = userVote;
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(final UserDTO user)
    {
        this.user = user;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(final int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(final int height)
    {
        this.height = height;
    }
}
