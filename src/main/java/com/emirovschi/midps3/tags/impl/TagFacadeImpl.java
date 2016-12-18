package com.emirovschi.midps3.tags.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.list.dto.ListDTO;
import com.emirovschi.midps3.search.Search;
import com.emirovschi.midps3.search.dto.SearchDTO;
import com.emirovschi.midps3.tags.TagFacade;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.tags.dto.TagDTO;
import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TagFacadeImpl implements TagFacade
{
    @Autowired
    private TagService tagService;

    @Autowired
    private Converter<SearchDTO, Search> searchReverseConverter;

    @Autowired
    private Converter<List<TagModel>, ListDTO<TagDTO>> tagListConverter;

    @Override
    public ListDTO<TagDTO> searchTags(final SearchDTO searchDTO)
    {
        final Search search = searchReverseConverter.convert(searchDTO);

        return tagListConverter.convert(tagService.getTags(search.getQuery(), search.getAdds(), search.getExcludes()));
    }
}
