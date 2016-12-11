package com.emirovschi.midps3.posts;

public class PostConstants
{
    public static final String VOTES_COUNT_BY_TAG = "SELECT COALESCE(SUM(VALUE(votes)), 0) "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "INNER JOIN post.votes votes "
            + "WHERE tag = ?1";

    public static final String SEARCH_POSTS = "SELECT post "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "INNER JOIN post.user user "
            + "WHERE (?1 IS NULL OR post.title LIKE ?1) "
            + "AND ((?2) IS NULL OR tag in (?2)) "
            + "AND ((?3) IS NULL OR user in (?3)) "
            + "GROUP BY post";
}
