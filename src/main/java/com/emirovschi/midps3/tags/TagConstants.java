package com.emirovschi.midps3.tags;

public class TagConstants
{
    public static final String SEARCH_TAGS = "SELECT tag "
            + "FROM PostModel post "
            + "INNER JOIN post.tags tag "
            + "WHERE (:query IS NULL OR tag.name LIKE :query) "
            + "AND ((:adds) IS NULL OR (tag NOT IN (:adds) "
            + "AND EXISTS (SELECT iTag FROM PostModel iPost INNER JOIN iPost.tags iTag WHERE iPost = post AND iTag IN (:adds)))) "
            + "AND ((:excludes) IS NULL OR (tag NOT IN (:excludes) "
            + "AND NOT EXISTS (SELECT iTag FROM PostModel iPost INNER JOIN iPost.tags iTag WHERE iPost = post AND iTag IN (:excludes)))) "
            + "GROUP BY tag.id "
            + "ORDER BY COUNT(post) DESC";
}
