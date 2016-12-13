package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.list.dto.ListDTO;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.posts.dto.ImageDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.search.dto.SearchDTO;

import java.util.List;

public interface PostFacade
{
    ListDTO<PostDTO> search(SearchDTO search, Long lastId);

    PostDTO getPost(long id);

    ImageDTO getPostImage(long id);

    void voteUp(long id);

    void voteDown(long id);

    void comment(long id, CommentDTO comment);

    PostDTO create(String title, List<String> tags, String imageType, byte[] image);

    void delete(long id);
}
