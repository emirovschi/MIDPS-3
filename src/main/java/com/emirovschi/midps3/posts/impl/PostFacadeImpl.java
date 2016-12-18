package com.emirovschi.midps3.posts.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.images.ImageFacade;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.list.dto.PageDTO;
import com.emirovschi.midps3.posts.PostFacade;
import com.emirovschi.midps3.posts.PostService;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.search.Search;
import com.emirovschi.midps3.search.dto.SearchDTO;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
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

    @Autowired
    private ImageFacade imageFacade;

    @Resource
    private Converter<PostModel, PostDTO> postConverter;

    @Autowired
    private Converter<SearchDTO, Search> searchReverseConverter;

    @Resource
    private Converter<Page<PostModel>, PageDTO<PostDTO>> postPageConverter;

    @Resource
    private Converter<Page<PostModel>, PageDTO<PostDTO>> postVotesPageConverter;

    @Resource
    private Converter<PostModel, ImageDTO> imageConverter;

    @Resource
    private Converter<PostModel, ImageDTO> previewConverter;

    @Override
    public PageDTO<PostDTO> search(final SearchDTO searchDTO, final Pageable pageable)
    {
        return search(searchDTO, pageable, postPageConverter);
    }

    @Override
    public PageDTO<PostDTO> getVotes(final SearchDTO searchDTO, final Pageable pageable)
    {
        return search(searchDTO, pageable, postVotesPageConverter);
    }

    private PageDTO<PostDTO> search(final SearchDTO searchDTO, final Pageable pageable,
                                   final Converter<Page<PostModel>, PageDTO<PostDTO>> converter)
    {
        final Search search = searchReverseConverter.convert(searchDTO);
        final Page<PostModel> posts = postService.search(search.getAdds(), search.getExcludes(), search.getFirstId(), pageable);
        return converter.convert(posts);
    }

    @Override
    public PostDTO getPost(final long id)
    {
        return postConverter.convert(postService.getPostById(id));
    }

    @Override
    public ImageDTO getPostImage(final long id)
    {
        return imageConverter.convert(postService.getPostById(id));
    }

    @Override
    public ImageDTO getPostPreview(final long id)
    {
        return previewConverter.convert(postService.getPostById(id));
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
    public PostDTO create(final String title, final List<String> tags, final String imageType, final byte[] image)
    {
        try
        {
            final PostModel post = new PostModel();
            post.setTitle(title);
            post.setTags(tagService.save(tags.stream().distinct().collect(Collectors.toList())));
            post.setImageType(imageType);
            post.setImage(image);
            post.setPreview(imageFacade.getPreview(image, imageType));
            post.setUser(userService.getSessionUser());
            postService.save(post);
            return postConverter.convert(post);
        }
        catch (IOException e)
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
