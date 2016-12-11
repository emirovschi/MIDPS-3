package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PostPageConverter extends PageConverter<PostModel, PostDTO>
{
    @Resource
    private Converter<PostModel, PostDTO> postMinimalConverter;

    @Override
    protected Converter<PostModel, PostDTO> getItemConverter()
    {
        return postMinimalConverter;
    }
}
