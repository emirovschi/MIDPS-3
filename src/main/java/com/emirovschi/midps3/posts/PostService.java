package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.CommentModel;
import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.posts.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Blob;
import java.util.Set;

public interface PostService
{
    Page<PostModel> search(String title, Set<TagModel> tags, Set<UserModel> users, Pageable pageable);

    PostModel getPostById(long id);

    void vote(PostModel post, UserModel user, int value);

    void addComment(PostModel post, CommentModel comment);

    PostModel create(String title, Blob image);

    void delete(PostModel post);
}