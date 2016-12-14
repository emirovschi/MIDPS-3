package com.emirovschi.midps3.images.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import org.h2.util.IOUtils;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public abstract class AbstractPostImageConverter implements Converter<PostModel, ImageDTO>
{
    @Override
    public ImageDTO convert(final PostModel post)
    {
        final ImageDTO imageDTO = new ImageDTO();

        try
        {
            imageDTO.setImage(IOUtils.readBytesAndClose(getImage(post).getBinaryStream(), -1));
        }
        catch (IOException | SQLException e)
        {
            throw new BadImageException();
        }

        imageDTO.setType(MediaType.parseMediaType(post.getImageType()));

        return imageDTO;
    }

    protected abstract Blob getImage(PostModel post);
}
