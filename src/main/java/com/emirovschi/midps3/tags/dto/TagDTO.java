package com.emirovschi.midps3.tags.dto;

public class TagDTO
{
    private String name;
    private long count;
    private long vote;

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public long getCount()
    {
        return count;
    }

    public void setCount(final long count)
    {
        this.count = count;
    }

    public long getVote()
    {
        return vote;
    }

    public void setVote(final long vote)
    {
        this.vote = vote;
    }
}
