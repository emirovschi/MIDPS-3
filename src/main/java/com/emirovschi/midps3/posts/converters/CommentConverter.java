package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.models.CommentModel;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter implements Converter<CommentModel, CommentDTO>
{
    @Autowired
    private Converter<UserModel, UserDTO> userConverter;

    @Override
    public CommentDTO convert(final CommentModel comment)
    {
        final CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUser(userConverter.convert(comment.getUser()));
        commentDTO.setComment(comment.getComment());
        commentDTO.setTime(comment.getTime());
        return commentDTO;
    }
}
