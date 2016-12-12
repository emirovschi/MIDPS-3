package com.emirovschi.midps3.tags.impl;

import com.emirovschi.midps3.converters.Converter;
import com.emirovschi.midps3.tags.TagFacade;
import com.emirovschi.midps3.tags.TagService;
import com.emirovschi.midps3.tags.dto.ListDTO;
import com.emirovschi.midps3.tags.dto.SearchDTO;
import com.emirovschi.midps3.tags.dto.TagDTO;
import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.UserService;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toSet;

@Component
public class TagFacadeImpl implements TagFacade
{
    @Autowired
    private TagService tagService;

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<List<TagModel>, ListDTO<TagDTO>> tagListConverter;

    @Override
    public ListDTO<TagDTO> searchTags(final SearchDTO search)
    {
        final String query = ofNullable(search.getQuery()).filter(q -> !q.isEmpty()).orElse(null);
        final Set<TagModel> adds = getTags(search.getTags(), true);
        final Set<TagModel> excludes = getTags(search.getTags(), false);
        final Set<UserModel> users = ofNullable(search.getUsers()).map(userService::getUsers).orElse(null);

        return tagListConverter.convert(tagService.getTags(query, adds, excludes, users));
    }

    private Set<TagModel> getTags(final Set<TagDTO> tags, final boolean add)
    {
        return ofNullable(tags).map(getTags(add)).filter(s -> !s.isEmpty()).orElse(null);
    }

    private Function<Set<TagDTO>, Set<TagModel>> getTags(final boolean add)
    {
        return tags -> tagService.getTags(tags.stream()
                .filter(t -> t.isAdd() == add)
                .map(TagDTO::getName)
                .collect(toSet()));
    }
}
