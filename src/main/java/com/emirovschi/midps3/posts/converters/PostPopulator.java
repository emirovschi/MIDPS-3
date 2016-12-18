package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.converters.Populator;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

@Component("postMinimalPopulator")
public class PostPopulator implements Populator<PostModel, PostDTO>
{
    @Autowired
    private Converter<UserModel, UserDTO> userConverter;

    @Override
    public void populate(final PostModel source, final PostDTO target)
    {
        target.setTitle(source.getTitle());
        target.setId(source.getId());
        target.setUser(userConverter.convert(source.getUser()));

        try
        {
            final BufferedImage preview = ImageIO.read(source.getPreview().getBinaryStream());
            target.setWidth(preview.getWidth());
            target.setHeight(preview.getHeight());
        }
        catch (IOException | SQLException e)
        {
            throw new BadImageException();
        }
    }
}
