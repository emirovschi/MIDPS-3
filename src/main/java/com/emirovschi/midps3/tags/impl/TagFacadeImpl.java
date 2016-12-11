package com.emirovschi.midps3.tags.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.tags.TagFacade;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.tags.dto.ListDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;
import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class TagFacadeImpl implements TagFacade
{
    @Autowired
    private TagService tagService;

    @Autowired
    private Converter<List<TagModel>, ListDTO<TagDTO>> tagListConverter;

    @Override
    public ListDTO<TagDTO> getTopTagsByPosts()
    {
        return convertResult(tagService.getTagsSortedByPostsCount(new PageRequest(0, 10)));
    }

    @Override
    public ListDTO<TagDTO> getTopTagsByVotes()
    {
        return convertResult(tagService.getTagsSortedByVotesSum(new PageRequest(0, 10)));
    }

    private ListDTO<TagDTO> convertResult(final Page<TagModel> tags)
    {
        return tagListConverter.convert(tags.getContent());
    }
}
