package com.emirovschi.midps3.tags;

public class TagConstants
{
    public static final String TAGS_BY_POST_COUNT = "SELECT TAGS "
            + "FROM TAGS "
            + "JOIN POST_TAGS ON POST_TAGS.TAG = TAGS.ID ,"
            + "JOIN POSTS ON POSTS.ID = POST_TAGS.POST "
            + "GROUP BY TAGS.ID "
            + "ORDER BY COUNT(POSTS.ID) DESC";

    public static final String TAGS_BY_VOTES_SUM = "SELECT TAGS "
            + "FROM TAGS "
            + "JOIN POST_TAGS ON POST_TAGS.TAG = TAGS.ID ,"
            + "JOIN POSTS ON POSTS.ID = POST_TAGS.POST "
            + "LEFT JOIN VOTES ON VOTES.POST = POSTS.ID "
            + "GROUP BY TAGS.ID "
            + "ORDER BY SUM(COALESCE(VOTES.VOTES, 0)) DESC";
}
