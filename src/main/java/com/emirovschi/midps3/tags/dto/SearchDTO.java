package com.emirovschi.midps3.tags.dto;

import java.util.Set;

public class SearchDTO
{
    private String query;
    private Set<TagDTO> tags;
    private Set<String> users;

    public String getQuery()
    {
        return query;
    }

    public void setQuery(final String query)
    {
        this.query = query;
    }

    public Set<TagDTO> getTags()
    {
        return tags;
    }

    public void setTags(final Set<TagDTO> tags)
    {
        this.tags = tags;
    }

    public Set<String> getUsers()
    {
        return users;
    }

    public void setUsers(final Set<String> users)
    {
        this.users = users;
    }
}
