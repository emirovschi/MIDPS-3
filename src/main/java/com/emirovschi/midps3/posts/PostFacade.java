package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.list.dto.PageDTO;
import com.emirovschi.midps3.posts.dto.CommentDTO;
import com.emirovschi.midps3.images.dto.ImageDTO;
import com.emirovschi.midps3.posts.dto.PostDTO;
import com.emirovschi.midps3.search.dto.SearchDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostFacade
{
    PageDTO<PostDTO> search(SearchDTO search, Pageable pageable);

    PageDTO<PostDTO> getVotes(SearchDTO search, Pageable pageable);

    PostDTO getPost(long id);

    ImageDTO getPostImage(long id);

    ImageDTO getPostPreview(long id);

    void voteUp(long id);

    void voteDown(long id);

    void comment(long id, CommentDTO comment);

    PostDTO create(String title, List<String> tags, String imageType, byte[] image);

    void delete(long id);
}
