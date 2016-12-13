package com.emirovschi.midps3.posts;

public class PostConstants
{
    public static final String SEARCH_POSTS = "SELECT post "
            + "FROM PostModel post "
            + "WHERE (:lastId IS NULL OR post.id < :lastId) "
            + "AND ((:adds) IS NULL OR "
            + "EXISTS (SELECT iTag FROM PostModel iPost INNER JOIN iPost.tags iTag WHERE iPost = post AND iTag IN (:adds))) "
            + "AND ((:excludes) IS NULL OR "
            + "NOT EXISTS (SELECT iTag FROM PostModel iPost INNER JOIN iPost.tags iTag WHERE iPost = post AND iTag IN (:excludes))) "
            + "ORDER BY post.id DESC";
}
