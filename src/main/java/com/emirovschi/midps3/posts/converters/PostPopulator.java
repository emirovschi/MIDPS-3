package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.converters.Populator;
import com.emirovschi.midps3.medias.MediaFacade;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("postMinimalPopulator")
public class PostPopulator implements Populator<PostModel, PostDTO>
{
    @Autowired
    private Converter<UserModel, UserDTO> userConverter;

    @Autowired
    private MediaFacade mediaFacade;

    @Override
    public void populate(final PostModel source, final PostDTO target)
    {
        target.setTitle(source.getTitle());
        target.setId(source.getId());
        target.setUser(userConverter.convert(source.getUser()));
        target.setWidth(mediaFacade.getWidth(source));
        target.setHeight(mediaFacade.getHeight(source));
        target.setType(source.getMediaType().substring(0, source.getMediaType().indexOf('/')));
    }
}
