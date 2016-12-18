package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.list.dto.ListDTO;
import com.emirovschi.midps3.search.dto.SearchDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController
{
    @Autowired
    private TagFacade tagFacade;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ListDTO<TagDTO> searchTags(@RequestBody final SearchDTO search)
    {
        return tagFacade.searchTags(search);
    }
}
