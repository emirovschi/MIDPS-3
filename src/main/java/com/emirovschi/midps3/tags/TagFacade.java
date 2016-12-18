package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.list.dto.ListDTO;
import com.emirovschi.midps3.search.dto.SearchDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;

public interface TagFacade
{
    ListDTO<TagDTO> searchTags(SearchDTO search);
}
