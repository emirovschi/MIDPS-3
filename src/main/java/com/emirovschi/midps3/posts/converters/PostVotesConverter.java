package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.converters.Populator;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("postVotesConverter")
public class PostVotesConverter implements Converter<PostModel, PostDTO>
{
    @Resource
    private Populator<PostModel, PostDTO> postVotesPopulator;

    @Override
    public PostDTO convert(final PostModel post)
    {
        final PostDTO postDTO = new PostDTO();
        postVotesPopulator.populate(post, postDTO);
        return postDTO;
    }
}
