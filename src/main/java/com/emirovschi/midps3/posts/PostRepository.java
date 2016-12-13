package com.emirovschi.midps3.posts;

import com.emirovschi.midps3.posts.models.PostModel;
import com.emirovschi.midps3.tags.models.TagModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

import static com.emirovschi.midps3.posts.PostConstants.SEARCH_POSTS;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>
{
    @Query(SEARCH_POSTS)
    Page<PostModel> search(@Param("adds") Set<TagModel> adds, @Param("excludes") Set<TagModel> excludes,
                           @Param("firstId") final Long firstId, Pageable pageable);

    PostModel findById(long id);
}
