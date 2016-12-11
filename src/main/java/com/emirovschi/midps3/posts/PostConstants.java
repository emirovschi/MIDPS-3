package com.emirovschi.midps3.posts;

public class PostConstants
{
    public static final String VOTES_COUNT_BY_TAG = "SELECT COALESCE(SUM(VALUE(votes)), 0) "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "INNER JOIN post.votes votes "
            + "WHERE tag = ?1";
}
