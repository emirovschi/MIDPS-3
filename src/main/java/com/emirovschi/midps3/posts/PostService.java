package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.CommentModel;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PostService
{
    Page<PostModel> search(String title, Set<TagModel> tags, Set<UserModel> users, Pageable pageable);

    PostModel getPostById(long id);

    void vote(PostModel post, UserModel user, int value);

    void addComment(PostModel post, CommentModel comment);

    void save(PostModel post);

    void delete(PostModel post);
}
