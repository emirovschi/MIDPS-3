package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.stereotype.Component;

import static java.util.Collections.emptyMap;
import static java.util.Optional.ofNullable;

@Component("postMinimalConverter")
public class PostMinimalConverter implements Converter<PostModel, PostDTO>
{
    @Override
    public PostDTO convert(final PostModel post)
    {
        final PostDTO postDTO = new PostDTO();
        postDTO.setTitle(post.getTitle());
        postDTO.setId(post.getId());
        postDTO.setScore(getScore(post));
        return postDTO;
    }

    private int getScore(final PostModel post)
    {
        return ofNullable(post.getVotes()).orElse(emptyMap()).values().stream().mapToInt(i -> i).sum();
    }
}
