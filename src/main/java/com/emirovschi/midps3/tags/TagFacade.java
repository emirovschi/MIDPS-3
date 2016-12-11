package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.dto.TagDTO;

import java.util.List;

public interface TagFacade
{
    List<TagDTO> getTopTagsByPosts();

    List<TagDTO> getTopTagsByVotes();
}
