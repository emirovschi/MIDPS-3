package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.dto.ListDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController
{
    @Autowired
    private TagFacade tagFacade;

    @RequestMapping(value = "/top/posts", method = RequestMethod.GET)
    public ListDTO<TagDTO> getTopTagsByPosts()
    {
        return tagFacade.getTopTagsByPosts();
    }

    @RequestMapping(value = "/top/votes", method = RequestMethod.GET)
    public ListDTO<TagDTO> getTopTagsByVotes()
    {
        return tagFacade.getTopTagsByVotes();
    }
}
