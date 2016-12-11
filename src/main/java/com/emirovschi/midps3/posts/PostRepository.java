package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.tags.models.TagModel;
import com.emirovschi.midps3.users.models.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>
{
    Page<PostModel> findByTitleLikeAndTagsInAndUserIn(String title, Set<TagModel> tags, Set<UserModel> users, Pageable pageable);

    PostModel findById(long id);

    Long countByTags(TagModel tag);
}
