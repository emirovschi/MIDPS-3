package com.emirovschi.midps3.images.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import org.h2.util.IOUtils;
import org.springframework.http.MediaType;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public abstract class AbstractPostImageConverter implements Converter<PostModel, ImageDTO>
{
    @Override
    public ImageDTO convert(final PostModel post)
    {
        final ImageDTO imageDTO = new ImageDTO();

        try
        {
            imageDTO.setImage(IOUtils.readBytesAndClose(new ByteArrayInputStream(getImage(post)), -1));
        }
        catch (IOException e)
        {
            throw new BadImageException();
        }

        imageDTO.setType(MediaType.parseMediaType(post.getImageType()));

        return imageDTO;
    }

    protected abstract byte[] getImage(PostModel post);
}
