package com.emirovschi.midps3.tags;

public class TagConstants
{
    public static final String TAGS_BY_POST_COUNT = "SELECT tag "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "GROUP BY tag.id "
            + "ORDER BY COUNT(post.id) DESC";

    public static final String TAGS_BY_VOTES_SUM = "SELECT tag "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "INNER JOIN post.votes votes "
            + "GROUP BY tag.id "
            + "ORDER BY SUM(COALESCE(VALUE(votes), 0)) DESC";
}
