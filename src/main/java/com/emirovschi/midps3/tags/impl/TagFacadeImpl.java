package com.emirovschi.midps3.tags.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.tags.TagFacade;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.tags.dto.TagDTO;
import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

public class TagFacadeImpl implements TagFacade
{
    @Autowired
    private TagService tagService;

    @Autowired
    private Converter<TagModel, TagDTO> tagConverter;

    @Override
    public List<TagDTO> getTopTagsByPosts()
    {
        return convertResult(tagService.getTagsSortedByPostsCount(new PageRequest(0, 10)));
    }

    @Override
    public List<TagDTO> getTopTagsByVotes()
    {
        return convertResult(tagService.getTagsSortedByVotesSum(new PageRequest(0, 10)));
    }

    private List<TagDTO> convertResult(final Page<TagModel> tags)
    {
        return tags.getContent().stream().map(tagConverter::convert).collect(Collectors.toList());
    }
}
