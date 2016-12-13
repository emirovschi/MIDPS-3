package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.list.dto.PageDTO;
import com.emirovschi.midps3.posts.dto.ImageDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import com.emirovschi.midps3.search.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/posts")
public class PostController
{
    @Autowired
    private PostFacade postFacade;

    @Resource
    private Set<String> allowedContentTypes;

    @Secured("ROLE_USER")
    @RequestMapping(method = RequestMethod.POST)
    public PostDTO create(@RequestParam final String title, @RequestParam final List<String> tags,
                          @RequestParam final MultipartFile image) throws IOException, BadImageException
    {
        if (!allowedContentTypes.contains(image.getContentType()))
        {
            throw new BadImageException();
        }

        return postFacade.create(title, tags, image.getContentType(), image.getBytes());
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PageDTO<PostDTO> searchPosts(@RequestBody final SearchDTO search, @PageableDefault final Pageable pageable)
    {
        return postFacade.search(search, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PostDTO getPost(@PathVariable final long id)
    {
        return postFacade.getPost(id);
    }

    @RequestMapping(value = "/{id}/image", method = RequestMethod.GET, produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public ResponseEntity<byte[]> getPostImage(@PathVariable final long id)
    {
        final ImageDTO image = postFacade.getPostImage(id);

        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(image.getType());

        return new ResponseEntity<>(image.getImage(), responseHeaders, HttpStatus.OK);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}/vote/up", method = RequestMethod.POST)
    public void voteUp(@PathVariable final long id)
    {
        postFacade.voteUp(id);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}/vote/down", method = RequestMethod.POST)
    public void voteDown(@PathVariable final long id)
    {
        postFacade.voteDown(id);
    }
}
