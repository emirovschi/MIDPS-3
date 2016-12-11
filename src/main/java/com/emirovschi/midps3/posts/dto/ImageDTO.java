package com.emirovschi.midps3.posts.dto;

import org.springframework.http.MediaType;

public class ImageDTO
{
    private byte[] image;
    private MediaType type;

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(final byte[] image)
    {
        this.image = image;
    }

    public MediaType getType()
    {
        return type;
    }

    public void setType(final MediaType type)
    {
        this.type = type;
    }
}
