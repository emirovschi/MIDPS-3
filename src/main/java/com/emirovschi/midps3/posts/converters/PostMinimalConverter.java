package com.emirovschi.midps3.posts.converters;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.users.UserService;
import com.emirovschi.midps3.users.dto.UserDTO;
import com.emirovschi.midps3.users.exceptions.UserNotFound;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Collections.emptyMap;
import static java.util.Optional.ofNullable;

@Component("postMinimalConverter")
public class PostMinimalConverter implements Converter<PostModel, PostDTO>
{
    @Autowired
    private UserService userService;

    @Autowired
    private Converter<UserModel, UserDTO> userConverter;

    @Override
    public PostDTO convert(final PostModel post)
    {
        final PostDTO postDTO = new PostDTO();
        postDTO.setTitle(post.getTitle());
        postDTO.setId(post.getId());
        postDTO.setUps(getUps(post));
        postDTO.setDowns(getDowns(post));
        postDTO.setUserVote(getUserVote(post));
        postDTO.setUser(userConverter.convert(post.getUser()));

        try
        {
            final BufferedImage image = ImageIO.read(post.getImage().getBinaryStream());
            postDTO.setWidth(image.getWidth());
            postDTO.setHeight(image.getHeight());
        }
        catch (IOException | SQLException e)
        {
            throw new BadImageException();
        }

        return postDTO;
    }

    private int getUps(final PostModel post)
    {
        return getVotes(post).filter(i -> i > 0).sum();
    }

    private int getDowns(final PostModel post)
    {
        return -getVotes(post).filter(i -> i < 0).sum();
    }

    private IntStream getVotes(final PostModel post)
    {
        return getVotesMap(post).values().stream().mapToInt(i -> i);
    }

    private int getUserVote(final PostModel post)
    {
        try
        {
            return ofNullable(getVotesMap(post).get(userService.getSessionUser())).orElse(0);
        }
        catch (UserNotFound exception)
        {
            return 0;
        }
    }

    private Map<UserModel, Integer> getVotesMap(final PostModel post)
    {
        return ofNullable(post.getVotes()).orElse(emptyMap());
    }
}
