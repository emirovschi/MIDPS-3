package com.emirovschi.midps3.users.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.medias.ImageFacade;
import com.emirovschi.midps3.medias.dto.MediaDTO;
import com.emirovschi.midps3.posts.exceptions.BadMediaException;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserImageConverter implements Converter<UserModel, MediaDTO>
{
    @Autowired
    private ImageFacade imageFacade;

    @Override
    public MediaDTO convert(final UserModel user)
    {
        final MediaDTO image = new MediaDTO();
        image.setType(MediaType.IMAGE_JPEG);

        try
        {
            final String firstLetter = user.getName().substring(0, 1);
            final byte[] generatedImage = imageFacade.generate(firstLetter, 40, 40);
            image.setMedia(generatedImage);
        }
        catch (IOException e)
        {
            throw new BadMediaException();
        }
        return image;
    }
}
