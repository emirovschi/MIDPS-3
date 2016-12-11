package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostPageConverter extends PageConverter<PostModel, PostDTO>
{
    @Autowired
    private Converter<PostModel, PostDTO> itemConverter;

    @Override
    protected Converter<PostModel, PostDTO> getItemConverter()
    {
        return itemConverter;
    }
}
