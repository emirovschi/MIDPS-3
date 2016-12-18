package com.emirovschi.midps3.posts.dto;

import com.emirovschi.midps3.users.dto.UserDTO;

import java.util.Date;

public class CommentDTO
{
    private UserDTO user;
    private Date time;
    private String comment;

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(final UserDTO user)
    {
        this.user = user;
    }

    public Date getTime()
    {
        return time;
    }

    public void setTime(final Date time)
    {
        this.time = time;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(final String comment)
    {
        this.comment = comment;
    }
}
