package com.emirovschi.midps3.tags;

import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface TagService
{
    List<TagModel> save(List<String> tags);

    Set<TagModel> getTags(Set<String> tags);

    Page<TagModel> getTagsSortedByPostsCount(Pageable pageable);

    Page<TagModel> getTagsSortedByVotesSum(Pageable pageable);
}
