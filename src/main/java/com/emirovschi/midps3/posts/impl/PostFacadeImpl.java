package com.emirovschi.midps3.posts.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.posts.PostFacade;
import com.emirovschi.midps3.posts.PostService;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.dto.PageDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.UserService;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialBlob;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PostFacadeImpl implements PostFacade
{
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Resource
    private Converter<PostModel, PostDTO> postMinimalConverter;

    @Resource
    private Converter<PostModel, PostDTO> postFullConverter;

    @Autowired
    private Converter<Page<PostModel>, PageDTO<PostDTO>> postPageConverter;

    @Override
    public PageDTO<PostDTO> search(final String title, final Set<String> tags, final Set<String> users, final Pageable pageable)
    {
        final Set<TagModel> tagModels = tagService.getTags(tags);
        final Set<UserModel> userModels = userService.getUsers(users);
        return postPageConverter.convert(postService.search(title, tagModels, userModels, pageable));
    }

    @Override
    public PostDTO getPost(final long id)
    {
        return postFullConverter.convert(postService.getPostById(id));
    }

    @Override
    public void voteUp(final long id)
    {
        vote(id, 1);
    }

    @Override
    public void voteDown(final long id)
    {
        vote(id, -1);
    }

    private void vote(final long id, final int vote)
    {
        final PostModel post = postService.getPostById(id);
        postService.vote(post, userService.getSessionUser(), vote);
    }

    @Override
    public void comment(final long id, final CommentDTO comment)
    {

    }

    @Override
    @Transactional
    public PostDTO create(final String title, final List<String> tags, final byte[] image) throws BadImageException
    {
        try
        {
            final PostModel post = new PostModel();
            post.setTitle(title);
            post.setTags(tagService.save(tags.stream().distinct().collect(Collectors.toList())));
            post.setImage(new SerialBlob(image));
            post.setUser(userService.getSessionUser());
            postService.save(post);
            return postMinimalConverter.convert(post);
        }
        catch (SQLException e)
        {
            throw new BadImageException();
        }
    }

    @Override
    public void delete(final long id)
    {
        postService.delete(postService.getPostById(id));
    }
}
