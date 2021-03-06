package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.list.converters.PageConverter;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("postVotesPageConverter")
public class PostVotesPageConverter extends PageConverter<PostModel, PostDTO>
{
    @Resource
    private Converter<PostModel, PostDTO> postVotesConverter;

    @Override
    protected Converter<PostModel, PostDTO> getItemConverter()
    {
        return postVotesConverter;
    }
}
