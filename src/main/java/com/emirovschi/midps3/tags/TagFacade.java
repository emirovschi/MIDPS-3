package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.dto.ListDTO;
import com.emirovschi.midps3.tags.dto.SearchDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;

public interface TagFacade
{
    ListDTO<TagDTO> searchTags(SearchDTO search);
}
