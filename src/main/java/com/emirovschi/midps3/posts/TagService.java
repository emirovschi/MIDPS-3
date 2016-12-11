package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.TagModel;

import java.util.List;
import java.util.Set;

public interface TagService
{
    List<TagModel> save(List<String> tags);

    Set<TagModel> getTags(Set<String> tags);
}
