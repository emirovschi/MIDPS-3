package com.emirovschi.midps3.posts.dto;

import com.emirovschi.midps3.users.dto.UserDTO;

public class PostDTO
{
    private long id;
    private String title;
    private Integer ups;
    private Integer downs;
    private Integer userVote;
    private UserDTO user;
    private Integer width;
    private Integer height;

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

    public Integer getUps()
    {
        return ups;
    }

    public void setUps(final Integer ups)
    {
        this.ups = ups;
    }

    public Integer getDowns()
    {
        return downs;
    }

    public void setDowns(final Integer downs)
    {
        this.downs = downs;
    }


    public Integer getUserVote()
    {
        return userVote;
    }

    public void setUserVote(final Integer userVote)
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

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(final Integer width)
    {
        this.width = width;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(final Integer height)
    {
        this.height = height;
    }
}
