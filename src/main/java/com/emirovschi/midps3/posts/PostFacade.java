package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.dto.PageDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.posts.exceptions.BadImageException;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface PostFacade
{
    PageDTO<PostDTO> search(String title, Set<String> tags, Set<String> users, Pageable pageable);

    PostDTO getPost(long id);

    void voteUp(long id);

    void voteDown(long id);

    void comment(long id, CommentDTO comment);

    PostDTO create(String title, byte[] image) throws BadImageException;

    void delete(long id);
}