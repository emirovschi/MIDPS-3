package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.exceptions.BadImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void create(@RequestParam final String title, @RequestParam final List<String> tags, @RequestParam final MultipartFile image) throws IOException, BadImageException
    {
        if (!allowedContentTypes.contains(image.getContentType()))
        {
            throw new BadImageException();
        }

        postFacade.create(title, tags, image.getBytes());
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
