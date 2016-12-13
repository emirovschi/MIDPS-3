package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.CommentModel;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;

import java.util.List;
import java.util.Set;

public interface PostService
{
    List<PostModel> search(Set<TagModel> adds, Set<TagModel> excludes, Long lastId);

    PostModel getPostById(long id);

    void vote(PostModel post, UserModel user, int value);

    void addComment(PostModel post, CommentModel comment);

    void save(PostModel post);

    void delete(PostModel post);
}
