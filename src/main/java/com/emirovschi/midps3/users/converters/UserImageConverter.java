package com.emirovschi.midps3.users.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.images.ImageFacade;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserImageConverter implements Converter<UserModel, ImageDTO>
{
    @Autowired
    private ImageFacade imageFacade;

    @Override
    public ImageDTO convert(final UserModel user)
    {
        final ImageDTO image = new ImageDTO();
        image.setType(MediaType.IMAGE_JPEG);

        try
        {
            final String firstLetter = user.getName().substring(0, 1);
            final byte[] generatedImage = imageFacade.generate(firstLetter, 40, 40);
            image.setImage(generatedImage);
        }
        catch (IOException e)
        {
            throw new BadImageException();
        }
        return image;
    }
}
