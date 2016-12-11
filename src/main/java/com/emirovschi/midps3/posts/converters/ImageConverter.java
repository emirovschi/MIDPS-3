package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.ImageDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import org.h2.util.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;

@Component
public class ImageConverter implements Converter<PostModel, ImageDTO>
{
    @Override
    public ImageDTO convert(final PostModel post)
    {
        final ImageDTO imageDTO = new ImageDTO();

        try
        {
            imageDTO.setImage(IOUtils.readBytesAndClose(post.getImage().getBinaryStream(), -1));
        }
        catch (IOException | SQLException e)
        {
            throw new BadImageException();
        }

        imageDTO.setType(MediaType.parseMediaType(post.getImageType()));

        return imageDTO;
    }
}
