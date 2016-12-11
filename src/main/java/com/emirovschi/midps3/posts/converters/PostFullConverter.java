package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.models.CommentModel;
import com.emirovschi.midps3.posts.models.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Component("postFullConverter")
public class PostFullConverter extends PostMinimalConverter
{
    @Autowired
    private Converter<CommentModel, CommentDTO> commentConverter;

    @Override
    public PostDTO convert(final PostModel post)
    {
        final PostDTO postDTO = super.convert(post);
        postDTO.setComments(getComments(post));
        return postDTO;
    }

    private List<CommentDTO> getComments(final PostModel post)
    {
        return ofNullable(post.getComments()).orElse(emptyList())
                .stream()
                .map(commentConverter::convert)
                .collect(Collectors.toList());
    }
}
